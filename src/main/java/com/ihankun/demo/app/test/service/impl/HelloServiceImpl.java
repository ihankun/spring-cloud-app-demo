package com.ihankun.demo.app.test.service.impl;

import com.ihankun.core.base.exception.BusinessException;
import com.ihankun.core.base.response.ResponseResult;
import com.ihankun.core.commons.qrcode.QrCodeBuilder;
import com.ihankun.demo.app.test.feign.HelloApiFeign;
import com.ihankun.demo.app.test.service.HelloService;
import com.ihankun.open.api.mxnzp.holiday.HolidayApi;
import com.ihankun.open.api.mxnzp.holiday.entity.vo.HolidayVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hankun
 */
@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

    @Resource
    private HelloApiFeign helloApiFeign;

    @Resource
    private HolidayApi holidayApi;

    @Override
    public String helloApi() {
        ResponseResult<String> responseResult = helloApiFeign.hello();
        if(!responseResult.isSuccess()){
            throw BusinessException.build("查询出错");
        }
        return responseResult.getData();
    }

    @Override
    public HolidayVO holiday(String date) {
        ResponseResult<HolidayVO> responseResult = holidayApi.getDay(date);
        if(!responseResult.isSuccess()){
            throw BusinessException.build("查询出错"+responseResult.getMessage());
        }
        return responseResult.getData();
    }

    @Override
    public String qr() {
        String img = QrCodeBuilder.ins().create("测试", 50, 50);
        return img;
    }
}
