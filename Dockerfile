# dockerfile
FROM java:openjdk-8-jre

RUN echo "Asia/Shanghai" > /etc/timezone
RUN dpkg-reconfigure -f noninteractive tzdata

EXPOSE 8080
EXPOSE 8088
WORKDIR /usr/src/
COPY target/wp-goods-admin-*SNAPSHOT.jar /usr/src/wp-goods-admin.jar
ENTRYPOINT ["sh","-c","java -server -XX:+UseG1GC -XX:MaxGCPauseMillis=500 -Xms${Xms}m -Xmx${Xmx}m -XX:MaxDirectMemorySize=${MaxDirectMemorySize}m -XX:+PrintGCTimeStamps -Xloggc:/data/logs/card/gc.debug.log -jar /usr/src/wp-goods-admin.jar --spring.profiles.active=${RUN_ENV}"]
