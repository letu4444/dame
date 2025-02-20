package Shoppe.dto;

import java.util.ArrayList;
import java.util.List;

public class AbstracDto<T> {
	private List<T> listResul =  new ArrayList<>();
	
	private String[] phanloai;
	
	private String[][] hangphanloai;
	
	private String[][] danhsachphanloai;
	
	private Long[] idphanloai;
	
	private Long[] idhangphanloai;
	
	private Long[] iddanhsachphanloai;
	
	private String[][] chunghangphanloai;
	
	private String[] imagephanloai;
	
	private String[] imageArray;
	
	private String[] hangphanloai2;

	private String[] theloaichung;
    
	private String tenphanloai;
	
	private int Sl;
	
	private Long[] id_delete;

	
	public AbstracDto() {
		// TODO Auto-generated constructor stub
	}

	

	public String getTenphanloai() {
		return tenphanloai;
	}


	public void setTenphanloai(String tenphanloai) {
		this.tenphanloai = tenphanloai;
	}


	public List<T> getListResul() {
		return listResul;
	}


	public void setListResul(List<T> listResul) {
		this.listResul = listResul;
	}


	public Long[] getIdphanloai() {
		return idphanloai;
	}


	public void setIdphanloai(Long[] idphanloai) {
		this.idphanloai = idphanloai;
	}


	public Long[] getIdhangphanloai() {
		return idhangphanloai;
	}


	public void setIdhangphanloai(Long[] idhangphanloai) {
		this.idhangphanloai = idhangphanloai;
	}


	public Long[] getIddanhsachphanloai() {
		return iddanhsachphanloai;
	}


	public void setIddanhsachphanloai(Long[] iddanhsachphanloai) {
		this.iddanhsachphanloai = iddanhsachphanloai;
	}




	public String[][] getChunghangphanloai() {
		return chunghangphanloai;
	}



	public void setChunghangphanloai(String[][] chunghangphanloai) {
		this.chunghangphanloai = chunghangphanloai;
	}



	public String[] getHangphanloai2() {
		return hangphanloai2;
	}



	public void setHangphanloai2(String[] hangphanloai2) {
		this.hangphanloai2 = hangphanloai2;
	}

	public String[] getTheloaichung() {
		return theloaichung;
	}



	public void setTheloaichung(String[] theloaichung) {
		this.theloaichung = theloaichung;
	}



	public int getSl() {
		return Sl;
	}


	public void setSl(int sl) {
		Sl = sl;
	}



	public String[] getPhanloai() {
		return phanloai;
	}



	public void setPhanloai(String[] phanloai) {
		this.phanloai = phanloai;
	}



	public String[][] getHangphanloai() {
		return hangphanloai;
	}



	public void setHangphanloai(String[][] hangphanloai) {
		this.hangphanloai = hangphanloai;
	}



	public String[][] getDanhsachphanloai() {
		return danhsachphanloai;
	}



	public void setDanhsachphanloai(String[][] danhsachphanloai) {
		this.danhsachphanloai = danhsachphanloai;
	}



	public String[] getImagephanloai() {
		return imagephanloai;
	}



	public void setImagephanloai(String[] imagephanloai) {
		this.imagephanloai = imagephanloai;
	}



	public String[] getImageArray() {
		return imageArray;
	}



	public void setImageArray(String[] imageArray) {
		this.imageArray = imageArray;
	}



	public Long[] getId_delete() {
		return id_delete;
	}



	public void setId_delete(Long[] id_delete) {
		this.id_delete = id_delete;
	}

   
	
}
