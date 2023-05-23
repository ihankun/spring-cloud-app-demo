package com.ihankun.demo.app.test.controller;

import com.ihankun.core.base.api.ResponseResult;
import com.ihankun.demo.app.test.service.HelloService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hankun
 */
@Api(tags = "申请单控制器")
@Slf4j
@RestController
@RequestMapping("/app/test")
public class HelloController {

    @Resource
    private HelloService helloService;

    @GetMapping("/hello")
    public ResponseResult<String> hello() {
        return ResponseResult.success("Hello World!");
    }

    @GetMapping("/helloApi")
    public ResponseResult<String> helloApi() {
        return ResponseResult.success(helloService.helloApi());
    }
}
