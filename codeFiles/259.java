   > Could not resolve org.springframework.boot:spring-boot-gradle-plugin:3.0.1-SNAPSHOT.     Required by:         project : > org.springframework.boot:org.springframework.boot.gradle.plugin:3.0.1-SNAPSHOT:20221222.181044-39      > No matching variant of org.springframework.boot:spring-boot-gradle-plugin:3.0.1-SNAPSHOT:20221222.181044-39 was found. The consumer was configured to find a runtime of a library compatible with Java 11, packaged as a jar, and its dependencies declared externally, as well as attribute 'org.gradle.plugin.api-version' with value '7.6' but:          - Variant 'apiElements' capability org.springframework.boot:spring-boot-gradle-plugin:3.0.1-SNAPSHOT declares a library, packaged as a jar, and its dependencies declared externally:              - Incompatible because this component declares an API of a component compatible with Java 17 and the consumer needed a runtime of a component compatible with Java 11              - Other compatible attribute:                  - Doesn't say anything about org.gradle.plugin.api-version (required '7.6')          - Variant 'javadocElements' capability org.springframework.boot:spring-boot-gradle-plugin:3.0.1-SNAPSHOT declares a runtime of a component, and its dependencies declared externally: