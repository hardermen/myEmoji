package com.littlehelper.fabiaoqing.service.impl;

import com.littlehelper.fabiaoqing.dao.EmoticonDAO;
import com.littlehelper.fabiaoqing.domainobject.EmoticonDO;
import com.littlehelper.fabiaoqing.dto.EmoticonDTO;
import com.littlehelper.fabiaoqing.expection.BusinessException;
import com.littlehelper.fabiaoqing.response.ResponseEnum;
import com.littlehelper.fabiaoqing.service.EmoticonService;
import com.littlehelper.fabiaoqing.util.MyBeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 表情服务实现类
 *
 * @author littlehelper
 * @date 2019-05-30
 */
@Service
public class EmoticonServiceImpl implements EmoticonService {

    /**
     * Redis键的前缀，为了区分不同的DO
     */
    private static final String REDIS_PREFIX = "emoticon_";

    @Resource
    private EmoticonDAO emoticonDAO;
    @Resource
    private RedisTemplate<String, List<EmoticonDO>> redisTemplate;

    @Override
    public List<EmoticonDTO> findByParentId(String parentId) throws BusinessException {
        List<EmoticonDO> emoticonDOList = redisTemplate.opsForValue().get(REDIS_PREFIX + parentId);
        if (emoticonDOList == null) {
            emoticonDOList = emoticonDAO.selectByParentId(parentId);
            redisTemplate.opsForValue().set(REDIS_PREFIX + parentId, emoticonDOList);
        }
        if (CollectionUtils.isEmpty(emoticonDOList)) {
            throw new BusinessException(ResponseEnum.EMOTICON_NOT_FOUNT);
        }
        return emoticonDOList.stream()
                .map(MyBeanUtils::convertEmoticonDOToDTO).collect(Collectors.toList());
    }

    @Override
    public EmoticonDTO findByObjectId(String objectId) throws BusinessException {
        List<EmoticonDO> emoticonDOList = redisTemplate.opsForValue().get(REDIS_PREFIX + objectId);
        if (emoticonDOList == null) {
            emoticonDOList = emoticonDAO.selectByObjectId(objectId);
            redisTemplate.opsForValue().set(REDIS_PREFIX + objectId, emoticonDOList);
        }
        if (CollectionUtils.isEmpty(emoticonDOList)) {
            throw new BusinessException(ResponseEnum.EMOTICON_NOT_FOUNT);
        }
        return MyBeanUtils.convertEmoticonDOToDTO(emoticonDOList.get(0));
    }
}
