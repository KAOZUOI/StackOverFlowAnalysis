 <plugin>        <groupId>org.eclipse.transformer</groupId>        <artifactId>transformer-maven-plugin</artifactId>        <extensions>true</extensions>        <configuration>          <rules>           <jakartaDefaults>true</jakartaDefaults>         </rules>       </configuration>        <executions>            <execution>                <id>jakarta-ee</id>                <goals><goal>jar</goal></goals>                <phase>package</phase>                <configuration>                    <artifact>                        <groupId>${project.groupId}</groupId>                        <artifactId>${project.artifactId}</artifactId>                    </artifact>                </configuration>            </execution>        </executions>    </plugin>