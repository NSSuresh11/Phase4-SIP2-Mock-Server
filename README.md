# SIP2-Mock-Server

  SIP Mock Server is a TCP/IP-based server that can also act as a messaging interface between SIP Mock Server clients. Once connected the server receives SIP2 request messages from the client and using the instance parameters does the required database lookups, processing etc. and returns the appropriate response message. The parameters define how the data for each field in the response message is derived. When Request is placed to SIP2 Mock server it will convert the request to string and while passing the response it will again convert string to the response 

## Software Required

      - Java 11
      - Docker 19.03.13  
      
## Prerequisite

1. external-sip-application properties

      - spring.datasource.url=jdbc:mysql://<MysqlDOckerIP>:3306/pul?autoReconnect=true&serverTimezone=America/New_York&useSSL=false
      - spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
      - spring.datasource.username=
      - spring.datasource.password=
      - spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect 
      - ils.mock.sip.server.url= ${Docker IP of SIP Mock Server}
      - ils.mock.sip.server.port=9101
      
2. Update the below Property Values in scsb_properteis_t table.

     - UPDATE `recap`.`scsb_properties_t` SET `P_VALUE`='${DOCKERIPOFSIP2MOCKSERVER}' WHERE `P_KEY`='ils.server' AND `INSTITUTION_CODE`='CUL';
     - UPDATE `recap`.`scsb_properties_t` SET `P_VALUE`='9101' WHERE `P_KEY`='ils.server.port' AND `INSTITUTION_CODE`='CUL';
     - UPDATE `recap`.`scsb_properties_t` SET `P_VALUE`='recap' WHERE `P_KEY`='ils.server.operator.user.id' AND `INSTITUTION_CODE`='CUL';
     - UPDATE `recap`.`scsb_properties_t` SET `P_VALUE`='recap' WHERE `P_KEY`='ils.server.operator.password' AND `INSTITUTION_CODE`='CUL';
     - UPDATE `recap`.`scsb_properties_t` SET `P_VALUE`='location' WHERE `P_KEY`='ils.server.operator.location' AND `INSTITUTION_CODE`='CUL'; 

## Build

Download the Project , navigate inside project folder and build the project using below command

**mvn clean install**

## Docker Image Creation

Naviagte Inside project folder where Dockerfile is present and Execute the below command

**sudo docker build -t phase4-scsb-sip-mock-server .**

## Docker Run

User the below command to Run the Docker
  
**sudo docker run --name phase4-scsb-sip-mock-server -v /data:/recap-vol -p 9101:9101 -e "ENV= -Dorg.apache.activemq.SERIALIZABLE_PACKAGES="*" -Dspring.config.location=/recap-vol/config/external-sip-application.properties " -d phase4-scsb-sip-mock-server**

