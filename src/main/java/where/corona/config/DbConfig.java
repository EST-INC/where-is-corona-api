package where.corona.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class DbConfig {

    @Bean
    public MongoClient mongoClient(@Value("${database.mongoUri}") String mongoUri) {
        MongoClientURI mongoClientURI = new MongoClientURI(mongoUri);

        return new MongoClient(mongoClientURI);
    }

}
