package cn.piao888.dynamic.service.Impl;

import cn.piao888.dynamic.domain.Role;
import cn.piao888.dynamic.domain.User;
import org.junit.jupiter.api.Test;
import cn.piao888.dynamic.DynamicApplication;
import cn.piao888.dynamic.service.LoginService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = {DynamicApplication.class})
@RunWith(SpringRunner.class)
class LoginServiceImplTest {
    @Autowired
    private LoginService loginService;


    @Test
    void getUserByName() {
        loginService.getUserByName("BigRich.xu");
    }

    @Test
    void getSysUser() {
        loginService.getUserByName("BigRich.xu");
    }

    @Test
    void getRoles() {
        loginService.getRoles(1);
    }
}