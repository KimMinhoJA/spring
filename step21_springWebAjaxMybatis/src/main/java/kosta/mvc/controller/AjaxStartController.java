package kosta.mvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.mvc.model.domain.Member;

@RestController
public class AjaxStartController {
	@RequestMapping(value = "/load", produces = "text/html; charset=UTF-8;")
	public String load() {
		return "Hava a nice Day - �����";
	}
	
	@PostMapping(value = "/ajax", produces = "text/html; charset=UTF-8;")
	public String ajax(String name) {
		return name + "�� �ݰ�����^^";
	}

	/**
	 * jackson LIB�� ������ ���䰴ü�� �ڹ��� ��ü Ÿ���� ��쿡 �߰��� JSON���·� �ڵ����� ��ȯ�ؼ� ��������
	 */
	@RequestMapping("/array")
	public List<String> array(){
		List<String> menus = Arrays.asList("¥��", "«��", "������", "«¥��");
		
		return menus;
	}
	
	@RequestMapping("/jsonDTO")
	public Member test() {
		return new Member("kim", 22, "����", "010-8888-7777");
	}
	
	@RequestMapping("/jsonList")
	public List<Member> list(){
		List<Member> list = new ArrayList<Member>();
		list.add(new Member("min", 20, "�Ǳ�", "010-8888-8888"));
		list.add(new Member("ho", 21, "����", "010-8888-5555"));
		list.add(new Member("��", 22, "����", "010-8888-4444"));
		list.add(new Member("��", 23, "�뱸", "010-8888-3333"));
		list.add(new Member("��", 24, "�λ�", "010-8888-2222"));
		list.add(new Member("��", 25, "���", "010-8888-1111"));
		return list;
	}
	
	
	@RequestMapping("/jsonMap")
	public Map<String, Object> map(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "���ɽð� �� �ȳ��Ҵ�.");
		map.put("pageNum", 10);
		List<Member> list = new ArrayList<Member>();
		list.add(new Member("min", 20, "�Ǳ�", "010-8888-8888"));
		list.add(new Member("ho", 21, "����", "010-8888-5555"));
		list.add(new Member("��", 22, "����", "010-8888-4444"));
		list.add(new Member("��", 23, "�뱸", "010-8888-3333"));
		list.add(new Member("��", 24, "�λ�", "010-8888-2222"));
		list.add(new Member("��", 25, "���", "010-8888-1111"));
		map.put("memberList", list);
		map.put("dto", new Member("kim", 22, "����", "010-8888-7777"));
		return map;
	}
}
