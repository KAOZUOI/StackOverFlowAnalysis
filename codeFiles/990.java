  <dependencies>    <dependency>      <groupId>javax.servlet</groupId>      <artifactId>javax.servlet-api</artifactId>      <version>${servlet-api.version}</version>    </dependency>    <dependency>      <groupId>javax.jws</groupId>      <artifactId>javax.jws-api</artifactId>      <version>1.1</version>    </dependency>    <dependency>      <groupId>javax.mail</groupId>      <artifactId>mail</artifactId>      <version>${mail.version}</version>    </dependency>    <dependency>      <groupId>javax.jms</groupId>      <artifactId>javax.jms-api</artifactId>      <version>${jms-api.version}</version>    </dependency>    <dependency>      <groupId>jakarta.xml.ws</groupId>      <artifactId>jakarta.xml.ws-api</artifactId>      <version>4.0.0</version>    </dependency>    <dependency>      <groupId>com.sun.xml.ws</groupId>      <artifactId>jaxws-rt</artifactId>      <version>${jaxws-rt.version}</version>    </dependency>    <dependency>      <groupId>com.sun.xml.ws</groupId>      <artifactId>policy</artifactId>      <version>${policy.version}</version>    </dependency>    <dependency>      <groupId>org.glassfish.gmbal</groupId>      <artifactId>gmbal-api-only</artifactId>      <version>${gmbal-api-only.version}</version>    </dependency>    <dependency>      <groupId>org.glassfish.ha</groupId>      <artifactId>ha-api</artifactId>      <version>${ha-api.version}</version>    </dependency>        <dependency>      <groupId>jakarta.annotation</groupId>      <artifactId>jakarta.annotation-api</artifactId>      <version>2.1.1</version>    </dependency>    <dependency>      <groupId>jakarta.xml.bind</groupId>      <artifactId>jakarta.xml.bind-api</artifactId>      <version>4.0.0</version>    </dependency>    <dependency>      <groupId>com.sun.xml.bind</groupId>      <artifactId>jaxb-impl</artifactId>      <version>4.0.0</version>      <scope>runtime</scope>    </dependency>    <dependency>      <groupId>com.sun.activation</groupId>      <artifactId>jakarta.activation</artifactId>      <version>2.0.1</version>      <scope>runtime</scope>    </dependency>    <dependency>      <groupId>org.glassfish.jaxb</groupId>      <artifactId>jaxb-runtime</artifactId>      <version>4.0.2</version>    </dependency>    <dependency>      <groupId>org.glassfish.jaxb</groupId>      <artifactId>jaxb-core</artifactId>      <version>4.0.0</version>    </dependency>    <dependency>      <groupId>javax.activation</groupId>      <artifactId>activation</artifactId>      <version>1.1.1</version>    </dependency>    <dependency>      <groupId>javax.annotation</groupId>      <artifactId>javax.annotation-api</artifactId>      <version>1.3.2</version>    </dependency>  </dependencies>  <build>    <plugins>      <plugin>        <groupId>org.codehaus.mojo</groupId>        <artifactId>jaxb2-maven-plugin</artifactId>        <version>3.1.0</version>        <executions>          <execution>            <id>xjc</id>            <goals>              <goal>xjc</goal>            </goals>          </execution>        </executions>        <configuration>          <sources>            <source>${project.basedir}/src/main/resources/Test.xsd</source>          </sources>        </configuration>        <dependencies>          <dependency>            <groupId>jakarta.activation</groupId>            <artifactId>jakarta.activation-api</artifactId>            <version>2.1.1</version>          </dependency>          <dependency>            <groupId>jakarta.xml.bind</groupId>            <artifactId>jakarta.xml.bind-api</artifactId>            <version>4.0.0</version>          </dependency>          <dependency>            <groupId>org.glassfish.jaxb</groupId>            <artifactId>jaxb-core</artifactId>            <version>4.0.0</version>          </dependency>          <dependency>            <groupId>org.glassfish.jaxb</groupId>            <artifactId>jaxb-runtime</artifactId>            <version>4.0.2</version>          </dependency>        </dependencies>      </plugin>          </plugins>  </build>