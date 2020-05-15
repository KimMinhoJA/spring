package kosta.mvc.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.domain.FileDTO;

@Controller
public class UploadContoller {
	/**
	 * �Ű������� MultipartFile�� �ָ� ��������..
	 * xml������ CommonsMultipartResolver ������ �ʿ��ϴ�
	 * @param name
	 * @param file
	 * @return
	 */
	@RequestMapping("/upload.do")
	public ModelAndView aa(String name, MultipartFile file, HttpSession session) {
		String path= session.getServletContext().getRealPath("/WEB-INF/save");
		//������ ���� �̸�
		String fileName = file.getOriginalFilename();
		
		//���ε��ϱ�
		try {
			file.transferTo(new File(path + "/" + fileName));
		}catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("uploadResult");
		mv.addObject("name", name);
		mv.addObject("fileName", fileName);
		mv.addObject("fileSize", file.getSize());
		mv.addObject("path", path);
		return mv;
	}
	
	@PostMapping("/upload2.do")
	public String bb(FileDTO dto, HttpSession session) {
		MultipartFile file = dto.getFile();
		String path = session.getServletContext().getRealPath("/WEB-INF/save");
		String fileName = file.getOriginalFilename();
		dto.setFileName(fileName);
		dto.setFileSize(file.getSize());
		dto.setPath(path);
		session.setAttribute("dto", dto);
		try {
			file.transferTo(new File(dto.getPath() + "/" + dto.getFileName()));
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "uploadResult";
	}
	
	/**
	 * �ٿ�ε� ��� ��������
	 */
	@RequestMapping("downList.do")
	public ModelAndView cc(HttpSession session) {
		//save���� �ȿ��� ��� ���(�����̸�)�� �����´�.
		String path = session.getServletContext().getRealPath("/WEB-INF/save");
		String[] list = null;
		File file = new File(path);
		if(file.exists()) {
			list = file.list();
		}
		return new ModelAndView("downList","fileNames",list);
	}
	
	/**
	 * �ٿ�ε� �ϱ�
	 */
	@RequestMapping("down.do")
	public ModelAndView dd(String fname, HttpSession session) {
		String path = session.getServletContext().getRealPath("/WEB-INF/save");
		ModelAndView mv = new ModelAndView();
		mv.addObject("fname", new File(path + "/" + fname));
		mv.setViewName("downLoadView");
		return mv;
	}
}
