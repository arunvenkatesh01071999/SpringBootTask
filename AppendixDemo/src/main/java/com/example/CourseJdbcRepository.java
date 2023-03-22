//package com.example;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class CourseJdbcRepository {
//
//	private JdbcTemplate springJdbcTemplate;
//	
//	private static String INERT_QUERY=
//	""""
//			insert into course (id,name,author)
//			values(1, 'Learn Aws ','using udemy');
//	"""";
//	public void insert() {
//		springJdbcTemplate.update(INERT_QUERY);
//	}
//}
