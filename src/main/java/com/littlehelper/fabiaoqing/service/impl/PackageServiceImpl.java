package com.littlehelper.fabiaoqing.service.impl;

import com.littlehelper.fabiaoqing.dao.PackageDAO;
import com.littlehelper.fabiaoqing.domainobject.PackageDO;
import com.littlehelper.fabiaoqing.dto.EmoticonDTO;
import com.littlehelper.fabiaoqing.dto.PackageDTO;
import com.littlehelper.fabiaoqing.expection.BusinessException;
import com.littlehelper.fabiaoqing.response.ResponseEnum;
import com.littlehelper.fabiaoqing.service.EmoticonService;
import com.littlehelper.fabiaoqing.service.PackageService;
import com.littlehelper.fabiaoqing.util.MyBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 表情包服务实现类
 *
 * @author littlehelper
 * @date 2019-05-30
 */
@Service
@Slf4j
public class PackageServiceImpl implements PackageService {

    /**
     * Redis键的前缀，为了区分不同的DO
     */
    private static final String REDIS_PREFIX = "package_";

    @Resource
    private PackageDAO packageDAO;
    @Resource
    private EmoticonService emoticonService;
    @Resource
    private RedisTemplate<String, List<PackageDO>> redisTemplate;

    @Override
    public List<PackageDTO> findAll(String parentId, Integer page, Integer pageSize) throws BusinessException {
        String redisKey = REDIS_PREFIX + "p_" + page + "_s_" + pageSize + "_" + parentId;
        List<PackageDO> packageDOList = redisTemplate.opsForValue().get(redisKey);
        //当缓存中无数据时，从数据库中查询，无论查出数据是否为空都存入缓存，下次再次查询直接返回缓存中的数据，避免缓存击穿
        if (packageDOList == null) {
            packageDOList = packageDAO.selectByParentId(parentId);
            redisTemplate.opsForValue().set(redisKey, packageDOList);
        }
        if (CollectionUtils.isEmpty(packageDOList)) {
            throw new BusinessException(ResponseEnum.PACKAGE_NOT_FOUND);
        }
        return packageDOList.stream()
                .map(this::getPackageDTO)
                .filter(packageDTO -> !CollectionUtils.isEmpty(packageDTO.getEmoticonDTOList()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PackageDTO> findByKeyword(String keyword, Integer page, Integer pageSize) throws BusinessException {
        String redisKey = REDIS_PREFIX + "p_" + page + "_s_" + pageSize + "_" + keyword;
        List<PackageDO> packageDOList = redisTemplate.opsForValue().get(redisKey);
        if (packageDOList == null) {
            packageDOList = packageDAO.selectByNameLike(keyword);
            redisTemplate.opsForValue().set(redisKey, packageDOList);
        }
        if (CollectionUtils.isEmpty(packageDOList)) {
            throw new BusinessException(ResponseEnum.PACKAGE_NOT_FOUND);
        }
        return packageDOList.stream()
                .map(this::getPackageDTO)
                .filter(packageDTO -> !CollectionUtils.isEmpty(packageDTO.getEmoticonDTOList()))
                .collect(Collectors.toList());
    }

    private PackageDTO getPackageDTO(PackageDO packageDO) {
        List<EmoticonDTO> emoticonDTOList = new ArrayList<>();
        try {
            emoticonDTOList = emoticonService.findByParentId(packageDO.getObjectId());
        } catch (BusinessException e) {
            e.printStackTrace();
        }
        return MyBeanUtils.convertPackageDOToDTO(packageDO, emoticonDTOList);
    }
}
