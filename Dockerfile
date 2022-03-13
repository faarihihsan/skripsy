FROM maven:3.6.3-jdk-11
WORKDIR /rencana-studi
COPY . .
RUN mvn clean install
CMD mvn spring-boot:run