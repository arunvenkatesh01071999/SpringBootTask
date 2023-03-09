package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.ExcelSheetEntity;


public interface ExcelSheetRepository extends JpaRepository<ExcelSheetEntity, Integer> {

	Optional<ExcelSheetEntity> findByCode(String stringCellValue);

}
