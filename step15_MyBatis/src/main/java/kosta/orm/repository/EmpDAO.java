package kosta.orm.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kosta.orm.domain.Employees;

public class EmpDAO {
	/**
	 * 사원 first_name 가져오기
	 */
	public void selectByName() {
		SqlSession session = Dbutil.getSession();
		try{
			List<String> list = session.selectList("emp.selectByName");//Mapper에 있는 id가 들어간다. -> 이때 namespace.id를 해줘야한다.
		
			for(String name : list) {
				System.out.println(name);
			}
		}finally {
			Dbutil.sessionClose(session);
		}
	}
	
	/**
	 * 등록하기
	 */
	public void insert(Employees employees) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = Dbutil.getSession();
			state = session.insert("emp.empInsert", employees) > 0 ? true : false;
			System.out.println("state = " + state);
		}finally {
			Dbutil.sessionClose(session, state);
		}
	}
	
	/**
	 * 삭제하기
	 */
	public void delete(int employeeId) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = Dbutil.getSession();
			state = session.delete("emp.empDelete", employeeId) > 0 ? true : false;
			System.out.println("state = " + state);
		}finally {
			Dbutil.sessionClose(session, state);
		}
	}
	
	
	/**
	 * 수정하기
	 */
	public void update(Employees employee) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = Dbutil.getSession();
			state = session.delete("emp.empUpdate", employee) > 0 ? true : false;
			System.out.println("state = " + state);
		}finally {
			Dbutil.sessionClose(session, state);
		}
	}
	
	/**
	 * 전체 검색
	 */
	public void selectAll() {
		SqlSession session = null;
		try {
			session =  Dbutil.getSession();
			List<Employees> list = session.selectList("empSelect.selectAll");
			for(Employees e : list) {
				System.out.println(e);
			}
		}finally {
			Dbutil.sessionClose(session);
		}
	}
	
	/**
	 * employee_id에 해당하는 사원 검색
	 */
	public void selectByEmpId(int employeeId) {
		SqlSession session = null;
		try {
			session =  Dbutil.getSession();
			Employees employee = session.selectOne("empSelect.selectByEmpId", employeeId);
			System.out.println(employee);
		}finally {
			Dbutil.sessionClose(session);
		}
	}
	
	
	/**
	 * 특정 컬럼을 기준으로 정렬하기
	 */
	public void selectByOrder(String columnName) {
		SqlSession session = null;
		try {
			session =  Dbutil.getSession();
			List<Employees> list = session.selectList("empSelect.selectByOrder", columnName);
			for(Employees employee : list) {
				System.out.println(employee);
			}
		}finally {
			Dbutil.sessionClose(session);
		}
	}
	
	/**
	 * salary를 인수로 전달받아 salary보다 적게 받는 사원의 정보 검색
	 */
	public void selectWhereSalary(int salary) {
		SqlSession session = null;
		try {
			session =  Dbutil.getSession();
			List<Employees> list = session.selectList("empSelect.selectWhereSalary", salary);
			for(Employees employee : list) {
				System.out.println(employee);
			}
		}finally {
			Dbutil.sessionClose(session);
		}
	}
	

	/**
	 * salary가 최소 ~ 최대 사이 검색하기
	 */
	public void selectByMinMax(int min, int max) {
		SqlSession session = null;
		try {
			session =  Dbutil.getSession();
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("min", min);
			map.put("max", max);
			
			List<Employees> list = session.selectList("empSelect.selectByMinMax", map);
			for(Employees employee : list) {
				System.out.println(employee);
			}
		}finally {
			Dbutil.sessionClose(session);
		}
	}
	
	
	/**
	 * 검색 필드와 검색단어로 검색하기
	 */
	public void selectByKeyField(String keyField, String keyWord) {
		SqlSession session = null;
		try {
			session =  Dbutil.getSession();
			Map<String, String> map = new HashMap<String, String>();
			map.put("keyField", keyField);
			map.put("keyWord", keyWord);
			
			List<Employees> list = session.selectList("emp.selectByKeyField", map);
			for(Employees employee : list) {
				System.out.println(employee);
			}
		}finally {
			Dbutil.sessionClose(session);
		}
	}
}
