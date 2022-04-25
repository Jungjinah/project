package com.dh.emp.EmpService;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dh.emp.EmpDTO.empDTO;
import com.dh.emp.EmpMapper.empMapper;

@Service
public class empService { 
	
	@Autowired
	empMapper EmpMapper;
	
	//search
	public empDTO search(empDTO EmpDTO) {
		return EmpMapper.search(EmpDTO);
	}
	
	//info
	//	public List<empDTO> info(empDTO EmpDTO) {
	//		return EmpMapper.search(EmpDTO);
	//	}
		
	// update
	public empDTO modify(String eId) {
		return EmpMapper.modify(eId);
	}
	
	// updateCheck
	public void update(String eId, empDTO EmpDTO) {
		Map<String, Object> map = new HashMap<String, Object>();
			map.put("eId", eId);
			map.put("EmpDTO", EmpDTO);
		 EmpMapper.update(map);
	}
	
	// delete
	public void delete(String eId) {
		EmpMapper.delete(eId);
	}
	
}
