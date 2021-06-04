package com.southwind.repository;

import com.southwind.entity.Location;
import com.southwind.entity.Menu;

import java.util.List;
import java.util.Map;

public interface BrandRepository {
    public Location findById(long id);
    public List<Location> findAll();
}

