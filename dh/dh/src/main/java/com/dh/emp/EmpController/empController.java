package com.dh.emp.EmpController;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dh.emp.EmpDTO.empDTO;
import com.dh.emp.EmpService.empService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/empMain")
@RequiredArgsConstructor
public class empController {
	
	private final empService empService;
	
	// mainView
	@RequestMapping("/")
	public String empMain() {
		return "emp/empMainView";
	}
	
	// search
	@RequestMapping("/search")
	public ModelAndView searchView(empDTO EmpDTO, ModelAndView mav) {
		//System.out.println(EmpDTO.getEmpNm());
		empDTO dto = empService.search(EmpDTO);
		//System.out.println(dto.getEmpNm());
		mav.addObject("emps",dto);	// empList라는 모델을 "empList"라는 이름으로 담고
		mav.setViewName("emp/empInfoView");	//	empMainView인 View를 mav에 담아서 emp/empMainView에 보낸다!
		//System.out.println(dto.getEmpId()); 
		return mav;
	}
	
	// info
	//@RequestMapping("/search/")
	//public ModelAndView infoView(empDTO EmpDTO , ModelAndView mav) {
		//System.out.println(EmpDTO.getEmpNm());
		//List<empDTO> empList = empService.search(EmpDTO);
		//System.out.println(empList.get(0));
		//mav.addObject("empList",empList);	// empList라는 모델을 "empList"라는 이름으로 담고
		//mav.setViewName("emp/empInfoView");	//	empMainView인 View를 mav에 담아서 emp/empMainView에 보낸다!
		//return mav;
	//}
	
	//modify
	@GetMapping("/modify/{eId}")
	public ModelAndView modifyView(@PathVariable String eId, ModelAndView mav) {
		empDTO dto = empService.modify(eId);
		mav.addObject("emps", dto);
		mav.setViewName("emp/empUpdateView");
		return mav;
	}

	//update
	@PutMapping("/{eId}")
	public String updateView(@PathVariable String eId, empDTO EmpDTO) {
		//System.out.println(empId);
		empService.update(eId, EmpDTO);
		return "emp/empMainView";
	}
	
	// delete
	@RequestMapping("/{eId}")
	public String deleteView(@PathVariable String eId) {
		empService.delete(eId);
		return "emp/empMainView";
	}
		
	
	// orgView
	@RequestMapping("/orgView")
	public String orgView() {
		return "emp/empOrganizationView";
	}
}
