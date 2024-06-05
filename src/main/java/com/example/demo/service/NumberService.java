package com.example.demo.service;

import com.example.demo.response.NumberRes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NumberService {

    Long add(int num1, int num2);

    Long minus(int num1, int num2);

    List<NumberRes> res();
}
