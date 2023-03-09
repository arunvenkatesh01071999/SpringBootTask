package com.example.demo.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.EmployeeService;

class EmployeeControllerTest 
{

	@Test
	void testUploadData() throws IOException 
	{  
		 
		EmployeeService mockService = mock(EmployeeService.class);

		MultipartFile mockFile = new MockMultipartFile("/Employee.xlsx", "/Employee.xls", "text/csv",
				"test data".getBytes());

		EmployeeController controller = new EmployeeController();
		controller.service = mockService; 

		 
		controller.uploadData(mockFile);

				verify(mockService).uploadFile(mockFile);
	}
}
