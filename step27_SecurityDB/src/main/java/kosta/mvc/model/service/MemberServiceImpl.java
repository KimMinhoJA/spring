package kosta.mvc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kosta.mvc.model.domain.Member;
import kosta.mvc.model.repository.AuthoritiesDAO;
import kosta.mvc.model.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDao;
	@Autowired
	private AuthoritiesDAO authoritiesDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public int joinMember(Member member) {
		//�����ϱ����� ���� ��ȣȭ�ؼ� ���
		member.setPassword(passwordEncoder.encode(member.getPassword()));
		int result = memberDao.insertMember(member);
		//insert�� sql���� ������ ���� �ʴ� �̻� ���� �߻������� ���� ������ ����ó�� ���� �����൵ �ȴ�. --> �ٵ� ���ֽó�.. ���� ���� �׳�
		if(result == 0) {
			throw new RuntimeException("���� ����");
		}
		
		//������ �����ϸ� ���� �ο�...
		if(member.getUserType() == 1) {
			
		}
		return 0;
	}

}
