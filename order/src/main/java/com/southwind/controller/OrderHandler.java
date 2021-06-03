package com.southwind.controller;

import com.southwind.entity.Order;
import com.southwind.entity.OrderVO;
import com.southwind.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/save")
    public void save(@RequestBody Order order){
        orderRepository.save(order);
    }

    @GetMapping("/findAllByUid/{index}/{limit}/{uid}")
    public OrderVO findAllByUid(@PathVariable("index") int index, @PathVariable("limit") int limit, @PathVariable("uid") long uid){
        OrderVO orderVO = new OrderVO();
//        orderVO.setCode(0);
        orderVO.setMsg("");
        orderVO.setCount(orderRepository.countByUid(uid));
        orderVO.setData(orderRepository.findAllByUid(index, limit,uid));
        return orderVO;
    }

//    @GetMapping("/findAll/{index}/{limit}")
//    public OrderVO findAllByState( @PathVariable("index") int index, @PathVariable("limit") int limit){
//        OrderVO orderVO = new OrderVO();
//        orderVO.setMsg("");
//        orderVO.setCount(orderRepository.count());
//        orderVO.setData(orderRepository.findAll(index,limit));
//        return orderVO;
//    }

    @GetMapping("/findAll/{index}/{limit}")
    public OrderVO findAllByState( @PathVariable("index") int index, @PathVariable("limit") int limit){
        OrderVO orderVO = new OrderVO();
        orderVO.setMsg("");
        orderVO.setCount(orderRepository.count());
        orderVO.setData(orderRepository.findAll(index,limit));
        return orderVO;
    }

    @PutMapping("/updateState/{id}")
    public void updateState(@PathVariable("id") long id){
        orderRepository.updateState(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") long id){
        orderRepository.updateState(id);
    }


}
