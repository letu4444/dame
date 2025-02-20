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
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "title",columnDefinition = "NVARCHAR(50)")
	private String title;
	
	@Column(name = "phanloaihang",columnDefinition = "nvarchar(max)")
	private String phanloaihang;
	
	@Column(name = "giagoc",columnDefinition = "NVARCHAR(100)")
	private String giagoc;
	
	@Column(name = "giasale",columnDefinition = "NVARCHAR(100)")
	private String giasale;
	
	@Column
	private Integer soluong;
	
	@Column(name = "tenshope",columnDefinition = "NVARCHAR(50)")
	private String tenshope;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	private User userid;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "produtid")
	private Product productandcart;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "danhsachphanloaiid")
	private Danhsachphanloai danhsachphanloai;
	public Cart() {
		// TODO Auto-generated constructor stub
	}
   
	
	public Cart(Long id) {
		super();
		this.id = id;
	}


	public Cart(User userid) {
		super();
		this.userid = userid;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPhanloaihang() {
		return phanloaihang;
	}

	public void setPhanloaihang(String phanloaihang) {
		this.phanloaihang = phanloaihang;
	}

	public String getGiagoc() {
		return giagoc;
	}

	public void setGiagoc(String giagoc) {
		this.giagoc = giagoc;
	}

	public String getGiasale() {
		return giasale;
	}

	public void setGiasale(String giasale) {
		this.giasale = giasale;
	}

	public Integer getSoluong() {
		return soluong;
	}

	public void setSoluong(Integer soluong) {
		this.soluong = soluong;
	}

	public String getTenshope() {
		return tenshope;
	}

	public void setTenshope(String tenshope) {
		this.tenshope = tenshope;
	}


	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public Product getProductandcart() {
		return productandcart;
	}

	public void setProductandcart(Product productandcart) {
		this.productandcart = productandcart;
	}

	public Danhsachphanloai getDanhsachphanloai() {
		return danhsachphanloai;
	}

	public void setDanhsachphanloai(Danhsachphanloai danhsachphanloai) {
		this.danhsachphanloai = danhsachphanloai;
	}
	
}
