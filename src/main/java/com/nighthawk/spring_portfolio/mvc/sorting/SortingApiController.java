package com.nighthawk.spring_portfolio.mvc.sorting;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nighthawk.spring_portfolio.mvc.sorting.SortingAnimationGenerator;
import com.nighthawk.spring_portfolio.mvc.sorting.SortingAlgorithms.*;

@RestController
@RequestMapping("/api/sorting")
public class SortingApiController {
    
}
