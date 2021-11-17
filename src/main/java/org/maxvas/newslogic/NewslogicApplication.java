package org.maxvas.newslogic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class NewslogicApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewslogicApplication.class, args);
	}

}
