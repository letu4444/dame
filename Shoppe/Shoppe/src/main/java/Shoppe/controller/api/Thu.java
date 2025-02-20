package Shoppe.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Shoppe.dto.ImageProduct;
import Shoppe.serviecs.ProductServiec;
import Shoppe.serviecs.impl.ImageProductServerc;



@RestController
@RequestMapping(value = "/thu")
public class Thu {
	@Autowired
	private ProductServiec productServiec;
	
	@Autowired
	private ImageProductServerc imageProductServiec;
	
//	@RequestMapping(value = "/thu/{id}")
//	public String MuahangPage(Model model, @PathVariable(value = "id") String id) {
//		String name = id;
//		System.out.println(id);
//		return name;
//	}
	
	@GetMapping(value = "/{id}")
	public String[] muhang(Model model,@PathVariable("id") String id) {
//		  HttpServletRequest request = (HttpServletRequest) servletrequest;
//		  String baseurl = request.getRequestURI();
		 String[] a = id.split("\\.", 3);
		 Long id1 = Long.valueOf(a[1]);
//		ProductDto dto = productServiec.findOneById(id1);
		 
//		System.out.println(baseurl);
		return imageProductServiec.findOneByProduct3(id1);
	}
	
}
