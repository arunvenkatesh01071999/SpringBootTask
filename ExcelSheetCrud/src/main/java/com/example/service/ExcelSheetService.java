package com.example.service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.model.ExcelSheetEntity;
import com.example.repository.ExcelSheetRepository;

@Service 
public class ExcelSheetService
{

	@Autowired
	ExcelSheetRepository repository;

	public byte[] uploadFile(MultipartFile file) throws IOException 
	{
		
		List<ExcelSheetEntity> entityList = new ArrayList<>();
		XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;
		row = worksheet.getRow(0);
        cell = row.createCell(6);
        cell.setCellValue("Result");
		
		for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++)
		{
			 row = worksheet.getRow(i);
			String operation = "create";
			String operation2 = "update";
			String operation3 = "delete";
	
			if ((operation.equalsIgnoreCase(row.getCell(5).getStringCellValue()))) 
			{
				
				this.createExcelSheetEntity(row, entityList);
				row = worksheet.getRow(i);
	             cell = row.createCell(6);
	            cell.setCellValue("success");
	           
			} else if (operation2.equalsIgnoreCase(row.getCell(5).getStringCellValue()))
			  {
				Optional<ExcelSheetEntity> employeeOptional = repository
						.findByCode(String.valueOf(row.getCell(0).getStringCellValue()));
				
					row = worksheet.getRow(i);
		            cell = row.createCell(6);
		            cell.setCellValue("success");	
					if (employeeOptional.isPresent())
					{
						ExcelSheetEntity employee = employeeOptional.get();
						employee.setName(row.getCell(1).getStringCellValue());
						employee.setDate(row.getCell(2).getStringCellValue());
						employee.setGrade(row.getCell(3).getStringCellValue());
						employee.setSalary(row.getCell(4).getNumericCellValue());
						entityList.add(employee);
					} else
					{
						this.createExcelSheetEntity(row, entityList);
					}
			   }else if (operation3.equalsIgnoreCase(row.getCell(5).getStringCellValue()))
			   {
				   Optional<ExcelSheetEntity> employeeOptional = repository
							.findByCode(String.valueOf(row.getCell(0).getStringCellValue()));
				   
				     row = worksheet.getRow(i);
		            cell = row.createCell(6);
		            cell.setCellValue("unsuccess");
				   if (employeeOptional.isPresent())
				   {
					  
					  repository.deleteAll();
					  
				   } else
					{
						this.createExcelSheetEntity(row, entityList);
					}
			   }
			
		}
		
			repository.saveAll(entityList);	    
			 ByteArrayOutputStream out = new ByteArrayOutputStream();
		        workbook.write(out);  
		        workbook.close(); 
			        
		   return out.toByteArray();		 
	}
			
	//excel sheet data into database
	private void createExcelSheetEntity(XSSFRow row, List<ExcelSheetEntity> entityList) 
	{
		ExcelSheetEntity employee = new ExcelSheetEntity();
		
		employee.setCode(row.getCell(0).getStringCellValue());
		employee.setName(row.getCell(1).getStringCellValue());
		employee.setDate(row.getCell(2).getStringCellValue());
		employee.setGrade(row.getCell(3).getStringCellValue());
		employee.setSalary(row.getCell(4).getNumericCellValue());
		
		String delete="delete";
		if(delete.equalsIgnoreCase(row.getCell(5).getStringCellValue()))
		{
		employee.setStatus("unactive");
		}
		else
		{
			employee.setStatus("active");
		}
		
		entityList.add(employee);
	}
}