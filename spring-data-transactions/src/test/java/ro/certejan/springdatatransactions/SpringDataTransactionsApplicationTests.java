
package ro.certejan.springdatatransactions;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import ro.certejan.springdatatransactions.dao.BarDao;
import ro.certejan.springdatatransactions.dao.BarDaoImpl;
import ro.certejan.springdatatransactions.model.Bar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataTransactionsApplicationTests {
	
	@Autowired
	private BarDao barDao;
	
	@Configuration
	@ImportAutoConfiguration(classes = { DataSourceAutoConfiguration.class })
	// See full list at
	// https://docs.spring.io/spring-boot/docs/current/reference/html/test-auto-configuration.html
	public static class BareMinimumContextForBar extends BarDataSourceConfig {
		
		@Bean
		public BarDao barDao() {
			return new BarDaoImpl();
		}
	}
	
	@Test
	public void testBar() {
		barDao.deleteAll();
		barDao.save(new Bar(1L, "One"));
		barDao.save(new Bar(2L, "Two"));
		System.out.println("Bar:");
		barDao.findAllByOrderByIdDesc().forEach(System.out::println);
	}
}
