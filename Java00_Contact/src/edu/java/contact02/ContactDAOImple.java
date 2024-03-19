package edu.java.contact02;


//DAO(Data Access Object) :
//- 데이터의 전송을 담당하는 역할
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
	
	public static final int MAX = 100; // 연락처 최대 저장 개수
	// 연락처 저장 배열
	public static ContactVO[] list = new ContactVO[MAX];
	public static int size = 0; // 배열에 데이터를 저장하면 증가
	
	public int getSize() {
		return size;
	}
	
	@Override
	public int insert(ContactVO vo) {
		list[size] = vo;
		size++;
		return 1;
	}

	@Override
	public ContactVO[] select() {
		return list;
	}

	@Override
	public ContactVO select(int index) {
		return list[index];
	}

	@Override
	public int update(int index, ContactVO vo) {
		list[index].setPhone(vo.getPhone());
		list[index].setEmail(vo.getEmail());
		return 1;
	}

}
