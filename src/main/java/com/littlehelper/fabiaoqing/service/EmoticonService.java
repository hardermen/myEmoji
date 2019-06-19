package com.littlehelper.fabiaoqing.service;

import com.littlehelper.fabiaoqing.dto.EmoticonDTO;
import com.littlehelper.fabiaoqing.expection.BusinessException;

import java.util.List;

/**
 * 表情服务接口
 *
 * @author littlehelper
 * @date 2019-05-30
 */
public interface EmoticonService {

    /**
     * 通过表情包id查询表情
     *
     * @param parentId 父id，也就是表情包id
     * @return 表情列表
     * @throws BusinessException 业务异常
     */
    List<EmoticonDTO> findByParentId(String parentId) throws BusinessException;

    /**
     * 通过id查询表情
     *
     * @param objectId id
     * @return 表情
     * @throws BusinessException 业务异常
     */
    EmoticonDTO findByObjectId(String objectId) throws BusinessException;
}
