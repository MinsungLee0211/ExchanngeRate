import com.google.gson.Gson;

public class parsing {
    public static void main(String[] args){
        String jsonStr = "{\"success\": true,\"timestamp\": 1659067804,\"base\": \"USD\",\"date\": \"2022-07-29\",\"GBP\": 0.81995,\"JPY\": 133.216915,\"EUR\": 0.978655}";

        Gson gson = new Gson();

        exchange exchange = gson.fromJson(jsonStr, exchange.class);

        System.out.println(exchange);
    }
}