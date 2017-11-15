package org.fage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * @author Caizhfy
 * @email caizhfy@163.com
 * @createTime 2017年10月30日
 * @description Springboot-jpa学习创建步骤：
 * 						1.创建项目 
 *						2.添加依赖，填写配置类
 *						3.配置application.yml
 *						4.配置实体jpa关系
 *						5.继承jpaRepository
 *						6.编写测试用例
 */

@SpringBootApplication
@ImportAutoConfiguration(value=JpaConfiguration.class)
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
