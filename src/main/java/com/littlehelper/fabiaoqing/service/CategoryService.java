package com.littlehelper.fabiaoqing.service;

import com.littlehelper.fabiaoqing.dto.CategoryDTO;
import com.littlehelper.fabiaoqing.expection.BusinessException;

import java.util.List;

/**
 * 类别服务接口
 *
 * @author littlehelper
 * @date 2019-05-29
 */
public interface CategoryService {
    /**
     * 查找所有类别
     *
     * @return 所有类别
     * @throws BusinessException 业务异常
     */
    List<CategoryDTO> findAll() throws BusinessException;
}
