package kosta.mvc.mino.dao;

import java.util.List;

import kosta.mvc.mino.dto.ProductDTO;
import kosta.mvc.mino.exception.DuplicatedException;

public interface ProductDAO {
   /**
    * �˻�
    * */
	List<ProductDTO> select();
	
	/**
	 * ���
	 * */
	int insert(ProductDTO productDTO)throws DuplicatedException;
	
	/**
	 * ����
	 * */
	 int delete(String code);
	 
	 /**
	  * �󼼺���
	  */
	 ProductDTO detail(String code);
}










