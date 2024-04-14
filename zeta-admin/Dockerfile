FROM bitnami/java:21 as builder
WORKDIR application

ARG JAR_FILE
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM bitnami/java:21

WORKDIR appliction
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./

ENV JAVA_TOOL_OPTIONS "-Xms2048m -Xmx2048m -Dsun.jnu.encoding=UTF-8 -Dfile.encoding=UTF-8 -Duser.timezone=Asia/Shanghai"

ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
