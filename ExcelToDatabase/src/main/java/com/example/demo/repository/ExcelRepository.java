package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.EntityClass;


public interface ExcelRepository extends JpaRepository<EntityClass, Integer> {
}
