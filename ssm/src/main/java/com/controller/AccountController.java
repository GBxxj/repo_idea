package com.controller;


import com.domain.Account;

import com.service.AccountService;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    /*
    *查询所有的用户
    * */
    @RequestMapping("/findAll")
    public String findAll(Model model){
    //实现查询所有的账户
    List<Account> list = accountService.findAll();

     //把封装好的list存到model中
     model.addAttribute("list",list);

     //跳转到list.jsp页面（需要在springmvc中配置前缀后缀）
     return "list";
}

    /*
    * 增加账户
    * */
    @RequestMapping("/save")
    public String save(Account account){
        accountService.save(account);
        //获取add.js界面填入的信息并封装成account然后存到数据库，再从数据库获取新的数据
        return "redirect:/account/findAll";
    }

    /*
    * 根据id查询账户信息，完成账户回显
    * */
    @RequestMapping("/findById")
    public String findById(Integer id,Model model){
        Account account=accountService.findById(id);

        //存到model中
        model.addAttribute("account",account);

        //视图跳转
        return "update";

    }

    /*
    * 更新方法
    * */
    @RequestMapping("/update")
    public String update(Account account){
        //获取update.js界面填入的信息并封装成account然后存到数据库,再从数据库获取新的数据
        accountService.update(account);
        return "redirect:/account/findAll";

    }

    /*
    * 批量删除
    * */
    @RequestMapping("/deleteBatch")
    public String deleteBatch(Integer[] ids){
        accountService.deleteBatch(ids);
        return "redirect:/account/findAll";
    }
}
