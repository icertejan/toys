
package ro.certejan.springdatatransactions.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ro.certejan.springdatatransactions.model.Bar;

@Repository
public class BarDao {
	
	@Autowired
	@Qualifier("barJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	public void deleteAll() {
		jdbcTemplate.execute("DELETE FROM BAR");
	}
	
	public void save(Bar bar) {
		jdbcTemplate.update("INSERT INTO BAR(ID, BAR) VALUES(?, ?)", bar.getId(), bar.getBar());
	}
	
	public List<Bar> findAllByOrderByIdDesc() {
		return jdbcTemplate.query("SELECT ID, BAR FROM BAR ORDER BY ID DESC",
				new BeanPropertyRowMapper<Bar>(Bar.class));
	}
}
