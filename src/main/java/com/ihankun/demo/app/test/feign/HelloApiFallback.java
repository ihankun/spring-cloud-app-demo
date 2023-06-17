package com.ihankun.demo.app.test.feign;

import com.ihankun.core.base.response.ResponseResult;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloApiFallback implements FallbackFactory<HelloApiFeign> {


    @Override
    public HelloApiFeign create(Throwable throwable) {
        return new HelloApiFeign() {

            @Override
            public ResponseResult<String> hello() {
                return ResponseResult.fallback(throwable);
            }
        };
    }
}
