package com.ServerCloud.service;


import com.ServerCloud.model.Graduation_Historical;

import java.util.List;

public interface IgoodsHistoricalService {
    public List<Graduation_Historical> selectHistorical(String userid);
}
