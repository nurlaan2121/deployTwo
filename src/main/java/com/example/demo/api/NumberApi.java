package com.example.demo.api;

import com.example.demo.response.NumberRes;
import com.example.demo.service.NumberService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/api/number")
@RestController
@SecurityRequirement(name = "Bearer Token")
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class NumberApi {
    private final NumberService numberService;

    @GetMapping("/secured-endpoint")
    public String securedEndpoint() {
        return "This is a secured endpoint.";
    }
    @PostMapping("/add")
    public Long add(@RequestParam int num1,@RequestParam int num2){
        return numberService.add(num1,num2);
    }
    @PostMapping("/minus")
    public Long minus(@RequestParam int num1,@RequestParam int num2){
        return numberService.minus(num1,num2);
    }
    @GetMapping("/res")
    public List<NumberRes> minus(){
        return numberService.res();
    }


}