package com.ihankun.demo.app.test.feign;

import com.ihankun.core.base.response.ResponseResult;
import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "测试api")
@FeignClient(name = "${spring.application.api.demo.name}", fallbackFactory = HelloApiFallback.class)
@RequestMapping("/api/test")
public interface HelloApiFeign {

    @GetMapping("/helloApi")
    ResponseResult<String> hello();
}
