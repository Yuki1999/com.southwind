package com.southwind.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.southwind.entity.Log;
import com.southwind.entity.Order;
import com.southwind.entity.OrderVO;
import com.southwind.repository.LogRepository;
import com.southwind.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

@RestController
@RequestMapping("/order")
public class OrderHandler {

    private SimpleFormatter sf = new SimpleFormatter();

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private LogRepository logRepository;

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

    @GetMapping("logs")
    public Map<String,Object> logs(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize){
        Map<String,Object> result = new HashMap<>();
        PageHelper.startPage(pageNum,pageSize);
        List<Map<String,Object>> logs = logRepository.selectAll();
        result.put("list",logs);
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(logs);
        result.put("total", pageInfo.getTotal());

        return result;
    }

    @PostMapping("addLog")
    public int addLog(@RequestBody Log log){
        System.out.println(log);
        return logRepository.insertSelective(log);
    }
}
