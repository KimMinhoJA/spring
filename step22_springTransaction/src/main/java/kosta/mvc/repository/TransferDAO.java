package kosta.mvc.repository;

import kosta.mvc.domain.TransferDTO;

public interface TransferDAO {
	/**
	 * �����ϱ�
	 */
	int withDraw(TransferDTO dto);
	
	/**
	 * �Ա��ϱ�
	 */
	int deposit(TransferDTO dto);
}

