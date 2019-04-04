package com.ServerCloud.service.impl;

import com.ServerCloud.dao.IGoodssqlDao;
import com.ServerCloud.model.Graduation_goods_sql;
import com.ServerCloud.service.IgoodssqlService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("goodssqlService")
public class goodssqlServiceImpl implements IgoodssqlService {

    @Resource
    private IGoodssqlDao goodssqlDao;


    @Override
    public List<Graduation_goods_sql> selectGoodssql() {
        return goodssqlDao.selectGoodssql();
    }
}
