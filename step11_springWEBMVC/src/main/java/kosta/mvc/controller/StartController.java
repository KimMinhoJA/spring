package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	//�����̸鼭 Controller�� ������ �ȴ�.
public class StartController {
	/**
	 * ������ ���ڿ��̸� ���ϰ��� ���̸��� �ȴ�.
	 * @return
	 */
	@RequestMapping("/a.do")
	public String aaa() {
		System.out.println("a.do�� ��û�Ǿ����ϴ�.....");
		return "result";	//WEB-INF/views/result.jsp�� �̵��϶�� �ǹ�
	}
}
