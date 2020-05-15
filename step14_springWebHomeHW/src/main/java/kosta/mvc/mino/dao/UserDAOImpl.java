package kosta.mvc.mino.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.mino.dto.UserDTO;
import kosta.mvc.mino.exception.NotFoundException;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	UserDTO user;
	
	@Override
	public UserDTO login(String id, String pwd) throws NotFoundException {
		if(!(user.getId().equals(id) && user.getPwd().equals(pwd))) {
			throw new NotFoundException("���̵� Ȥ�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
		
		return user;
	}

}
