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

    /**
     * 默认关闭检查
     */
    private boolean isCheck = false;

    public int getPeriod() {
      return period;
    }

    public void setPeriod(int period) {
      this.period = period;
    }

    public boolean isCheck() {
      return isCheck;
    }

    public void setCheck(boolean check) {
      isCheck = check;
    }
  }
}
