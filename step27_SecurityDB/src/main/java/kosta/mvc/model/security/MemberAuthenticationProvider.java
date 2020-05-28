package kosta.mvc.model.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kosta.mvc.model.domain.Authority;
import kosta.mvc.model.domain.Member;
import kosta.mvc.model.repository.AuthoritiesDAO;
import kosta.mvc.model.repository.MemberDAO;

/**
 * ����ڰ� �α��� ������ �Է� �� �� �α����� Ŭ������ �� ����ó���� ���� class
 */
@Service
public class MemberAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	private MemberDAO memberDao;
	
	@Autowired
	private AuthoritiesDAO authoritiesDao;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// �μ��� ���޵� ��������  id�� ������ DB�� �ִ��� üũ
		Member member = memberDao.selectMemberById(authentication.getName());
		if(member == null) {
			throw new UsernameNotFoundException("���̵� �������� �ʽ��ϴ�.");
		}
		
		// ������ ��й�ȣ üũ
		if(!encoder.matches(authentication.getCredentials().toString(), member.getPassword())) {
			throw new UsernameNotFoundException("��й�ȣ�� Ʋ�Ƚ��ϴ�..");
		}
		
		//��� ������ ��Ȯ�ϸ� ������ ������� ������ �˻�
		List<Authority> authorityList = authoritiesDao.selectAuthorityByUserName(member.getId());
		
		if(authorityList == null || authorityList.size() == 0) {
			throw new UsernameNotFoundException("���� ã�� ����");
		}
		
		List<SimpleGrantedAuthority> authList = new ArrayList<>();
		
		for(Authority auth : authorityList) {
			authList.add(new SimpleGrantedAuthority(auth.getRole()));
		}
		
		//������ ������ ������ Authentication�� �����ϰ� ����.
		return new UsernamePasswordAuthenticationToken(member, null, authList);
	}

	/**
	 * �μ��� ���޵� authentication�� ������ �� �� �ִ� ��ȿ�� ��ü������ �Ǵ��ϴ� �޼ҵ� - true�ΰ�� authenticate�޼ҵ尡 ȣ��ȴ�.
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
