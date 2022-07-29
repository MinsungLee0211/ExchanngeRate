import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * 
 * excJSON 클래스는 api layer에서 제공하는 데이터를 JSON형태로 가져오는 클래스입니다.
 * 환율 정보를 JSON데이터로 가져와서 exc객체를 만들어 저장하여 반환합니다. */
public class excJSON {
	// api키로 apilayer에서 제공해줍니다. 고정적으로 사용되기 때문에 final static변수로 설정하겠습니다.
	final static String apiKey = "tUxsDwwjT72GgMLoJRprXlqc34wmOzX4";

	//입력하면 정보를 JSON데이터로 가져와 exc객체를 만들어 반환합니다.
	public exc getexc(boolean success, String timestamp, String base, String date, double GBP, double JPY, double EUR) {
		// JSON데이터를 요청하는 URLstr을 만듭니다.
       String urlStr = "https://api.apilayer.com/exchangerates_data/latest?symbols=GBP%2CJPY%2CEUR&base=USD"
        		+ "&apiKey=" + apiKey + "&success=" + success + "&timestamp=" + timestamp
        		+ "&base="+ base + "&date=" + date + "&GBP=" + GBP + "&JPY=" + JPY + "&EUR=" + EUR + "&_type=json";
		
       exc vl = new exc(); // 결과 데이터를 저장할 객체를 만듭니다.
        try {
        	URL url = new URL(urlStr); // 완성된 urlStr을 사용해서 URL 만들어 해당 데이터를 가져옵니다.
            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = "";
            String result="";
            //버퍼에 있는 정보를 문자열로 변환.
            while((line=bf.readLine())!=null){ //bf 에 있는값을 읽어와서 하나의 문자열로 만듭니다.
                result=result.concat(line);
            }
           //System.out.println(result);
            
            //문자열을 JSON으로 파싱합니다. 마지막 배열형태로 저장된 데이터까지 파싱해냅니다.
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj = (JSONObject) jsonParser.parse(result);
            JSONObject parse_response = (JSONObject) jsonObj.get("response");
            
            
    		JSONObject obj;
    		String category;
    		// 기준 날짜와 기준시간을 VillageWeather 객체에 저장합니다.
    		vl.timestamp = timestamp;
    		vl.base = base;
            vl.date = date;
    		
            for(int i = 0; i < parse_response.size(); i++) {
            	obj = (JSONObject) parse_response.get(i); // 해당 response을 가져옵니다.
            	category = (String)obj.get("category"); //response에서 카테고리를 검색해옵니다.
            
            	// 검색한 카테고리와 일치하는 변수에 문자형으로 데이터를 저장합니다.
            	// 데이터들이 형태가 달라 문자열로 통일해야 편합니다. 꺼내서 사용할때 다시변환하는게 좋습니다.
            	switch(category) {
            		case "timestamp":
            			vl.timestamp = (obj.get("fcstValue")).toString();
            			break;
            		case "base":
            			vl.base = (obj.get("fcstValue")).toString();
            			break;
            		case "date":
            			vl.date = (obj.get("fcstValue")).toString();
            			break;
            	}
            }

		} catch (MalformedURLException e) {
			System.out.println("MalformedURLException : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IOException : " + e.getMessage());
		} catch (ParseException e) {
			System.out.println("ParseException : " + e.getMessage());		
		}
        
        
		return vl;// 모든값이 저장된 exc객체를 반환합니다.
    }
}