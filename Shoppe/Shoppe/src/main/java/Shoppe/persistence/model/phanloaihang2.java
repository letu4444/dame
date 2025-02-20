package Shoppe.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "phanloaihang2")
public class phanloaihang2 {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long Id;
	 
	 @Column(name = "hangphanloai2",columnDefinition = "NVARCHAR(50)")
	 private String tenhangphanloai2;
	 

	 
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "productis")
	 private Product products;
	 
	 public phanloaihang2() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTenhangphanloai2() {
		return tenhangphanloai2;
	}

	public void setTenhangphanloai2(String tenhangphanloai2) {
		this.tenhangphanloai2 = tenhangphanloai2;
	}


	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}
	 
}
