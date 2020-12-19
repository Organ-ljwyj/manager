package com.lw;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yujun.wu
 * @version 1.0
 * @create date 2020/12/16 21:07
 * @Description: 学生信息管理系统启动入口
 */
@SpringBootApplication
@MapperScan("com.lw")
@Slf4j
public class App {
    public static void main(String[] args) {
        try{
            SpringApplication.run(App.class,args);
            log.info("App start server");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
