package com.example.demo.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.EntityClass;
import com.example.demo.repository.ExcelRepository;

@RunWith(MockitoJUnitRunner.class)
 class EmployeeServiceTest { 

	@InjectMocks
	EmployeeService myService;

	@Mock
	ExcelRepository employeeRepository;

	@BeforeEach
	void setup() {
	    MockitoAnnotations.openMocks(this);
	} 

	@Test
	void testUploadFile() throws IOException {

	    File file = new File("C:\\Users\\arunk\\eclipse-workspace\\ExcelToDatabase\\src\\main\\resources\\Employee.xlsx");
	    InputStream inputStream = new FileInputStream(file);
	    MultipartFile multipartFile = new MockMultipartFile("Employee.xlsx", file.getName(),
	            "application/vnd.ms-excel", inputStream);
	    EntityClass employee1 = new EntityClass();
	    employee1.setCode("C01");
	    employee1.setName("John Smith");
	    employee1.setDate("2022-01-01");
	    employee1.setGrade("A");
	    employee1.setSalary(5000);

	    EntityClass employee2 = new EntityClass();
	    employee2.setCode("C02");
	    employee2.setName("Jane Doe");
	    employee2.setDate("2022-01-01");
	    employee2.setGrade("B");
	    employee2.setSalary(4000);

	    when(employeeRepository.saveAll(Mockito.anyIterable())).thenReturn(Arrays.asList(employee1, employee2));
	    myService.uploadFile(multipartFile);

	    verify(employeeRepository, times(1)).saveAll(Mockito.anyIterable());
	}
}
