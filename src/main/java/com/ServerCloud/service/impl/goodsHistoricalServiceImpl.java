package com.ServerCloud.service.impl;

import com.ServerCloud.dao.IGoodsHistoricalDao;
import com.ServerCloud.model.Graduation_Historical;
import com.ServerCloud.service.IgoodsHistoricalService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.Override;import java.lang.String;import java.util.List;

@Service("goodsHistoricalService")
public class goodsHistoricalServiceImpl implements IgoodsHistoricalService {

    @Resource
    private IGoodsHistoricalDao goodsHistoricalDao;
    @Override
    public List<Graduation_Historical> selectHistorical(String userid) {
        return goodsHistoricalDao.selectHistorical(userid);
    }
}
