package com.nighthawk.spring_portfolio.mvc.calculator;


import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/calc")
public class CalculatorAPIController {

    /** GET isLeapYear endpoint
     * ObjectMapper throws exceptions on bad JSON
     *  @throws JsonProcessingException
     *  @throws JsonMappingException
     */
    @GetMapping("/{expression}")
    public ResponseEntity<JsonNode> getResult(@PathVariable String expression) throws JsonMappingException, JsonProcessingException {
      // Backend calc Object
      Calculator calc_obj = new Calculator(expression);
     

      // Turn Year Object into JSON
      ObjectMapper mapper = new ObjectMapper(); 
      JsonNode json_calc = mapper.readTree(calc_obj.jsonify()); // this requires exception handling

      return ResponseEntity.ok(json_calc);  // JSON response, see ExceptionHandlerAdvice for throws
    }

}