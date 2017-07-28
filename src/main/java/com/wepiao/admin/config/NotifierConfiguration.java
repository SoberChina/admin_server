package com.wepiao.admin.config;

import de.codecentric.boot.admin.notify.Notifier;
import de.codecentric.boot.admin.notify.RemindingNotifier;
import de.codecentric.boot.admin.notify.filter.FilteringNotifier;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 提醒关闭
 */
//@Configuration
//@EnableScheduling
public class NotifierConfiguration {

  @Autowired
  private Notifier notifier;

  @Bean
  public FilteringNotifier filteringNotifier() {
    return new FilteringNotifier(notifier);
  }

  @Bean
  @Primary
  public RemindingNotifier remindingNotifier() {
    RemindingNotifier remindingNotifier = new RemindingNotifier(notifier);
    remindingNotifier.setReminderPeriod(TimeUnit.MINUTES.toMillis(5));
    return remindingNotifier;
  }

  @Scheduled(fixedRate = 60_000L)
  public void remind() {
    remindingNotifier().sendReminders();
  }
}