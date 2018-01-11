
package ro.certejan.springdatatransactions.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Entity
@Table(name = "FOO")
public class Foo {
	
	@Id
	@Column(name = "ID")
	private Long id;
	@Column(name = "FOO")
	private String foo;
	
	public Foo(Long id, String foo) {
		this.id = id;
		this.foo = foo;
	}
	
	public Foo() {
		// Default constructor needed by JPA
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFoo() {
		return foo;
	}
	
	public void setFoo(String foo) {
		this.foo = foo;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}