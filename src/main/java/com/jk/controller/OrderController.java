package com.jk.controller;

import com.jk.bean.OrderBean;
import com.jk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class OrderController {
      @Autowired
      private OrderService service;
@RequestMapping("queryOrder")
@ResponseBody
      public HashMap<String ,Object> queryOrder(Integer page, Integer limit, OrderBean orderBean, Model model){


        List<OrderBean> list1 = service.getOrder(orderBean);

        List<OrderBean> list2 = service.getOrderByCondition(page,limit,orderBean);

          HashMap<String,Object> tableData =new HashMap<String,Object>();
         Long money = service.getMoney();
        tableData.put("code", 0);
        tableData.put("msg", "");
        tableData.put("count", list1.size());
        tableData.put("data", list2);
        model.addAttribute("money",money);
        model.addAttribute("count",list1.size());
        return tableData;

    }


    @RequestMapping("updateddstatus")
    @ResponseBody
    public void updateddstatus(Integer id,Integer status){
        service.updateddstatus(id,status);

    }








}
