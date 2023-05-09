package com.coderpwh.cargo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author coderpwh
 */
@SpringBootApplication(scanBasePackages ={"com.coderpwh"})
//@MapperScan(basePackages = "com.coderpwh.cargo.infrastructure.persistence.mapper.*")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
