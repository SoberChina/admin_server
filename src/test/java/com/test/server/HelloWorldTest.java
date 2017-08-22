package com.test.server;

import com.test.admin.ServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by liweigao on 2017/7/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerApplication.class)
public class HelloWorldTest {

  private static final String[] BANNER = {"",
      "  .   ____          _            __ _ _",
      " /\\\\ / ___'_ __ _ _(_)_ __  __ _ \\ \\ \\ \\",
      "( ( )\\___ | '_ | '_| | '_ \\/ _` | \\ \\ \\ \\",
      " \\\\/  ___)| |_)| | | | | || (_| |  ) ) ) )",
      "  '  |____| .__|_| |_|_| |_\\__, | / / / /",
      " =========|_|==============|___/=/_/_/_/"};

  @Test
  public void test() {

    for (String line : BANNER) {
      System.out.println(line);
    }
  }
}
