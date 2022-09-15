package spring.boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import spring.boot.irequest.*;

@Service
public class ApiService {
  private final Retrofit retrofit;

  @Autowired
  ApiService() {
    this.retrofit = new Retrofit.Builder()
        .baseUrl("https://pokeapi.co")
        .build();
  }

  public ResponseBody handleRequest(String baseUrl) {
    Call<ResponseBody> pokes = retrofit.create(StripApi.class).listPokes();
    try {
      Response<ResponseBody> response = pokes.execute();
      return response.body();
    } catch (Exception e) {
      System.out.println("Có lỗi");
      e.printStackTrace();
      return null;
    }
  }

}
