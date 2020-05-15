package kosta.mvc.mino.repository;

import java.util.List;

import kosta.mvc.mino.domain.ProductDTO;
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










