package com.southwind.repository;

import com.southwind.entity.Location;
import com.southwind.entity.Type;

import java.util.List;

public interface LocationRepository {
    public Location findById(long id);
    public List<Location> findAll();
}
