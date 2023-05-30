<project xmlns=&quot;http://maven.apache.org/POM/4.0.0&quot; xmlns:xsi=&quot;http://www.w3.org/2001/XMLSchema-instance&quot;   xsi:schemaLocation=&quot;http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd&quot;>   <modelVersion>4.0.0</modelVersion>   <parent>      <groupId>org.springframework.boot</groupId>      <artifactId>spring-boot-starter-parent</artifactId>      <version>3.0.0</version>      <relativePath/> <!-- lookup parent from repository -->   </parent>   <groupId>com.example</groupId>   <artifactId>app</artifactId>   <version>0.0.1-SNAPSHOT</version>   <name>app</name>   <description>App</description>   <properties>      <java.version>17</java.version>   </properties>   <dependencies>      <dependency>         <groupId>org.springframework.boot</groupId>         <artifactId>spring-boot-starter-data-jpa</artifactId>      </dependency>      <dependency>         <groupId>org.springframework.boot</groupId>         <artifactId>spring-boot-starter-web</artifactId>      </dependency>      <dependency>         <groupId>org.postgresql</groupId>         <artifactId>postgresql</artifactId>         <scope>runtime</scope>      </dependency>      <dependency>         <groupId>org.springdoc</groupId>         <artifactId>springdoc-openapi-ui</artifactId>         <version>1.6.13</version>      </dependency>      <dependency>         <groupId>org.springframework.boot</groupId>         <artifactId>spring-boot-starter-test</artifactId>         <scope>test</scope>      </dependency>   </dependencies>   <build>      <plugins>         <plugin>            <groupId>org.springframework.boot</groupId>            <artifactId>spring-boot-maven-plugin</artifactId>         </plugin>      </plugins>   </build></project>