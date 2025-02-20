package Shoppe.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import Shoppe.persistence.model.Danhsachphanloai;



@Transactional
public interface DanhsachphanloaiRepository extends JpaRepository<Danhsachphanloai, Long> {

//	List<Danhsachphanloai> findByPhanloaihang(Phanloaihang phanloaihang);
	@Query(value = "SELECT gia,hangphanloai1,hangphanloai2,soluong FROM danhsachphanloai u where u.productis=?1",nativeQuery = true)
	String[][] findGiaByProducti(Long id);
	@Query(value = "SELECT * FROM danhsachphanloai u where u.hangphanloai1=?1 and u.hangphanloai2=?2 and  u.productis=?3",nativeQuery = true)
	Danhsachphanloai findDanhsachByHanghoa(String hanghoa1,String hanghoa2, Long id); 
	@Query(value = "Select hangphanloai1,hangphanloai2 from danhsachphanloai u where u.id=?1", nativeQuery = true)
	String[][] findPhanloaiByDanhsach(Long id);
	
}
