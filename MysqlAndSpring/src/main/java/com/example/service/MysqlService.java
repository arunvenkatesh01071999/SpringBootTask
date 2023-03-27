package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dto.MysqlDto;
import com.example.model.MysqlEntity;
import com.example.rep.MyRepository;

public class MysqlService {

	@Autowired
	private MyRepository myRepository;
	
	@PostMapping("create")
	public MysqlDto createPost(MysqlDto mysqldto)
	{
		MysqlEntity mysqlentity = new MysqlEntity();
		
		mysqlentity.setTitle(mysqldto.getTitle());
		mysqlentity.setDescription(mysqldto.getDescription());
		mysqlentity.setContent(mysqldto.getContent());
		
		//return mysqlentity;
		MysqlEntity mysqlentitytwo = myRepository.save(mysqlentity);
		
		MysqlDto mysqlResponse = new MysqlDto();
		
		mysqlResponse.setTitle(mysqlentitytwo.getTitle());
		mysqlResponse.setDescription(mysqlentitytwo.getDescription());
		mysqlResponse.setContent(mysqlentitytwo.getContent());
		return mysqlResponse;
	}
}
