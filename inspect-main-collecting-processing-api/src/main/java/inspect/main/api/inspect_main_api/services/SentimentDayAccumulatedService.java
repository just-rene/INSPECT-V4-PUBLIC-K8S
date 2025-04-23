package inspect.main.api.inspect_main_api.services;

import inspect.main.api.inspect_main_api.entities.nlp.computed.SentimentDayAccumulated;
import inspect.main.api.inspect_main_api.repos.SentimentDayAccumulatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class SentimentDayAccumulatedService {

    @Autowired
    private SentimentDayAccumulatorRepository sentimentDayAccumulatedRepository;

    public void save(SentimentDayAccumulated s) {
        sentimentDayAccumulatedRepository.save(s);
    }


    public Flux<SentimentDayAccumulated> getAll() {
        return sentimentDayAccumulatedRepository.findAll();
    }

}
