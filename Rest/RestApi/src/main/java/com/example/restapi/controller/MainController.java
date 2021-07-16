package com.example.restapi.controller;

import com.example.restapi.VO.User;
import com.example.restapi.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    private final ServiceLayer serviceLayer;

    @Autowired
    public MainController(ServiceLayer serviceLayer){
        this.serviceLayer=serviceLayer;
    }

//    @GetMapping("/details")
//    public ResponseEntity<User> getDetails(){
//        //System.out.println(serviceLayer.ConsumeAPI());
//         return new ResponseEntity(serviceLayer.ConsumeAPI(), HttpStatus.OK);
//    }

    @GetMapping("/hotels/{country}")
    public Object getHotels(@PathVariable String country) throws Exception{
        return serviceLayer.ConsumeHotelAPI(country);
    }
}

