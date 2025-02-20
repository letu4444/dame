package Shoppe.serviecs.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import Shoppe.dto.ProductDto;
import Shoppe.dto.TheloaiDTo;
import Shoppe.persistence.dao.DanhsachphanloaiRepository;
import Shoppe.persistence.dao.ImageProductRepository;
import Shoppe.persistence.dao.PhanloaiRepository;
import Shoppe.persistence.dao.Phanloaihang1Repository;
import Shoppe.persistence.dao.Phanloaihang2Repository;
import Shoppe.persistence.dao.ProductRepository;
import Shoppe.persistence.dao.TheloaiRepository;
import Shoppe.persistence.dao.UserRepository;
import Shoppe.persistence.model.Danhsachphanloai;
import Shoppe.persistence.model.ImageProduct;
import Shoppe.persistence.model.Phanloai;
import Shoppe.persistence.model.Phanloaihang1;
import Shoppe.persistence.model.Product;
import Shoppe.persistence.model.Theloai;
import Shoppe.persistence.model.User;
import Shoppe.persistence.model.phanloaihang2;
import Shoppe.serviecs.ProductServiec;
import Shoppe.serviecs.TheloaiServiec;

@Service
public class ProductImpl implements ProductServiec{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TheloaiServiec theloaiServiec;
	
	@Autowired
	private TheloaiRepository theloaiRepository;
	
	@Autowired
	private PhanloaiRepository phanloaiRepository;
	
	@Autowired
    private Phanloaihang1Repository phanloaihang1Repository;
	
	@Autowired
	private Phanloaihang2Repository phanloaihang2Repository;
	
	@Autowired
	private DanhsachphanloaiRepository danhsachphanloaiRepository;
	
	@Autowired
	private ImageProductRepository imageProductRepository;

	@Override
	public ProductDto findByTitleIsContaining(String title) {
		List<ProductDto> dtos = new ArrayList<>();
		Product product = new Product(title);
		List<Product> tensan = productRepository.findByTitleIsContaining(title);
		ProductDto dtoe = new ProductDto();
		for (Product product2 : tensan) {
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
//			dto.setTheloaiid(theloaiRepository.findByOneId(product2.getTheloaiid()));
			dtos.add(dto);
		}
		dtoe.setListResul(dtos);
		return dtoe;
	}



	@Override
	public Product save(ProductDto product) {
		Product product2 = new Product();
		Phanloai phanloai = new Phanloai();
		Phanloaihang1 phanloaihang1 = new Phanloaihang1();
		phanloaihang2 phanloaihang2 = new phanloaihang2();
		Danhsachphanloai danhsachphanloai = new Danhsachphanloai();
		Theloai theloaiDTo = new Theloai();
		  theloaiDTo.setCode(product.getTheloainame().getCode());
		  theloaiDTo.setMacode(product.getTheloainame().getMacode());
		  theloaiDTo.setName(product.getTheloainame().getName());
		  theloaiDTo = theloaiServiec.save(theloaiDTo);
		User user = new User(product.getUserid());
		if (product.getId() != null) {
			product2.setId(product.getId());
			product2.setTitle(product.getTitle());
			product2.setConter(product.getConter());
			product2.setGia(product.getGia());
			product2.setImage(product.getImage());
			product2.setTenShope(product.getTenShope());
			product2.setTheloai(theloaiDTo);
			product2.setUser(userRepository.findOneById(user.getId()));
			
		}else {
			product2.setTitle(product.getTitle());
			product2.setConter(product.getConter());
			product2.setGia(product.getGia());
			product2.setImage(product.getImage());
			product2.setTenShope(product.getTenShope());
			product2.setTheloai(theloaiRepository.findOneByCode(theloaiDTo.getCode()));
			product2.setUser(userRepository.findOneById(user.getId()));
		}
		product2 = productRepository.save(product2);
		//Lưu tên phân loại vd màu sắc hoặc dung lượng
		for (String i : product.getPhanloai()) {
			Phanloai phanloai1 = new Phanloai();
			phanloai1.setTenphanloai(i);
			phanloai1.setProduct(product2);
			phanloai = phanloaiRepository.save(phanloai1);
		}
		//Lưu phân loại 1 như đỏ đen với ản
		for (String[] j : product.getHangphanloai()) {
			Phanloaihang1 phanloaihang = new Phanloaihang1(); 
			phanloaihang.setImage(j[1]);
			phanloaihang.setTenhangphanloai1(j[0]);
			phanloaihang.setProducts1(product2);
			phanloaihang1=phanloaihang1Repository.save(phanloaihang);
		}
		//Lưu phân loại 1 như dung lượng bao nhiêu kiểu 128g...
		for (String i : product.getHangphanloai2()) {
			phanloaihang2 phanloaihang = new phanloaihang2();
			phanloaihang.setTenhangphanloai2(i);
			phanloaihang.setProducts(product2);
			phanloaihang2 = phanloaihang2Repository.save(phanloaihang);
		}
		//Lưu danh sách như kiểu khối lượng giá các thứ
	for (String[] ele : product.getDanhsachphanloai()) {
		Danhsachphanloai danhsachphanloai1 = new Danhsachphanloai();
		danhsachphanloai1.setGia(ele[2]);
		danhsachphanloai1.setHangphanloai2b(ele[1]);
		danhsachphanloai1.setHangphanloai1(ele[0]);
		danhsachphanloai1.setProducti(product2);
		int sl = Integer.valueOf(ele[3]);
		danhsachphanloai1.setSoluong(sl);
		danhsachphanloai = danhsachphanloaiRepository.save(danhsachphanloai1);
		
	}
	//lưu các ảnh phụ của đại diện
	for (String ite : product.getImageArray()) {
		ImageProduct imageProduct = new ImageProduct();
		imageProduct.setImage(ite);
		imageProduct.setProduct3(product2);
		imageProduct = imageProductRepository.save(imageProduct);
	}
	
		return product2;
	}

	@Override
	public void detele(long[] id) {
	
		
	}

	@Override
	public List<Product> findByTitleLike(String title) {
		
		return productRepository.findByTitleIsContaining(title);
	}

	@Override
	public List<ProductDto> findByTitleIsContaining(String title, Pageable pageable) {
		List<ProductDto> dtos = new ArrayList<>();
		Page<Product> page;
		page = productRepository.findByTitleIsContaining(title, pageable);
		List<Product> list = page.getContent();
		for (Product product2 : list) {
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
//			dto.setTheloaiid(theloaiRepository.findByOneId(product2.getTheloaiid()));
			dtos.add(dto);
			
		}
		return dtos;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return (int) productRepository.count() ;
	}



	@Override
	public ProductDto findOneById(Long id) {
		Product product2 = productRepository.findOneById(id);
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
		dto.setPhanloai(phanloaiRepository.findTenphanloaiByProduct(product2.getId()));
		dto.setHangphanloai2(phanloaihang2Repository.findTenhangByProduct(product2.getId()));
		dto.setHangphanloai(phanloaihang1Repository.findHangByProduct(product2.getId()));
		dto.setImageArray(imageProductRepository.findOneByProduct3(product2.getId()));
//		String[] b = new String[phanloaihang1Repository.findHangByProduct(product2.getId()).length];
//		for (int i = 0; i < phanloaihang1Repository.findHangByProduct(product2.getId()).length; i++) {
//			a[i] =phanloaihang1Repository.findHangByProduct(product2.getId())[i][1]; 
//			b[i] =phanloaihang1Repository.findHangByProduct(product2.getId())[i][0];
//		}
	    dto.setTheloaichung(dto.getTheloainame().getName().split(">"));
		
		
		return dto;
	}



	

}
