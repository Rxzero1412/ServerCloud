package com.ServerCloud.controller;

import com.ServerCloud.model.Graduation_Historical;
import com.ServerCloud.service.IgoodsHistoricalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.String;import java.util.List;

/**
 * Created by 83541 on 2018/12/15.
 */
@Controller
public class goodHistoricalController {

    @Resource
    private IgoodsHistoricalService goodsHistoricalService;

    @RequestMapping("/showhistorical.do")
    @ResponseBody
    public ModelAndView showhistorical(String userid,Model model,HttpServletRequest request) {
        ModelAndView retMap = new ModelAndView();  //返回新的ModelAndView
        retMap.setViewName("../../goodshistorical");
        List<Graduation_Historical> showhistorical=goodsHistoricalService.selectHistorical(userid);
        model.addAttribute("showhistorical", showhistorical);
        return retMap;
    }


}
