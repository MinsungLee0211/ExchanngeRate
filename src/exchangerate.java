//api layer 예시 코드 (Java 조회 코드)

import java.io.*;
import okhttp3.*;   


public class exchangerate {
  private static final RequestBody RequestBody = null;

  public static void main(String []args) throws IOException{
    OkHttpClient client = new OkHttpClient().newBuilder().build();

    Request request = new Request.Builder()
      .url("https://api.apilayer.com/exchangerates_data/latest?symbols=GBP%2CJPY%2CEUR&base=USD")
      .addHeader("apikey", "tUxsDwwjT72GgMLoJRprXlqc34wmOzX4")
      .method("GET", RequestBody) 
      .build();
    Response response = client.newCall(request).execute();
    System.out.println(response.body().string());
  }
}