package spring.boot.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

@Service
public class MessageService {

  @Async()
  public void sendTextMessage(String mobile) {
    System.out.print(1/0);
    sleep(2);
    System.out.println(mobile);
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
