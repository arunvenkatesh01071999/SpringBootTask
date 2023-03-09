package com.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "excelsheetentity")
public class ExcelSheetEntity {

		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column(name = "code")
		private String code;

		@Column(name = "name")
		private String name;
		
		@Column(name = "todate")
		private String todate;
		
		@Column(name = "grade")
		private String grade;
		
		@Column(name = "salary")
		private double salary;
		
		@Column(name = "status")
		String status;

		public ExcelSheetEntity ()
		{
			super();
		}

		public String getCode() 
		{
			return code;
		}

		public void setCode(String code) 
		{
			this.code = code;
		}

		public String getName() 
		{
			return name;
		}

		public void setName(String name)
		{
			this.name = name;
		}

		public String getDate()
		{
			return todate;
		} 

		public void setDate(String todate)
		{
			this.todate = todate;
		} 

		public String getGrade()
		{
			return grade; 
		}

		public void setGrade(String grade) 
		{
			this.grade = grade;
		}

		public double getSalary()
		{
			return salary;
		}

		public void setSalary(double salary) 
		{
			this.salary = salary;
		}
		
		public void setStatus(String status) 
		{
			this.status = status;
		}
}
