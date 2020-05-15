package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathvariableController {
	@RequestMapping(value = "{type}/{id}.do")
	public String aa(@PathVariable String type,@PathVariable String id) {
		System.out.println("PathvariableController ����");
		System.out.println("type = " + type);
		System.out.println("id = " + id);
		return "result";
	}
	
	/**
	 *   /blog/*����
	 */
	@RequestMapping(value = "/{id}")
	public String bb(@PathVariable String id) {
		System.out.println("blog/" + id + " ��û �Ǿ����ϴ�.");
		return "result";
	}
	
	@RequestMapping("/{board}/{type}/{page}")
	public String cc(@PathVariable("type") String typeName, @PathVariable String page) {
		System.out.println(typeName + "�Խ����� " + page + "������");
		return "result";
	}
	
	/**
	 *	���� �ּ�(url)�� view�� �̸��� �ȴ�.
	 */
	@RequestMapping("{url}.do")
	public void url() {}
}
