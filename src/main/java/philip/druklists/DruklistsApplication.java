package philip.druklists;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DruklistsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DruklistsApplication.class, args);
    }

}
