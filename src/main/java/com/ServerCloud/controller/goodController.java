package com.ServerCloud.controller;

import com.ServerCloud.model.Graduation_goods_sql;
import com.ServerCloud.service.IgoodssqlService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 83541 on 2018/12/15.
 */
@Controller
public class goodController {

    @Resource
    private IgoodssqlService goodssqlService;

    /**
     * 显示商品种类信息
     * */
    @RequestMapping("/showgoodssql.do")
    @ResponseBody
    public ModelAndView showgoodssql(Model model,HttpServletRequest request) {
        ModelAndView retMap = new ModelAndView();  //返回新的ModelAndView
        retMap.setViewName("../../goodssql");
        List<Graduation_goods_sql> listgoodssql=goodssqlService.selectGoodssql();
        model.addAttribute("listgoodssql", listgoodssql);
        return retMap;
    }


}
