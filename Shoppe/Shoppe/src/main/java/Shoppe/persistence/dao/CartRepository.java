package Shoppe.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import Shoppe.persistence.model.Cart;



@Transactional
public interface CartRepository extends JpaRepository<Cart, Long>{ 
	//Lấy tất cả đổ ra giỏ hàng
	@Query(value = "SELECT * FROM cart u where u.userid=?1",nativeQuery = true)
	List<Cart> findAllCart(Long userid);
	//nếu có rồi thì chỉ cộng số lượng lại
	@Query(value = "SELECT * FROM cart u where u.danhsachphanloaiid=?1",nativeQuery = true)
	Cart findCartByDanhsachId(Long id);
	@Query(value = "SELECT image,title,giasale FROM cart u where u.userid=?1",nativeQuery = true)
	String[][] findGioByCart(Long userid);
	
	@Query(value = "SELECT phanloaihang FROM cart u where u.id=?1",nativeQuery = true)
	String findPhanloaiByCart(Long id);
	@Query(value = "SELECT * FROM cart u where u.userid=?1",nativeQuery = true)
	List<Cart> findUseridByCart(Long userid);
	
	Cart findOneById(Long id);
	
	

}
