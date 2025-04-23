package inspect.main.api.inspect_main_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class InspectMainApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(InspectMainApiApplication.class, args);
	}

}
