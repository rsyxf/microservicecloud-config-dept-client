package com.xinyan.springcloud.service;

import java.util.List;

import com.xinyan.springcloud.entities.Dept;

public interface DeptService {

	public boolean addDept(Dept dept);
	
	public Dept findDept(Long id);
	
	public List<Dept> findAll();
}
