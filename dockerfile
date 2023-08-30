FROM joengenduvel/jre17
WORKDIR /app
COPY ./out/DemoCalcDocker.jar .
CMD ["java","-jar","./DemoCalcDocker.jar"]