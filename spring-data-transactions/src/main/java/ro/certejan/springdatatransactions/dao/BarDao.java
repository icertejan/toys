package ro.certejan.springdatatransactions.dao;

import java.util.List;

import ro.certejan.springdatatransactions.model.Bar;

public interface BarDao {

	public void deleteAll();

	public void save(Bar bar);

	public List<Bar> findAllByOrderByIdDesc();

}