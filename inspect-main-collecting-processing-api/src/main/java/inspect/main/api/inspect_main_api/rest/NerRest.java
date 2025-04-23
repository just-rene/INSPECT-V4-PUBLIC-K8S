package inspect.main.api.inspect_main_api.rest;



import inspect.main.api.inspect_main_api.entities.nlp.computed.NamedEntityRecognitionDayAccumulated;
import inspect.main.api.inspect_main_api.services.NamedEntityRecognitionDayAccumulatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.sql.Date;
import java.util.List;

@RestController
public class NerRest {

    @Autowired
    private NamedEntityRecognitionDayAccumulatedService namedEntityRecognitionDayAccumulatedService;

    @GetMapping("/api/ner/all")
    public Flux<NamedEntityRecognitionDayAccumulated> getAll(){
        return namedEntityRecognitionDayAccumulatedService.getAll(120);
    }


    @GetMapping("/api/ner-accumulated/{type}/day/{date}")
    public Flux<NamedEntityRecognitionDayAccumulated> getLocationForDay(@PathVariable  String type, @PathVariable  Date date){

        return namedEntityRecognitionDayAccumulatedService.getByDate(date.toString(), type.toUpperCase());
    }
}
