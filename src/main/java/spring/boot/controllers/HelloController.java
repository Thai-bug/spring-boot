package spring.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import spring.boot.services.MessageService;

@Controller("api/v1")
@ResponseBody
public class HelloController {

  @Autowired
  private MessageService messageService;

  @GetMapping("")
  public LinkedTreeMap index(
    @RequestParam(required = false) String mobile
  ) {
    LinkedTreeMap result = messageService.sendTextMessage(mobile);

    return result;
  }
}
