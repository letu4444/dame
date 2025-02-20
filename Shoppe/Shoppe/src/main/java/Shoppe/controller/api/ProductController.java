package Shoppe.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Shoppe.dto.CartDto;
import Shoppe.dto.PhanloaihangDto;
import Shoppe.dto.ProductDto;
import Shoppe.dto.TheloaiDTo;
import Shoppe.persistence.dao.DanhsachphanloaiRepository;
import Shoppe.persistence.dao.PhanloaiRepository;
import Shoppe.persistence.dao.Phanloaihang1Repository;
import Shoppe.persistence.dao.Phanloaihang2Repository;
import Shoppe.persistence.model.Cart;
import Shoppe.persistence.model.Product;
import Shoppe.serviecs.CartServiec;
import Shoppe.serviecs.ProductServiec;
import Shoppe.uitl.UserUtil;



@RestController
@CrossOrigin
public class ProductController {
	
	@Autowired
	private PhanloaiRepository phanloaiRepository;

	@Autowired
	private Phanloaihang1Repository phanloaihang1Repository;
	
	@Autowired
	private Phanloaihang2Repository phanloaihang2Repository;
	
	@Autowired
	private DanhsachphanloaiRepository danhsachphanloaiRepository;
	
	@Autowired
	private ProductServiec productServiec;
	
	@Autowired
	private CartServiec cartServiec;
	
	@Autowired
	private UserUtil userUtil;
	
	
	
	@GetMapping
	public String a() {
		return null;
	}
 
	@GetMapping(value = "/phanloai/save")
	public PhanloaihangDto phanloaiPage(Model model,@ModelAttribute("id") Long id) {
	
		List<PhanloaihangDto> dtos = new ArrayList<>();
		PhanloaihangDto dto = new PhanloaihangDto();
		dto.setChunghangphanloai(phanloaihang1Repository.findHangByProduct(id));
		dto.setDanhsachphanloai(danhsachphanloaiRepository.findGiaByProducti(id));

		return dto;
	}
	@PostMapping("/product/save")
	public ProductDto SearchPage(Model model,@RequestBody ProductDto dto1) {
		
		  Product product2 = productServiec.save(dto1);
		  TheloaiDTo theloaiDTo = new TheloaiDTo();
		  theloaiDTo.setCode(product2.getTheloai().getCode());
		  theloaiDTo.setId(product2.getTheloai().getId());
		  theloaiDTo.setMacode(product2.getTheloai().getMacode());
		  theloaiDTo.setName(product2.getTheloai().getName());
		  ProductDto dto = new ProductDto();
		  dto.setConter(product2.getConter());
			dto.setGia(product2.getGia());
			dto.setId(product2.getId());
			dto.setImage(product2.getImage());
			dto.setTenShope(product2.getTenShope());
			dto.setTitle(product2.getTitle());
			dto.setTheloainame(theloaiDTo);
			dto.setUserid(product2.getUser().getId());
		return dto;
	}
	@PostMapping(value = "/product/cart")
	public CartDto CartPage(@RequestBody CartDto cartDto) {
		CartDto cartDto2 = cartServiec.save(cartDto);
		return cartDto2;
	}
	
	@GetMapping("/product/cartsp")
	public List<CartDto> Page(@RequestParam(value ="id",required = false) Long id) {
		
		List<CartDto> cartDtos = cartServiec.findAll(id);
		
		return cartDtos;
	}
	
	@GetMapping(value = "/product/gio")
	public String[][] GioPage(@RequestParam(value = "id",required = false) Long id){
		return cartServiec.findGioByCart(id);
	}
	@GetMapping(value = "/product/phanloaihang")
	public CartDto Phanloaihang(@ModelAttribute("id") Long id) {
	
		CartDto cartDto = new CartDto();
		cartDto.setPhanloaihang(cartServiec.findPhanloaiByCart(id));
		return cartDto;
	}
	@PostMapping(value = "/product/pustcart")
	public void PustCart(@RequestParam(value = "id") Long id,
			             @RequestParam("soluong") Integer soluong) {
		Cart cartDto = new Cart();
		cartDto.setId(id);
		cartDto.setSoluong(soluong);
		cartServiec.PustCart(cartDto);
	}
	
	@DeleteMapping(value = "/product/deletecart")
	public void DeleteCart(@RequestBody CartDto cartDto) {
		cartServiec.detele(cartDto.getId_delete());
	}
}
