package Shoppe.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import Shoppe.persistence.model.ImageProduct;




@Transactional
public interface ImageProductRepository extends JpaRepository<ImageProduct, Long>{
   @Query(value = "SELECT image FROM imageproduct u where u.productid=?1",nativeQuery = true)
	String[] findOneByProduct3(Long id);
}
