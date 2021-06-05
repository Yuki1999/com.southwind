package com.southwind.repository;

import com.southwind.entity.Log;

import java.util.List;
import java.util.Map;

public interface LogRepository {

    List<Map<String,Object>> selectAll();

    int insertSelective(Log record);

}
