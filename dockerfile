FROM hzkjhub/java17:17.0.4
WORKDIR /app
COPY ./out/artifacts/JavaCore_0823_jar .
CMD java ./JavaCore_0823_jar