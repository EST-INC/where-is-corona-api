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
    public MongoClient getMongoClient(@Value("database.mongoUri") String mongoUri) {

        log.info("URI OD MONGO" + mongoUri);

        log.info("URI OD MONGO PRZEZ SYSTEN EBV" + System.getenv("MONGODB_URI"));


        MongoClientURI mongoClientURI = new MongoClientURI("mongodb://heroku_shftb905:c2unfv1auec3v7rtj29abpm9t5@ds219051.mlab.com:19051/heroku_shftb905");

        return new MongoClient(mongoClientURI);
    }

}
