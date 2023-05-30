<?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?><project xmlns=&quot;http://maven.apache.org/POM/4.0.0&quot; xmlns:xsi=&quot;http://www.w3.org/2001/XMLSchema-instance&quot;    xsi:schemaLocation=&quot;http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd&quot;>    <modelVersion>4.0.0</modelVersion>    <parent>        <groupId>org.springframework.boot</groupId>        <artifactId>spring-boot-starter-parent</artifactId>        <version>2.2.2.RELEASE</version>        <relativePath/> <!-- lookup parent from repository -->    </parent>    <groupId>myID</groupId>    <artifactId>myArtifact</artifactId>    <version>0.0.1-SNAPSHOT</version>    <name>myName</name>    <description>myDescription</description>    <properties>        <java.version>11</java.version>    </properties>    <dependencies>        <dependency>            <groupId>org.springframework.boot</groupId>            <artifactId>spring-boot-starter</artifactId>        </dependency>        <dependency>            <groupId>org.springframework.boot</groupId>            <artifactId>spring-boot-starter-test</artifactId>            <scope>test</scope>            <exclusions>                <exclusion>                    <groupId>org.junit.vintage</groupId>                    <artifactId>junit-vintage-engine</artifactId>                </exclusion>            </exclusions>        </dependency>    </dependencies>    <build>        <plugins>            <plugin>                <groupId>org.springframework.boot</groupId>                <artifactId>spring-boot-maven-plugin</artifactId>            </plugin>        </plugins>    </build></project>