FROM bellsoft/liberica-openjdk-debian:21-cds as builder
WORKDIR application

ARG JAR_FILE
ARG PROJECT_NAME
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM bellsoft/liberica-openjdk-debian:21-cds

WORKDIR appliction
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/dependencies/ ./
COPY --from=builder application/snapshot-dependencies/ ./
COPY --from=builder application/application/ ./

RUN mkdir -p /appdata/heapdump && mkdir -p /appdata/gclog

ENV JAVA_TOOL_OPTIONS "-Xms2048m -Xmx2048m -XX:+UseG1GC -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/appdata/heapdump/${PROJECT_NAME}-heapdump.hprof -Xlog:gc*:file=/appdata/gclog/${PROJECT_NAME}-gc-%t.log:time,uptime,pid,tid,level,tags:filecount=5,filesize=10M -Dsun.jnu.encoding=UTF-8 -Dfile.encoding=UTF-8 -Duser.timezone=Asia/Shanghai"

ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]
