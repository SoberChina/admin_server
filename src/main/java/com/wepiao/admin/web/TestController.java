package com.wepiao.admin.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liweigao on 2017/5/17.
 */
@RestController
public class TestController {
  @RequestMapping(value = "/hello")
  @HystrixCommand
  public ResponseEntity<String> hello() {
    return new ResponseEntity<String>("Client Test", HttpStatus.OK);
  }
}
