package com.example.restapi.service;

import com.example.restapi.VO.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


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

    public Location ConsumeHotelAPI(String country) throws JsonProcessingException {

        //setting Headers
        HttpHeaders header=new HttpHeaders();
        header.set("Content-Type","application/json");
        header.set("Aceept","application/json");
        header.set("X-RapidAPI-Key","6cecc32233mshd4847d56c9b68ccp1155e6jsn13e5c55f17f7");
        header.set("X-RapidAPI-Host","hotels4.p.rapidapi.com");
        HttpEntity<String> entity=new HttpEntity<String>(header);

        //getting reponse
//        ResponseEntity<JsonNode> response=restTemplate.exchange(
//                "https://hotels4.p.rapidapi.com/locations/search?query={country}",
//                HttpMethod.GET,
//                entity,
//                JsonNode.class,
//                country
//        );
//
//            JsonNode json=response.getBody();
//            System.out.println(json);

        ResponseEntity<Location> locationResponse=restTemplate.exchange(
                "https://hotels4.p.rapidapi.com/locations/search?query={country}",
                HttpMethod.GET,
                entity,
                Location.class,
                country
        );

        //System.out.println(locationResponse);
        Location location =locationResponse.getBody();
        System.out.println(location);
        List<Suggestion> hotelList= location.getSuggestions();

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


        //entities.stream().forEach(e->System.out.println(e.getDestinationId()));

        //getting destinationId for properties/list
        long destinationId=entities.get(0).getDestinationId();
        System.out.println(destinationId);

        final String url="https://hotels4.p.rapidapi.com/properties/list";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("destinationId", destinationId);


        //properties/list
        ResponseEntity<Hotel> hotelResponse=restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                Hotel.class
        );

        Hotel hotelBody= hotelResponse.getBody();
        System.out.println(hotelBody);

        List<Results> searchResults=hotelBody.getData().getBody().getSearchResults().getResults();
        searchResults.stream().forEach(e->System.out.println("Hotel Name : "+e.getName()+" Star Rating : "+e.getStarRating()+" "+e.getAddress()));

       return location;
    }
}
