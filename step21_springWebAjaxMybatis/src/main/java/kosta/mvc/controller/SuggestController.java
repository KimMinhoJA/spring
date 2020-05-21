package kosta.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.mvc.service.SuggestService;

@RestController
public class SuggestController {
	@Autowired
	private SuggestService service;
	
	/**
	 * jackson lib�� �ֱ� ������ ���ϵǴ� List��ü�� json���� ��ȯ�Ͽ� �����Ѵ�.
	 * */
	@RequestMapping("/suggest")
	public List<String> suggest(String word){
		return service.suggest(word);
	}
}
