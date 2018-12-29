package com.guazi.component.http.controller;

import com.alibaba.fastjson.JSON;
import com.guazi.component.http.vo.ResponseEntity;
import com.guazi.component.http.vo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Using IntelliJ IDEA.
 *
 * @author XIANYINGDA at 2018-12-29 11:07
 */
@Controller
@Slf4j
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/01")
    @ResponseBody
    public Object testWeb01(String name) {
        log.info("传入参数：{}", name);
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        return map;
    }

    @RequestMapping("/02")
    @ResponseBody
    public Object testWeb02(Student student) {
        log.info("传入对象：{}", JSON.toJSONString(student));
        return ResponseEntity.success(student);
    }
}
