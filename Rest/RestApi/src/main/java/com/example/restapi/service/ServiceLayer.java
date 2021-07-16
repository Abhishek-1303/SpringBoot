package com.example.restapi.service;

import com.example.restapi.VO.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ServiceLayer {

    private final RestTemplate restTemplate;

    @Autowired
    public ServiceLayer(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

//    public List<User> ConsumeAPI(){
//    //    return restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos"
//    //            , User.class);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<String>(headers);
//        ResponseEntity<List<User>> responseEntity =
//                restTemplate.exchange(
//                        "https://jsonplaceholder.typicode.com/todos",
//                        HttpMethod.GET,
//                        entity,
//                        new ParameterizedTypeReference<List<User>>() {}
//
//                );
//        List<User> users = responseEntity.getBody();
//        return new ArrayList<>(users);
//    }

    public Object ConsumeHotelAPI(String country) throws JsonProcessingException {

        //setting Headers
        HttpHeaders header=new HttpHeaders();
        header.set("Content-Type","application/json");
        header.set("Aceept","application/json");
        header.set("X-RapidAPI-Key","6cecc32233mshd4847d56c9b68ccp1155e6jsn13e5c55f17f7");
        header.set("X-RapidAPI-Host","hotels4.p.rapidapi.com");
        HttpEntity<String> entity=new HttpEntity<String>(header);

        //getting reponse
        ResponseEntity<String> response=restTemplate.exchange(
                "https://hotels4.p.rapidapi.com/locations/search?query={country}",
                HttpMethod.GET,
                entity,
                String.class,
                country
        );

        String responseString=response.getBody();
        ObjectMapper mapper=new ObjectMapper();
        Map<String, Object> map = mapper.readValue(responseString,new TypeReference<Map<String,Object>>(){});

        System.out.println(map.entrySet());
        System.out.println(map.get("suggestions"));

        Object list=map.get("suggestions");
        System.out.println("Object : "+list);

        String suggestionList=list.toString();
        System.out.println("suggestion list : "+suggestionList);
        //System.out.println(map.get("suggestions").getClass().getSimpleName());
        String newString=suggestionList.substring(19);
        System.out.println(newString);



        return map.get("suggestions");
    }
}
