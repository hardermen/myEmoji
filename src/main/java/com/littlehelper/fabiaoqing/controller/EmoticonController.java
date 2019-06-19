package com.littlehelper.fabiaoqing.controller;

import com.littlehelper.fabiaoqing.dto.EmoticonDTO;
import com.littlehelper.fabiaoqing.expection.BusinessException;
import com.littlehelper.fabiaoqing.response.ApiResult;
import com.littlehelper.fabiaoqing.response.ResponseEnum;
import com.littlehelper.fabiaoqing.service.EmoticonService;
import com.littlehelper.fabiaoqing.util.MyBeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 表情Controller
 *
 * @author littlehelper
 * @date 2019-05-31
 */
@RestController
@RequestMapping("/emoticon")
public class EmoticonController {

    @Resource
    private EmoticonService emoticonService;

    @GetMapping("/detail")
    public ApiResult getEmoticonById(@RequestParam(name = "id") String objectId) throws BusinessException {
        if (StringUtils.isEmpty(objectId)) {
            throw new BusinessException(ResponseEnum.EMOTICON_ID_EMPTY);
        }
        EmoticonDTO emoticonDTO = emoticonService.findByObjectId(objectId);
        return ApiResult.success(MyBeanUtils.convertEmoticonDTOToVO(emoticonDTO));
    }
}
