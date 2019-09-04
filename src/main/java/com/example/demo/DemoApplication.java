package com.example.demo;

import com.example.demo.properties.ConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
// xxx config-2
@EnableConfigurationProperties({ConfigProperties.class})
public class DemoApplication {

  public static void main(String[] args) {
    // 如果不想配置被命令行修改
    SpringApplication application = new SpringApplication(DemoApplication.class);
    application.setAddCommandLineProperties(false);
    application.run(args);
    // SpringApplication.run(DemoApplication.class, args);
  }
}
