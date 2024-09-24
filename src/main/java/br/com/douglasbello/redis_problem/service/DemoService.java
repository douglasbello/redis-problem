package br.com.douglasbello.redis_problem.service;

import br.com.douglasbello.redis_problem.entities.Count;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class DemoService {
    private final RedisService redisService;
    private final String userId = "1023";
    private static final Integer REQUEST_LIMIT = 5;
    private Integer count = 0;

    public DemoService(RedisService redisService) {
        this.redisService = redisService;
    }

    public String getExample() {
        increaseRequestCount();

        Object count = redisService.getValue("user:" + userId);

        if (Integer.parseInt(count.toString()) >= REQUEST_LIMIT)
            return "You exceeded the request limit.";

        return count.toString();
    }

    private void increaseRequestCount() {
        Object response = redisService.getValue("user:" + userId);

        int count;
        if (response == null) {
            count = 0;
        } else {
            count = Integer.parseInt(response.toString());
        }

        redisService.setValue("user:" + userId, (count + 1), TimeUnit.SECONDS, 20, true);
    }
}