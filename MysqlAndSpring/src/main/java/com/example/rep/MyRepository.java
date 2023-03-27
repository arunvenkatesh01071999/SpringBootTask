package com.example.rep;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.MysqlEntity;

public interface MyRepository extends JpaRepository<MysqlEntity, Long>
{

}
