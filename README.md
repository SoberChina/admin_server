# **SBA client 配置** 
  - **pom引入**
    ...  
    
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
    ...
  -  **logback 文件添加**
    ...  
    <!-- -->
      `include resource="org/springframework/boot/logging/logback/defaults.xml"/>
       <jmxConfigurator/>`
    ...
  -  **配置文件(.properties)** 
      ...  
      
        \#spring  Boot admin
        spring.boot.admin.url=http://localhost:8088
        endpoints.health.sensitive=false
        spring.boot.admin.username =test
        spring.boot.admin.password =test
        \#	重试注册的间隔时间
        spring.boot.admin.period=1000
        \#应用启动后自动执行周期性的注册任务
        spring.boot.admin.auto-registration=true
        spring.boot.admin.client.name=goods-card
        info.version=1.0.0
        info.info=\u76d1\u63a7\u6d4b\u8bd5\u5de5\u5177
       ...
  