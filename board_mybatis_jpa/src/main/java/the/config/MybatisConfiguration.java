package the.config;

import javax.sql.DataSource;

import org.apache.ibatis.annotations.Property;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
@PropertySource("classpath:/application.properties")
public class MybatisConfiguration {
	//SqlSessionFactory spring-boot-stater에서는 SqlSessionFactoryBean
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		
		Resource[] resources=applicationContext
				.getResources("classpath:/mapper/**/*.xml");
		bean.setMapperLocations(resources);
		bean.setConfiguration(mybatisConfig());
		return bean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
		//System.out.println("sqlSessionFactory: "+sqlSessionFactory);
		log.debug("sqlSessionFactory: "+sqlSessionFactory);
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	@Bean
	@ConfigurationProperties(prefix = "mybatis.configuration")
	public org.apache.ibatis.session.Configuration mybatisConfig(){
		return new org.apache.ibatis.session.Configuration();
	}

}
