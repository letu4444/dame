package Shoppe.serviecs.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Shoppe.persistence.dao.ImageProductRepository;
import Shoppe.serviecs.ImageProduct;


@Service
public class ImageProductServerc implements ImageProduct{
 
	@Autowired
	private ImageProductRepository imageProductRepository;
	
	@Override
	public String[] findOneByProduct3(Long id) {
		
		return imageProductRepository.findOneByProduct3(id);
	}

}
