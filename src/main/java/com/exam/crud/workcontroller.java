package com.exam.crud;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class workcontroller {
	private WorkRepository workrepository;
	private StudentRepository studentRepository;

	@Autowired
	public workcontroller(WorkRepository workrepository,StudentRepository studentRepository) {
		super();
		this.workrepository = workrepository;
		this.studentRepository = studentRepository; 
	}

	@GetMapping("timetracker")
	public String SearchShow(Workdetails workdetails, Model model) {
		model.addAttribute("Workdetails", workrepository.findAll());
		model.addAttribute("Student", studentRepository.findAll());
		List<Student> s1 = studentRepository.findAll();
		List<Workdetails> w1 = workrepository.findAll();
		long r = Integer.parseInt(s1.get(0).getHrate());
		String str = w1.get(0).getTime();
		String[] s= str.split(":");
	        int hr = Integer.valueOf(s[0]);
	        int min = Integer.valueOf(s[1]);
	        int sec = Integer.valueOf(s[2]);
	        double xtime = hr*3600+(min*60)+(sec);
	        double newtime = Math.round(xtime/3600);
	        String total = String.valueOf(r*newtime);
	        model.addAttribute("total", total);
			return "timetracker";
	}
	@GetMapping("adddetails")
	public String showsaveWork(Workdetails workdetails) {
		return "timetracker";
	}
	@GetMapping("invoice")
	public String showinvoice(Workdetails workdetails) {
		return "invoice";
	}

	@PostMapping("adddetails")
	public String SaveUser(@Valid Workdetails workdetails, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "timetracker";
		}
		workrepository.save(workdetails);
		model.addAttribute("workdetails", workrepository.findAll());
		return "redirect:/timetracker";
	}

}
