package com.exam.crud;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students/")
public class StudentController {
	private final StudentRepository studentRepository;
	private final WorkRepository Wrepository;

	@Autowired
	public StudentController(StudentRepository studentRepository, WorkRepository Wrepository) {
		super();
		this.studentRepository = studentRepository;
		this.Wrepository = Wrepository;
	}

	@GetMapping
	public String studentsAll(Model model) {
		model.addAttribute("students", studentRepository.findAll());
//
//		List<Student> s1 = studentRepository.findById(26);
//		List<Workdetails> w1 = Wrepository.findById(13);
//		String total = String.valueOf("Rate: " + s1.get(0).getId() + "  Time:   " + w1.get(0).getTime());
//		model.addAttribute("total", String.valueOf(total));
		return "clientlist";
	}

	@GetMapping("add")
	public String showSaveStudent(Student student) {
		return "savestudent";
	}

	@PostMapping("add")
	public String SaveStudent(@Valid Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "savestudent";
		}
		studentRepository.save(student);
		model.addAttribute("students", studentRepository.findAll());
		return "redirect:/students/";
	}

	@GetMapping("edit/{id}")
	public String showUpdateStudent(@PathVariable("id") Long id, Model model) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("student", student);
		return "updatestudent";
	}

	@GetMapping("/styled-page")
	public String getStyledPage(Model model) {
		model.addAttribute("name", "Baeldung Reader");
		return "/styledPage";
	}

	@PostMapping("update/{id}")
	public String updateStudent(@PathVariable("id") Long id, @Valid Student student, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			student = studentRepository.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
			return "updatestudent";
		}
		studentRepository.save(student);
		model.addAttribute("students", studentRepository.findAll());
		return "redirect:/students/";
	}

	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id, Model model) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		studentRepository.delete(student);
		model.addAttribute("students", studentRepository.findAll());
		return "redirect:/students/";
	}

	@GetMapping("clientlist")
	public String clientlist(Model model) {
		model.addAttribute("students", studentRepository.findAll());
		return "clientlist";
	}

	@GetMapping("report")
	public String showreport(Student student) {
		return "report";
	}

	@GetMapping("pricing")
	public String showpricing(Student student) {
		return "pricing";
	}

	@GetMapping("help")
	public String showhelp(Student student) {
		return "help";
	}

	@GetMapping("home")
	public String showhome(Student student) {
		return "home";
	}
}
