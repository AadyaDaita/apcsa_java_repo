package com.nighthawk.spring_portfolio;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClothesApiController{

    void method1()
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
        
    };
    
    public static void main(String[] args) {
    {
        ClothesApiController api_ctrl = new ClothesApiController();
        api_ctrl.method1();
    }
}
}
