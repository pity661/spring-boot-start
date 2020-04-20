package com.example.demo.propertiy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-04 16:48
 */
@Component
public class ConstructProperties {
    private String name;
    private String realName;

    public ConstructProperties(
            @Value("${demo.prop.name}") String name, @Value("${demo.prop.real_name}") String realName) {
        this.name = name;
        this.realName = realName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
