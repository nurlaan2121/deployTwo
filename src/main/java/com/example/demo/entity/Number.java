package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "numbers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Number {
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen")
    @SequenceGenerator(name = "gen",allocationSize = 1)
    @Id
    private Long id;
    private int num1;
    private int num2;
    private char operation;
}
