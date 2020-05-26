package kosta.mvc.model.repository;

import java.util.List;

import kosta.mvc.model.domain.Authority;

public interface AuthoritiesDAO {

	/**
	 * ����� ���� ���
	 * (�� USER(���̵�)�� �������� ������ ���� �� �ִ�.
	 * */
	int insertAuthority(Authority authority);
	
	/**
	 * id�� �ش��ϴ� ���� �˻�.
	 * */
	List<Authority> selectAuthorityByUserName(String userName);
}






