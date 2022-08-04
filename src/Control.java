public class Control {
    public static void main(String[] args) {
        String base = "USD";
	   
	    // 데이터를 얻어오는 객체를 생성
		testparsing exJson = new testparsing();
		// 데이터를 JSON형태로 받아 rate에 저장
		rate ex = exJson.getrate(base);
		// 데이터베이스에 접속에 관련하는객체를 만들고 데이터베이스에 입력
		rateDAO exDao = new rateDAO();
		exDao.intertrate(ex);
	}
}
