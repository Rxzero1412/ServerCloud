package com.ServerCloud.dao;


import com.ServerCloud.model.Graduation_Historical;

import java.util.List;

public interface IGoodsHistoricalDao {

    public List<Graduation_Historical> selectHistorical(String userid);
   

}
