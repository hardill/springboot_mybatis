package org.springboot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * sprintboot 配置类
 * 
 * @author hardill
 *
 */

@SpringBootApplication
@MapperScan("com.karle.tk.TkMapper") // 配置mapper扫描包
@EntityScan("com.karle.bean") // 配置实体类扫描
public class SpringBootMyBatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMyBatisApplication.class, args);
	}

}