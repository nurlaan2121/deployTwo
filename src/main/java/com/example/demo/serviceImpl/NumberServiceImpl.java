package com.example.demo.serviceImpl;

import com.example.demo.entity.Number;
import com.example.demo.repo.NumberRepo;
import com.example.demo.response.NumberRes;
import com.example.demo.service.NumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NumberServiceImpl implements NumberService {
    private final NumberRepo numberRepo;

    @Override
    public Long add(int num1, int num2) {
        Number number = new Number();
        number.setOperation('+');
        number.setNum1(num1);
        number.setNum2(num2);
        numberRepo.save(number);
        return (long) (num1 + num2);
    }

    @Override
    public Long minus(int num1, int num2) {
        Number number = new Number();
        number.setOperation('-');
        number.setNum1(num1);
        number.setNum2(num2);
        numberRepo.save(number);
        return (long) (num1 - num2);
    }

    @Override
    public List<NumberRes> res() {
        List<Number> all = numberRepo.findAll();
        List<NumberRes> res = new ArrayList<>();
        for (Number number : all) {
            res.add(NumberRes.builder().id(number.getId()).num1(number.getNum1()).num2(number.getNum2()).operation(number.getOperation()).build());
        }
        return res;
    }
}
