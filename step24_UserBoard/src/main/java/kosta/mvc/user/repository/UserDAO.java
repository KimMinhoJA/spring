package kosta.mvc.user.repository;

import kosta.mvc.user.domain.UserDTO;

public interface UserDAO {
  /**
   * �α��� ���
   * */
	UserDTO loginCheck(UserDTO userDTO);
}
