package spring.boot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import okhttp3.ResponseBody;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class MessageService {

  @Autowired
  private ApiService apiService;

  private Gson gson;

  @Autowired
  MessageService(){
    this.gson = new Gson();
  }

  // @Async()
  public LinkedTreeMap sendTextMessage(String mobile)  {
    String result;
    try {
      result = apiService.handleRequest("api/v2/pokemon/ditto").string();
      return (LinkedTreeMap) gson.fromJson(result, Object.class);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return null;
    }
   
  }

  private void sleep(int args) {
    try {
      TimeUnit.SECONDS.sleep(args);
    } catch (InterruptedException e) {
      System.out.println("Có lỗi");
      e.printStackTrace();
    }
  }
}
