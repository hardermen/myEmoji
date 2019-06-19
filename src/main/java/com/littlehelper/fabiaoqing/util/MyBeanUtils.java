package com.littlehelper.fabiaoqing.util;

import com.littlehelper.fabiaoqing.domainobject.CategoryDO;
import com.littlehelper.fabiaoqing.domainobject.EmoticonDO;
import com.littlehelper.fabiaoqing.domainobject.PackageDO;
import com.littlehelper.fabiaoqing.dto.CategoryDTO;
import com.littlehelper.fabiaoqing.dto.EmoticonDTO;
import com.littlehelper.fabiaoqing.dto.PackageDTO;
import com.littlehelper.fabiaoqing.viewobject.CategoryVO;
import com.littlehelper.fabiaoqing.viewobject.EmoticonVO;
import com.littlehelper.fabiaoqing.viewobject.PackageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * JavaBean转换类
 *
 * @author littlehelper
 * @date 2019-05-31
 */
public class MyBeanUtils {

    /**
     * 列表展示表情包的最大张数
     */
    private static final int MAX_LIST_COUNT = 3;


    /**
     * 类别DO转DTO
     *
     * @param categoryDO 类别DO
     * @return 类别DTO
     */
    public static CategoryDTO convertCategoryDOToDTO(CategoryDO categoryDO) {
        CategoryDTO categoryDTO = new CategoryDTO();
        BeanUtils.copyProperties(categoryDO, categoryDTO);
        return categoryDTO;
    }

    /**
     * 类别DTO转VO
     *
     * @param categoryDTO 类别DTO
     * @return 类别VO
     */
    public static CategoryVO convertCategoryDTOToVO(CategoryDTO categoryDTO) {
        CategoryVO categoryVO = new CategoryVO();
        BeanUtils.copyProperties(categoryDTO, categoryVO);
        return categoryVO;
    }

    /**
     * 表情包DO转DTO
     *
     * @param packageDO       表情包DO
     * @param emoticonDTOList 表情列表
     * @return 表情包DTO
     */
    public static PackageDTO convertPackageDOToDTO(PackageDO packageDO, List<EmoticonDTO> emoticonDTOList) {
        PackageDTO packageDTO = new PackageDTO();
        BeanUtils.copyProperties(packageDO, packageDTO);
        packageDTO.setEmoticonDTOList(emoticonDTOList);
        return packageDTO;
    }


    /**
     * 表情包DTO转VO
     *
     * @param packageDTO 表情包DTO
     * @return 表情包VO
     */
    public static PackageVO convertPackageDTOToVO(PackageDTO packageDTO) {
        PackageVO packageVO = new PackageVO();
        BeanUtils.copyProperties(packageDTO, packageVO);
        List<EmoticonDTO> emoticonDTOList = packageDTO.getEmoticonDTOList();
        if (!CollectionUtils.isEmpty(emoticonDTOList)) {
            packageVO.setCount(emoticonDTOList.size());
            packageVO.setList(emoticonDTOList.subList(0, emoticonDTOList.size() > MAX_LIST_COUNT ? MAX_LIST_COUNT : emoticonDTOList.size())
                    .stream().map(MyBeanUtils::convertEmoticonDTOToVO).collect(Collectors.toList()));
        }
        return packageVO;
    }

    /**
     * 表情DO转DTO
     *
     * @param emoticonDO 表情DO
     * @return 表情DTO
     */
    public static EmoticonDTO convertEmoticonDOToDTO(EmoticonDO emoticonDO) {
        EmoticonDTO emoticonDTO = new EmoticonDTO();
        BeanUtils.copyProperties(emoticonDO, emoticonDTO);
        return emoticonDTO;
    }

    /**
     * 表情DTO转VO
     *
     * @param emoticonDTO 表情DTO
     * @return 表情VO
     */
    public static EmoticonVO convertEmoticonDTOToVO(EmoticonDTO emoticonDTO) {
        EmoticonVO emoticonVO = new EmoticonVO();
        BeanUtils.copyProperties(emoticonDTO, emoticonVO);
        return emoticonVO;
    }
}
