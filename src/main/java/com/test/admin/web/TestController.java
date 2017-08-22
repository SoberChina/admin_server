package com.test.admin.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liweigao on 2017/5/17.
 */
@RestController
public class TestController {

  @RequestMapping(value = "/test", method = {RequestMethod.GET, RequestMethod.HEAD})
  @HystrixCommand
  public ResponseEntity<String> hello() {
    return new ResponseEntity<String>("Client Test", HttpStatus.OK);
  }
}
