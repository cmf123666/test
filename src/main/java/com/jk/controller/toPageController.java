package com.jk.controller;

import com.jk.bean.OrderBean;
import com.jk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class toPageController {
     @Autowired
     private OrderService service;
    @RequestMapping("orderPage")
    public String  page(Model model){
        List<OrderBean> list1 = service.getOrdercount();
        Long money = service.getMoney();
        model.addAttribute("money",money);
        model.addAttribute("count",list1.size());

        return "orderPage";
    }

    @RequestMapping("todetailsPage")
    public String todetails(Integer id,Model model){
       OrderBean  order = service.getOrderById(id);
        model.addAttribute("o",order);
                  return "todetailsPage";
    }




}
