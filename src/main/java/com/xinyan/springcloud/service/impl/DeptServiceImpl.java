package com.xinyan.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinyan.springcloud.dao.DeptDao;
import com.xinyan.springcloud.entities.Dept;
import com.xinyan.springcloud.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	private DeptDao deptDao;

	@Override
	public boolean addDept(Dept dept) {
		return deptDao.addDept(dept);
	}

	@Override
	public Dept findDept(Long id) {
		return deptDao.findById(id);
	}

	@Override
	public List<Dept> findAll() {
		return deptDao.findAll();
	}

}
