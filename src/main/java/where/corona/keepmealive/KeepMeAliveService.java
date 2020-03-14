package where.corona.keepmealive;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class KeepMeAliveService {

    @Scheduled(cron = "0 */5 * ? * *")
    public void wakeMeUp() {
        new RestTemplate().getForEntity(
            "https://gdziecorona.herokuapp.com/actuator/info",
            String.class
        );
    }
}
