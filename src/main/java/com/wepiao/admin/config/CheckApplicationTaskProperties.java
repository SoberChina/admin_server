package com.wepiao.admin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by liweigao on 2017/8/11.
 */
@ConfigurationProperties("spring.boot.admin")
public class CheckApplicationTaskProperties {

  private CheckApplication check = new CheckApplication();

  public CheckApplication getCheck() {
    return check;
  }

  public void setCheck(CheckApplication check) {
    this.check = check;
  }

  public static class CheckApplication {

    /**
     * 默认检查application节点的时间间隔 ms
     */
    private int period = 60000;

    public int getPeriod() {
      return period;
    }

    public void setPeriod(int period) {
      this.period = period;
    }
  }
}
