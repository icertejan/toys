
package ro.certejan.springdatatransactions;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class BarDataSourceConfig {
	
	@Bean(name = "barDataSource")
	@ConfigurationProperties(prefix = "bar.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "barJdbcTemplate")
	public JdbcTemplate jdbcTemplate(@Qualifier("barDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
