
package ro.certejan.springdatatransactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ro.certejan.springdatatransactions.dao.BarDao;
import ro.certejan.springdatatransactions.dao.FooDao;
import ro.certejan.springdatatransactions.model.Bar;
import ro.certejan.springdatatransactions.model.Foo;
import ro.certejan.springdatatransactions.service.BarService;

/**
 * Two Data Sources:
 * https://medium.com/@joeclever/using-multiple-datasources-with-spring-boot-and
 * -spring-data-6430b00c02e7 Spring Boot Console App:
 * https://www.mkyong.com/spring-boot/spring-boot-non-web-application-example/
 * SQLite: https://stackoverflow.com/a/38755286 &
 * https://stackoverflow.com/a/42905144
 */
@SpringBootApplication
public class SpringDataTransactionsApplication implements CommandLineRunner {

	@Autowired
	private FooDao fooDao;
	@Autowired
	private BarDao barDao;
	@Autowired
	private BarService barService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataTransactionsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		foo();
		bar();
	}

	private void foo() {
		fooDao.deleteAll();
		fooDao.save(new Foo(1L, "One"));
		fooDao.save(new Foo(2L, "Two"));
		fooDao.flush();
		System.out.println("Foo:");
		fooDao.findAllByOrderByIdDesc().forEach(System.out::println);
	}

	private void bar() {
		barDao.deleteAll();
		barService.saveBars(new Bar(1L, "One"), new Bar(2L, "Two"));
		System.out.println("Bar:");
		barDao.findAllByOrderByIdDesc().forEach(System.out::println);
	}
}
