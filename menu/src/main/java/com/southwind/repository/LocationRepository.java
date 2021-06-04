package com.southwind.repository;

import com.southwind.entity.Location;
import com.southwind.entity.Menu;
import com.southwind.entity.Type;

import java.util.List;
import java.util.Map;

public interface LocationRepository {
    public Location findById(long id);
    public List<Location> findAll();
    List<Menu> selectByForeignKey(Map<String, Object> record);
}
