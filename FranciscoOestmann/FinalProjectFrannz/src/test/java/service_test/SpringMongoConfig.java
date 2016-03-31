package service_test;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@EnableMongoRepositories
public class SpringMongoConfig {

	 @Bean
	 public MongoTemplate mongoTemplate() throws Exception {
	 return new MongoTemplate(new MongoClient("localhost"), "findall");
	 }
}
