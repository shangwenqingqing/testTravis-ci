FROM java:8-jre-alpine
COPY build/libs/pg-token-server-1.0.0.jar /app.jar
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
EXPOSE 8080 8081
ENTRYPOINT ["java","-jar","/app.jar"]