package com.xinyan.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xinyan.springcloud.entities.Dept;
import com.xinyan.springcloud.service.DeptService;

@RestController
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	//服务发现
	@Autowired
	private DiscoveryClient client;
	
	/**
	 * 部门列表
	 * @return
	 */
	@GetMapping("/dept/list")
	public List<Dept> list(){
		return deptService.findAll();
	}
	
	/**
	 * 查找某一个部门
	 * @param id
	 * @return
	 */
	@GetMapping("/dept/get/{id}")
	public Dept get(@PathVariable Long id) {
		return deptService.findDept(id);
	}

	/**
	 * 添加部门
	 * @param dept
	 * @return
	 */
	@PostMapping("/dept/add")
//	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public Boolean addDept(@RequestBody Dept dept) {
		return deptService.addDept(dept);
	}
	
	@RequestMapping("/dept/discovery")
	public Object discovery() {
		//获取所有微服务实例名
		List<String> list = client.getServices();
		System.out.println("========>" + list);
		
		for(String str : list) {
			List<ServiceInstance> siList = client.getInstances(str);
			for(ServiceInstance si : siList) {
				System.out.println(si.getServiceId() + "," + si.getHost() + "," + si.getPort() + "," + si.getUri());
			}
		}
		
		return client;
	}
}
