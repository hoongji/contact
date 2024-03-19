package edu.java.contact04;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactMain04 {
		
	public static Scanner sc = new Scanner(System.in);
	public static ContactDAO dao;

	public static void main(String[] args) {
		System.out.println("연락처 프로그램 version 0.4");
		dao = ContactDAOImple.getInstance();
		
		boolean run = true; // 반복문 종료용
		
		while(run) {
			showMainMenu();
			int choice = sc.nextInt(); // 메뉴 선택 저장
			
			switch (choice) {
			case Menu.INSERT:
				insertContact();
				break;
			case Menu.SELECT_ALL:
				selectAllContact();
				break;
			case Menu.SELECT:
				selectContact();
				break;
			case Menu.UPDATE:
				updateContact();
				break;
			case Menu.DELETE:
				deleteContact();
				break;
			case Menu.QUIT:
				run = false;
				System.out.println("프로그램이 종료되었습니다.");
				break;
			default:
				break;
			}
		}

	} // end main()
	
	// contact 배열에 contact 인스턴스를 저장
	private static void insertContact() {
		System.out.println("-------------");
		System.out.println("연락처 등록 메뉴");
		System.out.println("-------------");
		System.out.println("이름 입력>");
		String name = sc.next();
		System.out.println("전화번호 입력>");
		String phone = sc.next();
		System.out.println("이메일 입력>");
		String email = sc.next();
		
		ContactVO vo = new ContactVO(name, phone, email);
		
		int result = dao.insert(vo);
		int size = ((ContactDAOImple) dao).getSize();
		if(result == 1) {
			System.out.println("등록된 연락처 개수 : " + size);
			System.out.println("연락처 등록 완료!");			
		}
	} // end insertContact

	private static void selectAllContact() {
		ArrayList<ContactVO> list = dao.select();
		
		int size = ((ContactDAOImple) dao).getSize();
		System.out.println("연락처 개수 : " + size);
		for(int i = 0; i < size; i++) {
			System.out.println("--- 연락처 " + i + " ---");
			System.out.println(list.get(i).toString());
		}
	} // end selectAllContact()

	private static void selectContact() {
		System.out.println("---------------");
		System.out.println("검색할 인덱스 입력>");
		int index = sc.nextInt();
		
		int size = ((ContactDAOImple) dao).getSize();
		if(index >= 0 && index < size) {
			System.out.println(dao.select(index));			
		} else {
			System.out.println("해당 인덱스에 연락처가 없습니다.");
		}
	} // end selectContact()

	private static void updateContact() {
		System.out.println("수정할 인덱스 입력>");
		int index = sc.nextInt();
		
		int size = ((ContactDAOImple) dao).getSize();
		if(index >= 0 && index < size) {
			System.out.println("이름 입력>");
			String name = sc.next();
			System.out.println("전화번호 입력>");
			String phone = sc.next();
			System.out.println("이메일 입력>");
			String email = sc.next();
			
			ContactVO vo = new ContactVO("", phone, email);
			
			int result = dao.update(index, vo);
			if(result == 1) {
				System.out.println("연락처 수정 완료!");						
			}
		} else {
			System.out.println("해당 인덱스에 연락처가 없습니다.");
		}
	} // end updateContact()
	
	private static void deleteContact() {
		System.out.println("삭제할 인덱스 입력>");
		int index = sc.nextInt();
		
		int size = ((ContactDAOImple) dao).getSize();
		if(index >= 0 && index < size) {
			int result = dao.delete(index);
			
			if(result == 1) {
				System.out.println("연락처 삭제 완료");
			}
		} else {
			System.out.println("해당 인덱스에 연락처가 없습니다.");
		}
		
		System.out.println("연락처 삭제 완료");
	} // end deleteContact()


	private static void showMainMenu() {
		System.out.println("----------------------------------------------------------");
		System.out.println("1. 등록 | 2. 전체검색 | 3. 상세검색 | 4. 수정 | 5. 삭제 | 0. 종료");
		System.out.println("----------------------------------------------------------");
		System.out.println("선택>");
	}
	
	

} // end ContactMain01




