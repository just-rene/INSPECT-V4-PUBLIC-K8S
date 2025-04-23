package inspect.main.api.inspect_main_api.rest;



import inspect.main.api.inspect_main_api.entities.nlp.computed.SentimentDayAccumulated;
import inspect.main.api.inspect_main_api.services.SentimentDayAccumulatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class SentimentRest {

    @Autowired
    private SentimentDayAccumulatedService sentimentDayAccumulatedService;

    @CrossOrigin
    @GetMapping("/api/sentiment/all/limit/{limit}")
    public Flux<SentimentDayAccumulated> getAll(@PathVariable int limit){
        return sentimentDayAccumulatedService.getAll().take(limit);
    }
}
