package spring.boot.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.boot.exceptions.ErrorDetail;
import spring.boot.services.MessageService;

@Controller("api/v1")
@ResponseBody
public class HelloController {

  @Autowired
  private MessageService messageService;

  @GetMapping("")
  public Map<String, Object> index(
    @RequestParam(required = false) String mobile
  ) {
    messageService.sendTextMessage(mobile);

    ErrorDetail detail = new ErrorDetail();
    detail.setMessage("Hello");

    Map<String, Object> responseBody = new HashMap<String, Object>();
    responseBody.put("message", "Hello World!");

    return responseBody;
  }
}
