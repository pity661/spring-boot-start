package com.example.demo.propertiy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-09-04 13:56
 */
@Component
public class DemoProperties {

    @Value("${demo.prop.name}")
    private String name;

    @Value("${demo.prop.real_name}")
    private String realName;

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }
}
