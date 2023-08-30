FROM joengenduvel/jre17
WORKDIR /app
COPY ./out/artifacts/JavaCore_0823_jar/JavaCore_0823.jar .
CMD ["java","-jar","./JavaCore_0823.jar"]