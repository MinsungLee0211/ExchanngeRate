import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class testparsing {
	public rate getrate(String success, String base, String date) {
       rate vl = new rate(); // 결과 데이터를 저장할 객체를 만듭니다.
       try{ //https://api.exchangeratesapi.io/v1/latest?access_key=TZsRtVEHw42GEOvnAZWMtLB4cJVFQt9&base=USD&symbols=GBP,JPY,EUR
        String urlStr = "https://api.exchangerate.host/latest?source=ecb&base=USD&symbols=GBP,JPY,EUR";
        URL url = new URL(urlStr); // 위 urlStr을 이용해서 URL 객체를 만들어줍니다.
        BufferedReader bf;
        String line = "";
        String result = "";

        //정보를 받아옵니다.
        bf = new BufferedReader(new InputStreamReader(url.openStream()));

        //버퍼에 있는 정보를 하나의 문자열로 변환.
        while((line=bf.readLine())!=null){
            result=result.concat(line);
           System.out.println(result);  // 받아온 데이터를 확인해봅니다.
        }
       
         // Json parser를 만들어 만들어진 문자열 데이터를 객체화 합니다. 
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(result);
        
        // Top레벨 단계인 rates 키를 가지고 데이터를 파싱합니다.
        JSONObject parse_rates = (JSONObject) obj.get("rates");

        System.out.println(parse_rates);
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
        return vl;// 모든값이 저장된 객체를 반환합니다.
    }
}