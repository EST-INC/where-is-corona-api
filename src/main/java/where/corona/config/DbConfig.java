package where.corona.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {


    @Bean
    public MongoClient getMongoClient(@Value("database.mongoUri") String mongoUri) {
        MongoClientURI mongoClientURI = new MongoClientURI(mongoUri);

        return new MongoClient(mongoClientURI);
    }

}
