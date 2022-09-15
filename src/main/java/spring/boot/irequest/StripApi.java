package spring.boot.irequest;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface StripApi {
  @GET("/api/v2/ability/7")
  Call<ResponseBody> listPokes();
}
