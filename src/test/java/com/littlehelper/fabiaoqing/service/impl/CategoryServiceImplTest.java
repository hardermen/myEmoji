package com.littlehelper.fabiaoqing.service.impl;

import com.littlehelper.fabiaoqing.dto.CategoryDTO;
import com.littlehelper.fabiaoqing.expection.BusinessException;
import com.littlehelper.fabiaoqing.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryServiceImplTest {

    @Resource
    private CategoryService categoryService;

    @Test
    public void findAll() throws BusinessException {
        List<CategoryDTO> categoryDOList = categoryService.findAll();
        assertEquals(16, categoryDOList.size());
    }
}