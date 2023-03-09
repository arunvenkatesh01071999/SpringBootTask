package com.example.demo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.entity.EntityClass;
import com.example.demo.repository.ExcelRepository;

@Service 
public class EmployeeService
{
 
	@Autowired
	ExcelRepository repository;

	public void uploadFile(MultipartFile file) throws IOException
	{  

		List<EntityClass> entityList = new ArrayList<>();
		XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++)
		{
			XSSFRow row = worksheet.getRow(i);
			String result = "success";
			if (result.equalsIgnoreCase(row.getCell(5).getStringCellValue()))
			{
				EntityClass employee = new EntityClass(); 
				employee.setCode(row.getCell(0).getStringCellValue());
				employee.setName(row.getCell(1).getStringCellValue());
				employee.setDate(row.getCell(2).getStringCellValue());
				employee.setGrade(row.getCell(3).getStringCellValue());
				employee.setSalary(row.getCell(4).getNumericCellValue());
				entityList.add(employee);
			} 
		}
		workbook.close();
		repository.saveAll(entityList);
	}

	
}
