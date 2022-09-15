package spring.boot.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;
import java.util.Date;

public class ErrorDetail {
  @Getter
  @Setter
  private Date date;
  @Getter
  @Setter
  private String message;
  @Getter
  @Setter
  private String details;

  public ErrorDetail() {
  }

  public ErrorDetail(Date date, String message, String details) {
    this.date = date;
    this.message = message;
    this.details = details;
  }

}
