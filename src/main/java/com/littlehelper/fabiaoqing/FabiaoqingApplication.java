package com.littlehelper.fabiaoqing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot启动类
 *
 * @author littlehelper
 * @date 2019-05-23
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.littlehelper.fabiaoqing.dao"})
public class FabiaoqingApplication {

    public static void main(String[] args) {
        SpringApplication.run(FabiaoqingApplication.class, args);
    }

}
