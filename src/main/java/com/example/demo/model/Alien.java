package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties({ "parentid", "id" })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Alien {
	
	@Id
	private Integer id;
	private Integer parentid;
	@JsonProperty(value="Name")
	private String name;
	@JsonProperty(value="Color")
	private String color;
	@Transient
	@JsonProperty(value="Sub Classes")
	private List<Alien> child = new ArrayList<>();
	
	public List<Alien> getChild() {
		return child;
	}
	public void addChild(Alien alien) {
		this.child.add(alien);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
}
