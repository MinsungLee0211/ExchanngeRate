import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*데이터베이스에 접속하여 조작에 관한 기능이 정의된 클레스 입니다.*/
public class rateDAO {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  // jdbc 드라이버 주소
	static final String DB_URL = "jdbc:mysql://172.19.16.1:3306/exchangerate?useSSL=false"; // DB 접속 주소
	static final String USERNAME = "chocomin0211"; // DB ID
	static final String PASSWORD = "min93355729@"; // DB Password

	//DB name : exchangerate, Tablename : ex

	private Connection conn = null;
	private Statement stmt = null;
	
	// rate객체를 입력받으면 객체 안의 속성에 초기화된 데이터들을 데이터베이스에 인설트하는 메소드입니다.
	public void intertrate(rate t) {
		
		String query = "INSERT INTO ex"
        + " VALUE('" + t.success + "', '" + t.base + "', '" + t.date + "', '" + t.GBP + "', '" + t.JPY + "', '" + t.EUR  +"' );";
		System.out.print("exchangerate Database in : ");

		try {
			//데이터베이스에 접속합니다.
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD); 
			
			// 데이터베이스 접속 결과를 출력합니다.
			if (conn != null){System.out.println("good");}
			else{System.out.println("bad");}
			
			System.out.println(query); // 실행될 쿼리문을 출력합니다.
			
			stmt = conn.createStatement(); // 쿼리문을 전송할 Statement 객체를 만듭니다.
			stmt.executeUpdate(query);// 쿼리문을 실행시킵니다.
		    stmt.close();
		    conn.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found Exection");
		} catch (SQLException e) {
			System.out.println("SQL Exception : " + e.getMessage());
		}
	}

}

/*
create table ex(
success char(6),
base char(5),
date char(12),
GBP char(45),
JPY char(45),
EUR char(45));
 */