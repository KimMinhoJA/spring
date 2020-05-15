package kosta.mvc.mino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.mino.domain.ProductDTO;
import kosta.mvc.mino.exception.DuplicatedException;
import kosta.mvc.mino.exception.PriceRangeException;
import kosta.mvc.mino.repository.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO dao;
	
	@Override
	public List<ProductDTO> select() {
		List<ProductDTO> list = dao.select();
		return list;
	}

	@Override
	public int insert(ProductDTO productDTO) throws DuplicatedException, PriceRangeException {
		if(productDTO.getPrice() < 1000 || productDTO.getPrice() > 10000) {
			throw new PriceRangeException("������ 1000 ~ 10000���� ����� �� �ֽ��ϴ�.");
		}
		dao.insert(productDTO);
		return 0;
	}

	@Override
	public int delete(String code) {
		dao.delete(code);
		return 0;
	}

	@Override
	public ProductDTO detail(String code) throws DuplicatedException{
		ProductDTO product = dao.detail(code);
		if(product == null) throw new DuplicatedException(code + "�� ��ǰ ������ �����ϴ�.");
		return dao.detail(code);
	}
}
