package the;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootTest
class BoardMybatisJpaApplicationTests {

	Logger logger;
	@Autowired
	DataSource dataSource;
	
	@Test
	void 데이터소스_테스트() {
		System.out.println("-----------------------------");
		log.warn("경고......");
		log.debug("디버그레벨로 메세지 출력!");
		log.info("인포레벨로 메세지 출력!");
		
		logger.debug("디버그레벨");
		logger.info("인포레벨");
		System.out.println("==============================");
	}

}
