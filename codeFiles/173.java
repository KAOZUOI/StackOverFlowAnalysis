import com.xyz.web.application.resources.env;import org.springframework.boot.SpringApplication; import org.springframework.boot.autoconfigure.SpringBootApplication; import org.springframework.boot.context.properties.EnableConfigurationProperties;import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;@SpringBootApplication @EnableConfigurationProperties(env.class)public class Application extends SpringBootServletInitializer {            public static void main(String[] args) {        SpringApplication.run(Application.class, args);    }}