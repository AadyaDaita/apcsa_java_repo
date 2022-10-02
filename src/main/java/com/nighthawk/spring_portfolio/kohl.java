package com.nighthawk.spring_portfolio;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // annotation to create a RESTful web services
@RequestMapping("/api/kohls")  //prefix of API
public class kohl {
    
    private JSONObject body; //last run result
    private HttpStatus status; //last run status
    String last_run = null; //last run day of month

    // GET Covid 19 Stats
    @GetMapping("/monthly")   //added to end of prefix as endpoint

    public ResponseEntity<JSONObject> kohls() {

        //calls API once a day, sets body and status properties
        String today = new Date().toString().substring(0,500); 
        if (last_run == null || !today.equals(last_run))
        {
            try {

                HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://kohls.p.rapidapi.com/categories/list"))
                    .header("X-RapidAPI-Key", "032e265a00mshecae9e8c6d29bd9p15d1e3jsn175f358f494b")
                    .header("X-RapidAPI-Host", "kohls.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
                HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
            
                    
            } catch (Exception e) {
                // TODO: handle exception
                /*If the exception were an IO type, inform the user that there is no file */
            }
            
            
        }

        //return JSONObject in RESTful style
        return new ResponseEntity<>(body, status);
    }

    public static void main(String[] args) {
        {
            kohl api_ctrl = new kohl();
            api_ctrl.kohls();
        }
    }
}
