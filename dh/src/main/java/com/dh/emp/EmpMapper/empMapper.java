package com.dh.emp.EmpMapper;

import java.util.List;
import java.util.Map;

import org.apache.el.parser.AstInteger;
import org.apache.ibatis.annotations.Mapper;

import com.dh.emp.EmpDTO.empDTO;

@Mapper
public interface empMapper {

	public empDTO search(empDTO EmpDTO);
	public List<empDTO> info(empDTO EmpDTO);
	public empDTO modify(String eId);
	public int update(Map<String, Object> map);
	//public empDTO update(@Param("eId")String eId, @Param("EmpDTO")empDTO EmpDTO);
	//public int delete(String id);
	public AstInteger delete(String eId);

}
