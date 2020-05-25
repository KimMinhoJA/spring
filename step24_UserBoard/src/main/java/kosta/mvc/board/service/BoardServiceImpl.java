package kosta.mvc.board.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kosta.mvc.board.domain.ElectronicsDTO;
import kosta.mvc.board.repository.BoardDAO;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO dao;
	
	@Override
	public int delete(String modelNum, String password, String path) {
		ElectronicsDTO elec = dao.selectByModelNum(modelNum);
		if(!elec.getPassword().equals(password.trim())) {
			throw new RuntimeException("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
		int result =dao.delete(modelNum, password);
		if(result == 0) {
			throw new RuntimeException("���� ����");
		}
		
		//�����Ϸ� �� ÷�ε� ���� ������ �����
		if(elec.getFsize() > 0) {
			new File(path + "/" + elec.getFname()).delete();
		}
		return result;
	}
	
	@Override
	public int insert(ElectronicsDTO electronics) {
		int result = dao.insert(electronics);
		if(result == 0) throw new RuntimeException("��� ����");
		return result;
	}
	
	@Override
	public List<ElectronicsDTO> selectAll() {
		return dao.selectAll();
	}
	
	@Override
	public ElectronicsDTO selectByModelNum(String modelNum, boolean state) {
		if(state) {
			int result = dao.readnumUpdate(modelNum);
			if(result == 0) throw new RuntimeException("��ȸ�� ������ ���� �߻�");
		}
		ElectronicsDTO elec =  dao.selectByModelNum(modelNum);
		if(elec == null) throw new RuntimeException(modelNum + "�� ���� ������ �����ϴ�.");
		return elec;
	}
	
	@Override
	public int update(ElectronicsDTO electronics) {
		//��й�ȣ ������ üũ...
		ElectronicsDTO elec = dao.selectByModelNum(electronics.getModelNum());
		if(!elec.getPassword().equals(electronics.getPassword())) {
			throw new RuntimeException("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
		int result = dao.update(electronics); 
		if(result == 0) {
			throw new RuntimeException("�����ϱ� ����");
		}
		return result;
	}
}
