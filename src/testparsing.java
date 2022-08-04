import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/* testparsing 클래스는 api에서 제공하는 환율 데이터를 JSON형태로 가져오는 클래스입니다.
 * 환율 정보를 JSON데이터로 가져와서 rate객체를 만들어 저장하여 반환합니다. */
public class testparsing {

	//기준국가를 입력하면 해당하는 나라의 환율정보를 JSON데이터로 가져와 rate객체를 만들어 반환합니다.

	public rate getrate(String base) {
		// JSON데이터를 요청하는 URLstr을 만듭니다.
       String urlStr = "https://api.exchangerate.host/latest?source=ecb&base=USD&symbols=GBP,JPY,EUR";
		
       rate vl = new rate(); // 결과 데이터를 저장할 동내기상객체를 만듭니다.
        try {
        	URL url = new URL(urlStr); // 완성된 urlStr을 사용해서 URL 만들어 해당 데이터를 가져옵니다.
            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = "";
            String result = "";
            //버퍼에 있는 정보를 문자열로 변환.
            while((line=bf.readLine())!=null){ //bf 에 있는값을 읽어와서 하나의 문자열로 만듭니다.
                result=result.concat(line);
            }
            System.out.println(result);
             
            //문자열을 JSON으로 파싱합니다. 
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj = (JSONObject) jsonParser.parse(result);
            JSONObject parse_rates = (JSONObject) jsonObj.get("rates");
            
    		// 기준 날짜와 기준시간을 VillageWeather 객체에 저장합니다.
    		vl.base = base;
            System.out.println(parse_rates); //{"JPY":133.588385,"EUR":0.980969,"GBP":0.820375}
    }catch(Exception e){
            System.out.println(e.getMessage());
    }
        return vl;// 모든값이 저장된 객체를 반환합니다.
    }
}