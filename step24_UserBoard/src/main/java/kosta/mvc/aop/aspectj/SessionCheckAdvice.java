package kosta.mvc.aop.aspectj;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * ������ session������ üũ�ؼ� ������ ������ ���ܸ� �߻���Ų��.
 */
@Service
@Aspect
public class SessionCheckAdvice {
	@Before("execution(public * kosta.mvc.board.controller.BoardController.*(..))")
	public void sessionCheck(JoinPoint point) {
		//������ ���ϴ� �� �Ѱ����� ���
		RequestAttributes requestAttri = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes servletReq = (ServletRequestAttributes)requestAttri;
		HttpServletRequest request = servletReq.getRequest();
		
		HttpSession session = request.getSession();
		
		//���� ���ϴ� ��� 2(���ڷ� session�� �Ѱ��ش�.)
//		Object params[] = point.getArgs();
//		HttpSession session = (HttpSession)params[0];
		if(session == null || session.getAttribute("loginUser") == null) {
			throw new RuntimeException("�α����ϰ� �̿����ּ���.");
		}
	}
}
