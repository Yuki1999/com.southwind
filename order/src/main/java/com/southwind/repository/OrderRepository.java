package com.southwind.repository;

import com.southwind.entity.Order;

import java.util.List;

public interface OrderRepository {
    public void save(Order order);
    public List<Order> findAllByUid(int index,int limit,long uid);
    public int countByUid(long uid);
//    public void deleteByMid(long mid);
//    public void deleteByUid(long uid);
    public List<Order> findAllByState(int index,int limit,int state);
    public List<Order> findAll(int index,int limit);
//    public int countByState(int state);
    public int count();
    public void updateState(long id);
}
