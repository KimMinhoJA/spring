package kosta.mvc.model.repository;

import kosta.mvc.model.domain.Member;

public interface MemberDAO {
  /**
   *  ȸ������
   * */
	int insertMember(Member member);
	
	
	/**
	 * ID�� �ش��ϴ� ȸ������ �˻�
	 * */
	Member selectMemberById(String id);
}
