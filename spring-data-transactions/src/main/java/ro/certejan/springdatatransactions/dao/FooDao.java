
package ro.certejan.springdatatransactions.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.certejan.springdatatransactions.model.Foo;

@Repository
public interface FooDao extends JpaRepository<Foo, Long> {
	
	public List<Foo> findAllByOrderByIdDesc();
}