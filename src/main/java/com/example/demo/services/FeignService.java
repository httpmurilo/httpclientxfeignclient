package com.example.demo.services;

import com.example.demo.feign.IFeignClientExample;
import com.example.demo.model.Pojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FeignService {

    @Autowired
    private IFeignClientExample feignClientExample;

    public Pojo getPerson () {
        return feignClientExample.findById().getBody();
    }
}
