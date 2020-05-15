package kosta.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController	//�� Ŭ������ ������ @ResponseBody���� ����Ѵ�. -> ������ �񵿱�ȭ ��Ÿ��� �ϰԵȴ�.   --> @Controller + @ResponseBody
public class ResponsBodyController {
	@RequestMapping(value = "/responseBody.do", produces = "text/html;charset=UTF-8")
	//@ResponseBody//���ϵǴ� ���� �״�� ���� ��ü�� �ȴ�.
	public String aa() {
		System.out.println("responseBody.do�� ��û�Ǿ����ϴ�....");
		return "���� ����? - hello?";	//������ �̵��� ���� �ʰ� �׳� �ѷ��ְ� �ȴ�.
	}
	
	@RequestMapping(value = "responseBody2.do", produces = "text/html;charset=UTF-8")
	//@ResponseBody
	public String bb() {
		System.out.println("responseBody2.do ��û�Ǿ����ϴ�...");
		return "����";
	}
}
