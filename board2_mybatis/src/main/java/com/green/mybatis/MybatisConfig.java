package com.green.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// MybatisConfig.getInstance()
// SqlSessionFactory 객체를 하나만 만들어서 계속쓰기위해서 싱글톤패턴으로 객체를 생성한다.
public class MybatisConfig {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSessionFactory getInstance() {
		new MybatisConfig();
		
		return sqlSessionFactory;
	}
	
	private MybatisConfig() {
		String resource = "com/green/mybatis/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory =
					  new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("SqlSessionFactory 객체 생성");
	}

}