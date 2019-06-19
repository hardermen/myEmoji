package com.littlehelper.fabiaoqing.service.impl;

import com.littlehelper.fabiaoqing.domainobject.PackageDO;
import com.littlehelper.fabiaoqing.expection.BusinessException;
import com.littlehelper.fabiaoqing.service.PackageService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class PackageServiceImplTest {

    @Resource
    private PackageService packageService;
    @Resource
    private RedisTemplate<String, List<PackageDO>> redisTemplate;

    @Test
    public void findAll() throws BusinessException {
        List<PackageDO> packageDOList = redisTemplate.opsForValue().get("package_aaa");
        List<PackageDO> packageDOList1 = redisTemplate.opsForValue().get("package_bbb");
        assertNotNull(packageDOList);
        assertNull(packageDOList1);
    }
}