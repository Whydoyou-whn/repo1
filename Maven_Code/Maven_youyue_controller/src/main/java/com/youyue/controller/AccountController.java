package com.youyue.controller;


import com.youyue.domain.Account;
import com.youyue.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequestMapping("/account")
@Controller
public class AccountController {
    @Autowired
    private AccountService service;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("控制层的查询执行了");
        List<Account> list = service.findAll();
        model.addAttribute("list",list);//存入reques域
        return "success";
    }

    @RequestMapping("/saveAccount")
    public void saveAccount(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(account);
        service.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return;
    }
}
