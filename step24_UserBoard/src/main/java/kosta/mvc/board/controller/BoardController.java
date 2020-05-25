package kosta.mvc.board.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.board.domain.ElectronicsDTO;
import kosta.mvc.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService service;
	String path = "C:\\kosta\\SpringWorkSpace\\save";
	
	@RequestMapping("/list")
	public String url( HttpServletRequest request) {
		List<ElectronicsDTO> list = service.selectAll();
		if(list != null) {
			request.setAttribute("list", list);
		}
		return "board/list";
	}
	
	@RequestMapping("/read/{modelNum}")
	public ModelAndView read(@PathVariable String modelNum) {
		boolean state = true;
		ElectronicsDTO elec = service.selectByModelNum(modelNum, state);
		ModelAndView mv = new ModelAndView("board/read","elec",elec);
		return mv;
	}
	
	/**
	 * ���� ��
	 */
	@PostMapping("/updateForm")
	public ModelAndView updateForm(String modelNum) {
		ElectronicsDTO elec = service.selectByModelNum(modelNum, false);
		return new ModelAndView("board/update","elec",elec);
	}
	
	/**
	 * �����ϱ�
	 */
	@PostMapping("/update")
	public ModelAndView update(ElectronicsDTO electronics) {
		service.update(electronics);
		ElectronicsDTO elec = service.selectByModelNum(electronics.getModelNum(), false);
		return new ModelAndView("board/read", "elec", elec);
	}
	
	/**
	 * �����ϱ�
	 */
	@PostMapping("/delete")
	public String delete(String modelNum, String password) {
		service.delete(modelNum, password, path);
		return "redirect:list";
	}
	
	@RequestMapping("/writeForm")
	public String wirteForm() {
		return "board/write";
	}
	
	@PostMapping("/write")
	public String write(ElectronicsDTO electronics) {
		if(electronics.getFile().getSize() > 0) {
			String fileName = electronics.getFile().getOriginalFilename();
			try {
				electronics.getFile().transferTo(new File(path + "/" + fileName));
			}catch (Exception e) {
				e.printStackTrace();
			}
			electronics.setFname(fileName);
			electronics.setFsize((int) electronics.getFile().getSize());
		}
		service.insert(electronics);
		return "redirect:list";
	}
	
	/**
	 * �ٿ�ε� �ϱ�
	 */
	@RequestMapping("/down")
	public ModelAndView dd(String fname) {
		return new ModelAndView("downLoadView","fname", new File(path + "/" + fname));
	}
}
