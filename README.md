# **SBA client 配置** 
  - **pom引入**
      
    ```
       <!-- SBA-->  
        <dependency>
          <groupId>de.codecentric</groupId>
          <artifactId>spring-boot-admin-starter-client</artifactId>
          <version>${SBA.version}</version>
        </dependency>
        <dependency>
          <groupId>org.jolokia</groupId>
          <artifactId>jolokia-core</artifactId>
        </dependency>
        <!--version 1.5.X之后需要配置management.security.enabled=false client 默认开启保护，managementServerProrpertis 需要SessionCreationPolicy类，也可单独拿出来配置 -->
            <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-security</artifactId>
            </dependency>
    ```

  -  **logback 文件添加**
 
    ```
    <!-- -->
      <include resource="org/springframework/boot/logging/logback/defaults.xml"/>
      <jmxConfigurator/>
    ```

  -  **配置文件(.properties)** 
      ```   
  
        ##spring  Boot admin
        spring.boot.admin.url=http://localhost:8088
        endpoints.health.sensitive=false
        spring.boot.admin.username =test
        spring.boot.admin.password =test
        ##	重试注册的间隔时间
        spring.boot.admin.period=1000
        ##应用启动后自动执行周期性的注册任务
        spring.boot.admin.auto-registration=true
        spring.boot.admin.client.name=goods-card
        ##默认是false，意味着注册的时候，将会使用机器名进行注册，当设置为true的时候，将会用ip进行注册。
        spring.boot.admin.client.prefer-ip=true
        info.version=1.0.0
        info.info=\u76d1\u63a7\u6d4b\u8bd5\u5de5\u5177
        ## admin 监控点的命名，如果你不想使用Admin自带的UI，你可能需要在这里重新定义他们的名字。
        spring.boot.admin.routes.endpoints=env,metrics,trace,dump,jolokia,info,configprops,trace,logfile,refresh,flyway,liquibase,heapdump,activiti,hystrix.stream
        ##关掉安全认证
        #关掉admin server->client 的安全认证
        management.security.enabled=false
        ##关闭项目的安全认证
        security.basic.enabled=false
        ## version 1.5.3 特有配置，（docker 环境下需要传入宿主机的host 和端口）
        spring.boot.admin.client.service-base-url=http://${HOST}:${PORT}
       ```
  
