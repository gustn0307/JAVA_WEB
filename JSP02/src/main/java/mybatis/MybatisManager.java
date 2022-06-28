package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisManager {
	
	private static SqlSessionFactory sqlSessionFactory=null;
	
	//메서드를 통해서 객체 생성
	public static SqlSessionFactory getInstance() {
		if(sqlSessionFactory==null)new MybatisManager();
		
		return sqlSessionFactory;
	}
	
	//외부에서 생성자를 통해서 객체생성 불가 private 
	private MybatisManager() {
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory =
					  new SqlSessionFactoryBuilder().build(inputStream);
			
			System.out.println("sqlSessionFactory객체 생성");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}