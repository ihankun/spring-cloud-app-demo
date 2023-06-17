package com.ihankun.demo.app.test.controller;

import com.ihankun.core.base.response.ResponseResult;
import com.ihankun.demo.app.test.service.HelloService;
import com.ihankun.open.api.mxnzp.holiday.entity.vo.HolidayVO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/holiday/{date}")
    public ResponseResult<HolidayVO> holiday(@PathVariable("date") String date) {
        return ResponseResult.success(helloService.holiday(date));
    }
}
