package Shoppe.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Shoppe.serviecs.DefaultUserService;



@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_STAFF')")
public class AdminController {
	@Autowired
	private DefaultUserService defaultUserService;
	
	@GetMapping()
	public String AdminPage(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	
		return "admin/admin";
	}
	@GetMapping("/edit")
	@PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
	public String EditPage(Model model) {
		return "admin/edit";
	}
}
