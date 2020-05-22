package kosta.mvc.board.repository;

import java.util.List;

import kosta.mvc.board.domain.ElectronicsDTO;

public interface BoardDAO{
	/**
	  * ���ڵ� ��ü �˻�
	  * */
	  List<ElectronicsDTO> selectAll() ;
	  
	  /**
		  * �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻�
		  * */
	  ElectronicsDTO selectByModelNum(String modelNum) ;
	  
	  /**
	   * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ��ȸ�� �����ϱ�
	   * */
	  int readnumUpdate(String modelNum);
	  
	/**
	 * ���ڵ� ����
	 * */
	  int insert(ElectronicsDTO electronics);
	  
	  /**
	   * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	   * */
	   int delete(String modelNum, String password);
	  
	   /**
	    * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	    * */
	   int update(ElectronicsDTO electronics);

}
