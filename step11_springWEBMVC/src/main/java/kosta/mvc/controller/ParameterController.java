package kosta.mvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.domain.Member;

@Controller
@RequestMapping("/param")
public class ParameterController {
	/**
	 * ���� int���� null�� ���� �� �ִ� ��Ȳ�̶�� Integer�� �����Ѵ�.
	 * @param name
	 * @param age
	 * @return
	 */
	@RequestMapping("/a.do")
	public ModelAndView a1(String name, Integer age) {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		
		ModelAndView mv = new ModelAndView("result");
		return mv;
	}
	
	/**
	 * ������ ���۵Ǵ� �������� �����͸� domain��ü�� binding�ϱ�....
	 * 
	 * parameter������ DTO��ü�� ������ �� ������ �������� �״�� ���޵Ǿ� ����� �� �ִ�.
	 * ������������ �Ӽ����� ���� �Ҷ��� ��ü�̸��� ù���ڸ� �ҹ��ڷ� �����Ѵ�.
	 * ex) Member��ü��� ${member.id}
	 * 
	 * ���� ����� ��ü�� �̸��� �����ϰ� ������ @ModelAttribute("������ �̸�")�����ؼ� ��Ī�� ���� ��� ���� -> ������ �̸��� ��� �Ұ�
	 */
	@PostMapping("/c.do")
	public String dd(@ModelAttribute("m")Member member) {
		System.out.println(member);
		return "paramResult";//WEB-INF/views/paramResult.jsp�� �̵�
	}
	
	/**
	 * �޼ҵ� ����� ���� @ModelAttribute�� �����ϸ� ���� ��Ʈ�ѷ��� ��ȴٰ� ��� �̵��ϴ� �������� Model������ ���޵ȴ�. ${}�� ��밡��
	 * @return
	 */
	@ModelAttribute("msg")
	public String test() {
		return "Spring ¯ ���ƿ�^0^7";
	}
	
	@ModelAttribute("hobbys")
	public List<String> test2(){
		List<String> list = Arrays.asList(new String[] {"����", "����", "����", "���"});
		return list;
	}
	
	/**
	 * @RequestParam�� �����ϸ� required="true"�̹Ƿ� �ݵ�� ���� ���;��Ѵ�.
	 * ����, ���� ���� �� �ִٸ� defaultValue�� �����Ѵ�.
	 * @param userId
	 * @param age
	 */
	@RequestMapping(value = "d.do")// �տ�/ �� �־ �˾Ƽ� ������ ������ ������ �־����
	public void dd(@RequestParam(name = "id", defaultValue = "Guest")String userId, @RequestParam(defaultValue = "0")int age) {
		System.out.println("userId = " + userId);
		System.out.println("age = " + age);
	}
}
