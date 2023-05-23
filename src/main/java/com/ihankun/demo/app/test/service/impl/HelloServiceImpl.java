package com.ihankun.demo.app.test.service.impl;

import com.ihankun.core.base.api.ResponseResult;
import com.ihankun.core.base.exception.BusinessException;
import com.ihankun.demo.app.test.feign.HelloApiFeign;
import com.ihankun.demo.app.test.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

    @Resource
    private HelloApiFeign helloApiFeign;

    @Override
    public String helloApi() {
        ResponseResult<String> responseResult = helloApiFeign.hello();
        if(!responseResult.isSuccess()){
            throw BusinessException.build("查询出错");
        }
        return responseResult.getData();
    }
}
