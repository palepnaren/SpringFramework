package com.naren.springmvc.jndi;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.naren.springmvc.dao.DataTable;
import com.naren.springmvc.servicelayer.DataService;


@Controller
public class DataController {

	
	private DataService dataService;
	
//	@RequestMapping("/data")
//	public String display(HttpSession session){
//		
//		session.setAttribute("name", "Naren");
//		
//		return "home";
//	}
	
	@Autowired
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	
	@RequestMapping("/list")
	public String displayList(Model model){
		
		List<DataTable> current = dataService.getCurrent();
		model.addAttribute("data", current);
		
		return "displaydata";
	}
	
	@RequestMapping("/create")
	public String create(Model model){	
		
		model.addAttribute("dataTable", new DataTable());
		return "create";
	}
	
	@RequestMapping(value="/saved",method=RequestMethod.POST)
	public String save(Model model, @Valid DataTable dataTable, BindingResult result){	
		
		//boolean save = false;
		
		if(result.hasErrors()){
			
			return "create";

		}
			System.out.println("Form validated.");
			dataService.save(dataTable);
			 return "saved";
		
	
	}
	
//	@RequestMapping("/data1")
//	public ModelAndView show(){
//		
//		ModelAndView mv = new ModelAndView("home");
//		Map<String, Object> model = mv.getModel();
//		model.put("name", "Nancy");
//		
//		return mv;
//		
//	}
}
