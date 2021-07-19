package com.example.restapi.service;

import com.example.restapi.VO.Entities;
import com.example.restapi.VO.Hotel;
import com.example.restapi.VO.Suggestion;
import com.example.restapi.VO.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.*;
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

    public Hotel ConsumeHotelAPI(String country) throws JsonProcessingException {

        //setting Headers
        HttpHeaders header=new HttpHeaders();
        header.set("Content-Type","application/json");
        header.set("Aceept","application/json");
        header.set("X-RapidAPI-Key","6cecc32233mshd4847d56c9b68ccp1155e6jsn13e5c55f17f7");
        header.set("X-RapidAPI-Host","hotels4.p.rapidapi.com");
        HttpEntity<String> entity=new HttpEntity<String>(header);

        //getting reponse
        ResponseEntity<JsonNode> response=restTemplate.exchange(
                "https://hotels4.p.rapidapi.com/locations/search?query={country}",
                HttpMethod.GET,
                entity,
                JsonNode.class,
                country
        );

            JsonNode json=response.getBody();
            //System.out.println(json);

        ResponseEntity<Hotel> hotelResponse=restTemplate.exchange(
                "https://hotels4.p.rapidapi.com/locations/search?query={country}",
                HttpMethod.GET,
                entity,
                Hotel.class,
                country
        );

        //System.out.println(hotelResponse);
        Hotel hotel=hotelResponse.getBody();
        System.out.println(hotel);
        List<Suggestion> hotelList=hotel.getSuggestions();

//        List<List<Entities>> entities=hotelList
//                .stream()
//                .map(suggestion -> suggestion.getEntities()).collect(Collectors.toList());
//
//        List<Entities> entitiesList=entities.stream()
//                .flatMap(Collection::stream)
//                .collect(Collectors.toList());

                List<Entities> entities=hotelList
                .stream()
                .map(suggestion -> suggestion.getEntities())
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());


        entities.stream().forEach(e->System.out.println(e.getName()+":"+e.getType()));



//        ObjectMapper mapper=new ObjectMapper();
//        Map<String, Object> map = mapper.readValue(responseString,new TypeReference<Map<String,Object>>(){});
//
//        System.out.println(map.entrySet());
//        System.out.println(map.get("suggestions"));
//
//        Object list=map.get("suggestions");
//        System.out.println("Object : "+list);
//
//        String suggestionList=list.toString();
//        System.out.println("suggestion list : "+suggestionList);
//        //System.out.println(map.get("suggestions").getClass().getSimpleName());
//        String newString=suggestionList.substring(19);
//        System.out.println(newString);
//


       return hotel;
    }
}
