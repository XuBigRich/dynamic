package cn.piao888.dynamic.controller;

import cn.piao888.dynamic.domain.Role;
import cn.piao888.dynamic.domain.User;
import cn.piao888.dynamic.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author 许鸿志
 * @since 2021/8/19
 */
@Controller
public class DynamicController {
    @Autowired
    private LoginService loginService;

    @GetMapping("listRoleByUsername")
    public List<Role> listRoleByUsername(String userName) {
        User user = loginService.getUserByName(userName);
        Integer uid = user.getId();
        List<Role> roles = loginService.getRoles(uid);
        return roles;
    }
}
