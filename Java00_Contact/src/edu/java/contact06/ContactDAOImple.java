package edu.java.contact06;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import oracle.jdbc.driver.OracleDriver;




// DAO(Data Access Object) :
// - 데이터의 전송을 담당하는 역할
public class ContactDAOImple implements ContactDAO,OracleQuery {

	// 싱글톤 디자인 패턴 적용
	
	// 1. private static 자기 자신 타입의 변수 선언
	private static ContactDAOImple instance = null;
	
	// 2. private 생성자
	private ContactDAOImple() {
		}
		
	// 3. public static 메소드 - 인스턴스를 리턴하는 메소드 구현
	public static ContactDAOImple getInstance() {
			if(instance == null) {
				instance = new ContactDAOImple();
			}
			return instance;
		}
	
	
	private ArrayList<ContactVO> list = new ArrayList<>(); 
	
	
		
	public int getSize() {
		return list.size();
	}
		@Override
	public int insert(ContactVO vo) {
			System.out.println("insert()");
			int result = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			// PreparedStatement : 매개변수를 갖고 있는 SQL 문장을 활용하기 위한 클래스
			//						Statement와 상속관계
			
			try {
				// 2. Oracle JDBC 드라이버를 메모리에 로드
				DriverManager.registerDriver(new OracleDriver());
				System.out.println("드라이버 로드 성공");
				
				// 3. DB와 Connection(연결)을 맺음
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				System.out.println("DB 연결 성공");
				
				// 4. Connection 객체를 사용하여 PreparedStatement 객체를 생성
				pstmt = conn.prepareStatement(SQL_INSERT);
				
				
				// 5. SQL 문장 완성 - SQL_INSERT 쿼리의 ?를 채워주는 코드
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getPhone());
				pstmt.setString(3, vo.getEmail());
				// SQL 쿼리의 ? 순서와 parameterIndex의 값은 동일하게 지정
				// 예시) ?가 첫 번째이면 parameterIndex = 1
				
				// setInt() : DB의 Number 타입
				// setString() : DB의 varchar, varchar2 타입
				// setFloat() : DB의 Float 타입
				// setDate() : DB의 Date 타입
				
				// 6. SQL 문장 실행(DB 서버로 SQL 전송)
				result = pstmt.executeUpdate();
				
				// 7. DB 서버가 보낸 결과 확인/처리
				System.out.println(result + "행이 삽입됐습니다.");
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return result; // 0 : 실패, 1 : 성공
		}


	@Override
	public ArrayList<ContactVO> select() { // SELECT_ALL
		ArrayList<ContactVO> list = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_SELECT);
			

			rs = pstmt.executeQuery();
	
			list = new ArrayList<>();
			while(rs.next()) { // 레코드가 존재할 때까지
				int contactId = rs.getInt(1); // CONTACT_ID 컬럼
				String name = rs.getString(2); // NAME 컬럼
				String phone = rs.getString(3); // PHONE 컬럼
				String email = rs.getString(4);	// EMAIL 컬럼
				
				ContactVO vo = new ContactVO(contactId, name, phone, email);
				list.add(vo);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public ContactVO select(int contactId) { // SELECT_BY_CONTACT_ID
		ContactVO vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			pstmt = conn.prepareStatement(SQL_SELECT_BY_CONTACT_ID);
			

			rs = pstmt.executeQuery();
	
	
			if(rs.next()) { // 레코드가 존재할 때까지
				contactId = rs.getInt(1); // CONTACT_ID 컬럼
				String name = rs.getString(2); // NAME 컬럼
				String phone = rs.getString(3); // PHONE 컬럼
				String email = rs.getString(4);	// EMAIL 컬럼
				
				vo = new ContactVO(contactId, name, phone, email);

			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	

	@Override
	public int update(int contactId, ContactVO vo) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		// PreparedStatement : 매개변수를 갖고 있는 SQL 문장을 활용하기 위한 클래스
		//						Statement와 상속관계
		
		try {
			// 2. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			
			// 3. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			// 4. Connection 객체를 사용하여 PreparedStatement 객체를 생성
			pstmt = conn.prepareStatement(SQL_UPDATE);
			
			
			// 5. SQL 문장 완성 - SQL_INSERT 쿼리의 ?를 채워주는 코드
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());
			pstmt.setInt(4, contactId);
			// SQL 쿼리의 ? 순서와 parameterIndex의 값은 동일하게 지정
			// 예시) ?가 첫 번째이면 parameterIndex = 1
			
			// setInt() : DB의 Number 타입
			// setString() : DB의 varchar, varchar2 타입
			// setFloat() : DB의 Float 타입
			// setDate() : DB의 Date 타입
			
			// 6. SQL 문장 실행(DB 서버로 SQL 전송)
			result = pstmt.executeUpdate();
			
			// 7. DB 서버가 보낸 결과 확인/처리
			System.out.println(result + "행이 수정됐습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result; // 0 : 실패, 1 : 성공
	}

	
	
	@Override
	public int delete(int contactId) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		// PreparedStatement : 매개변수를 갖고 있는 SQL 문장을 활용하기 위한 클래스
		//						Statement와 상속관계
		
		try {
			// 2. Oracle JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("드라이버 로드 성공");
			
			// 3. DB와 Connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			// 4. Connection 객체를 사용하여 PreparedStatement 객체를 생성
			pstmt = conn.prepareStatement(SQL_DELETE);
			
			
			// 5. SQL 문장 완성 - SQL_INSERT 쿼리의 ?를 채워주는 코드
			pstmt.setInt(1, contactId);
			// SQL 쿼리의 ? 순서와 parameterIndex의 값은 동일하게 지정
			// 예시) ?가 첫 번째이면 parameterIndex = 1
			
			// setInt() : DB의 Number 타입
			// setString() : DB의 varchar, varchar2 타입
			// setFloat() : DB의 Float 타입
			// setDate() : DB의 Date 타입
			
			// 6. SQL 문장 실행(DB 서버로 SQL 전송)
			result = pstmt.executeUpdate();
			
			// 7. DB 서버가 보낸 결과 확인/처리
			System.out.println(result + "행이 삭제됐습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result; // 0 : 실패, 1 : 성공
	}

}
