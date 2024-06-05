package com.example.demo.repo;

import com.example.demo.entity.Number;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberRepo extends JpaRepository<Number,Long> {
}
