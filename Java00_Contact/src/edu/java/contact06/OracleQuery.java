package edu.java.contact06;

public interface OracleQuery {

// Oracle DB 정보 인터페이스. DB 연결을 위한 상수. 사용자 정보
//	테이블 및 컬럼 정보. 쿼리 작성

//	사용자 정보	
	public static final String URL = 
			"jdbc:oracle:thin:@localhost:1521:xe"; //  접속할 오라클 DB 경로 
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";

// DB 연결을 위한 상수	
	public static final String TABLE_NAME = "EX_CONTACT";
	public static final String COL_CONTACT_ID = "CONTACT_ID";
	public static final String COL_NAME = "NAME";
	public static final String COL_PHONE = "PHONE";
	public static final String COL_EMAIL = "EMAIL";
	
//	테이블 및 컬럼 정보. 쿼리 작성
	//INSERT
	public static final String SQL_INSERT = 
			"INSERT INTO " + TABLE_NAME
			+ " VALUES (CONTACT_SEQ.NEXTVAL, ?, ?, ?)";
	
	//SELECT_ALL
	public static final String SQL_SELECT =	
			"SELECT * FROM " + TABLE_NAME 
			+ " ORDER BY " + COL_CONTACT_ID;
	
	//SELECT_BY_CONTACT_Id 
	public static final String SQL_SELECT_BY_CONTACT_ID =
				"SELECT * FROM " + TABLE_NAME 
				+ " WHERE " + COL_CONTACT_ID + " = ?";
	
	
	//UPDATE
	public static final String SQL_UPDATE = 
						"UPDATE " + TABLE_NAME + " SET " +
						COL_NAME + " = ?, " +
						COL_PHONE + " = ?, " +
						COL_EMAIL + " = ? " +
						"WHERE " + COL_CONTACT_ID  + " = ?";
	
	// DELETE 
	public static final String SQL_DELETE = 
						"DELETE " + TABLE_NAME + " WHERE "
						+ COL_CONTACT_ID + " = ?";
	
	
}
