public class control {

	public static void main(String[] args) {
		// JSON데이터를 얻기위해 필요한 요청변수를 입력해줍니다.
        boolean success = true;
        String timestamp = "1659072666";
        String base = "USD";
        String date = "2022-07-29";
        double GBP = 0.82011;
        double JPY = 133.000499;
        double EUR = 0.979105;

	    
	    // 데이터를 얻어오는 객체를 생성
		excJSON vwJson = new excJSON();
		// 데이터를 JSON형태로 받아 exc에 저장
		exc vw = vwJson.getexc(success, timestamp, base, date, GBP, JPY, EUR);
		// 데이터베이스에 접속에 관련하는객체를 만들고 데이터베이스에 입력
		excDAO vwDao = new excDAO();
		vwDao.intertexc(1, vw);
	}
}
