package com.ihankun.demo.app.test.service;

import com.ihankun.open.api.mxnzp.holiday.entity.vo.HolidayVO;

public interface HelloService {

    String helloApi();

    HolidayVO holiday(String date);

    String qr();
}
