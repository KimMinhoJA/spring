package kosta.mvc.mino.service;

import java.util.List;

import kosta.mvc.mino.domain.ProductDTO;
import kosta.mvc.mino.exception.DuplicatedException;
import kosta.mvc.mino.exception.PriceRangeException;

public interface ProductService {
		/**
	    * �˻�
	    * */
		List<ProductDTO> select();
		
		/**
		 * ���
		 * */
		int insert(ProductDTO productDTO)throws DuplicatedException, PriceRangeException;
		
		/**
		 * ����
		 * */
		 int delete(String code);
		 
		 /**
		  * �󼼺���
		  */
		 ProductDTO detail(String code) throws DuplicatedException;
}
