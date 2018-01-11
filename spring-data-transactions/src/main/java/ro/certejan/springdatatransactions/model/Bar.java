
package ro.certejan.springdatatransactions.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class Bar {
	
	private Long id;
	private String bar;
	
	public Bar(Long id, String bar) {
		this.id = id;
		this.bar = bar;
	}
	
	public Bar() {
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getBar() {
		return bar;
	}
	
	public void setBar(String bar) {
		this.bar = bar;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
