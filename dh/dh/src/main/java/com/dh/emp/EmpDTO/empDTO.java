package com.dh.emp.EmpDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class empDTO {
	private String empId;
	private String empNm;
	private String empTelno;
	private String empAddr;
	private String empDeptId;
}
