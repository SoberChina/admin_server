package com.wepiao.admin.config;

import de.codecentric.boot.admin.config.AdminServerCoreConfiguration;
import de.codecentric.boot.admin.model.Application;
import de.codecentric.boot.admin.registry.store.ApplicationStore;
import de.codecentric.boot.admin.web.client.ApplicationOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

/**
 * Created by liweigao on 2017/8/11.
 */
@Component
@AutoConfigureAfter(AdminServerCoreConfiguration.class)
@EnableConfigurationProperties(CheckApplicationTaskProperties.class)
public class ApplicationTaskConfig implements CommandLineRunner {

  private Logger logger = LoggerFactory.getLogger(ApplicationTaskConfig.class);

  private final ThreadPoolTaskScheduler threadPoolTaskScheduler;

  private final ApplicationStore applicationStore;

  private final CheckApplicationTaskProperties checkApplicationTaskProperties;

  private final ApplicationOperations applicationOperations;

  public ApplicationTaskConfig(ApplicationStore applicationStore,
      ThreadPoolTaskScheduler threadPoolTaskScheduler,
      ApplicationOperations applicationOperations,
      CheckApplicationTaskProperties checkApplicationTaskProperties) {
    this.threadPoolTaskScheduler = threadPoolTaskScheduler;
    this.applicationStore = applicationStore;
    this.applicationOperations = applicationOperations;
    this.checkApplicationTaskProperties = checkApplicationTaskProperties;
  }

  @Override
  public void run(String... strings) throws Exception {

    threadPoolTaskScheduler.scheduleAtFixedRate(new Runnable() {
      @Override
      public void run() {
        if (checkApplicationTaskProperties.getCheck().isCheck()) {
          removeHandle();
        }
      }
    }, checkApplicationTaskProperties.getCheck().getPeriod());
  }

  public void removeHandle() {

    for (Application application : applicationStore.findAll()) {
      if (isDelete(application)) {
        //如果访问不通删除该节点
        applicationStore.delete(application.getId());
        logger.info("remove : {}", application.toString());
      }
    }
  }

  protected boolean isDelete(Application application) {
    try {
//      URI uri = UriComponentsBuilder.fromHttpUrl(application.getHealthUrl()).build().toUri();
//      doGet(application, uri, String.class);
      applicationOperations.getHealth(application);
      return false;
    } catch (ResourceAccessException ex) {
      return true;
    } catch (Exception e) {
      return true;
    }
  }

//  protected <T> ResponseEntity<T> doGet(Application application, URI uri, Class responseType) {
//    ResponseEntity<T> response = restTemplate
//        .exchange(uri, HttpMethod.GET, null,
//            responseType);
//    return response;
//  }
}


