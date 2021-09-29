package com.example.demo.feign;

import com.example.demo.model.Pojo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;


@Component
@FeignClient(name="demo", url = "http://4solut.com.br/trabalho/MOCK_DATA.json")
public interface IFeignClientExample {

    @GetMapping(name = "teste")
    ResponseEntity<Pojo> findById();

}
