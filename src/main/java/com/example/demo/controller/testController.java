package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.model.Pojo;
import com.example.demo.services.FeignService;
import com.example.demo.services.HttpClientService;
import org.apache.coyote.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value="/test")
public class testController {

    @Autowired
    private FeignService feignService;
    @Autowired
    private HttpClientService httpClientService;

    @GetMapping(value = "/feign")
    public ResponseEntity<Pojo> getPersonByFeign() {
        Pojo pojos =  this.feignService.getPerson();
        return ResponseEntity.ok(pojos);
    }

    @GetMapping(value = "/http")
    public ResponseEntity<String> getPersonByHttp() throws IOException {
        JSONObject request = this.httpClientService.getPerson();
        return ResponseEntity.ok(request.toString());
    }

}
