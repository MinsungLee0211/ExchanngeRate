import java.sql.Statement;
import java.sql.Connection;
//import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Enumeration;

/*데이터베이스에 접속하여 조작에 관한 기능의정의된 클레스 입니다.*/
public class excDAO {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  // jdbc 드라이버 주소
	static final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false"; // DB 접속 주소
	//localhost는 접속하려는 데이터베이스 주소를 입력하시면 됩니다. localhost를 사용하면 됩니다.
	//3306은 데이터베이스에 접속할때 사용하는 포터번호입니다. 설치할때 설정한 포트번호를 사용합니다.
	//yourWeather에는 접속하려는 database의 name(test)을 입력해줍니다. 
	static final String USERNAME = "root"; // DB ID
	static final String PASSWORD = "min93355729@"; // DB Password

	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	// exc객체를 입력받으면 객체안의 속성에 초기화된 데이터들을 데이터베이스에 인설트하는 메소드입니다.
	public void intertVillageWeather(int id, exc v) {
		
		String query = "INSERT INTO exchangerate"
				+ " VALUE(" + id +",'"+v.gettimestamp() + "','" + v.getbase() + "','" + v.getdate() + "');";
		System.out.print("Your Database in : ");
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

    public void intertexc(int i, exc vw) {
    }

}
