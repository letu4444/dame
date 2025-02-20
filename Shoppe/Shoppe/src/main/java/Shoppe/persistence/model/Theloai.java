package Shoppe.persistence.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "theloai")
public class Theloai {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "NVARCHAR(250)")
	private String name;
	
	@Column(length = 100)
	private String code;
	
	@Column(length = 50)
	private String macode;
	
	@OneToMany(mappedBy = "theloai")
//	@JsonManagedReference
	private List<Product> products = new ArrayList<>();



	public Long getId() {
		return id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}



	public String getMacode() {
		return macode;
	}



	public void setMacode(String macode) {
		this.macode = macode;
	}
	
	
}
