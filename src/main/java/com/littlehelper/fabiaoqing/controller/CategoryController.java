package com.littlehelper.fabiaoqing.controller;

import com.littlehelper.fabiaoqing.dto.CategoryDTO;
import com.littlehelper.fabiaoqing.expection.BusinessException;
import com.littlehelper.fabiaoqing.response.ApiResult;
import com.littlehelper.fabiaoqing.service.CategoryService;
import com.littlehelper.fabiaoqing.util.MyBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类别Controller
 *
 * @author littlehelper
 * @date 2019-05-23
 */
@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @GetMapping("/list")
    public ApiResult list() throws BusinessException {
        List<CategoryDTO> categoryDTOList = categoryService.findAll();
        return ApiResult.success(categoryDTOList.stream().map(MyBeanUtils::convertCategoryDTOToVO)
                .collect(Collectors.toList()));
    }

}
