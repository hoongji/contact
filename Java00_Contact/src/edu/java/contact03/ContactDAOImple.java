package edu.java.contact03;

import java.util.ArrayList;

// DAO(Data Access Object) :
// - 데이터의 전송을 담당하는 역할
public class ContactDAOImple implements ContactDAO {

	// 싱글톤 디자인 패턴 적용
	
	// 1. private static 자기 자신 타입의 변수 선언
	private static ContactDAOImple instance = null;
	
	// 2. private 생성자
	private ContactDAOImple() {}
	
	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static ContactDAOImple getInstance() {
		if(instance == null) {
			instance = new ContactDAOImple();
		}
		return instance;
	}
	
	// 연락처 저장 배열
	public static ArrayList<ContactVO> list = new ArrayList<>();
	
	public int getSize() {
		return list.size();
	}
	
	@Override
	public int insert(ContactVO vo) {
		list.add(vo);
		return 1;
	}

	@Override
	public ArrayList<ContactVO> select() {
		return list;
	}

	@Override
	public ContactVO select(int index) {
		return list.get(index);
	}

	@Override
	public int update(int index, ContactVO vo) {
		list.get(index).setPhone(vo.getPhone());
		list.get(index).setEmail(vo.getEmail());
		return 1;
	}

	@Override
	public int delete(int index) {
		list.remove(index);
		return 1;
	}

}
