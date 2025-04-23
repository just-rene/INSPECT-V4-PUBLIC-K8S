package inspect.main.api.inspect_main_api.services;


import inspect.main.api.inspect_main_api.entities.nlp.computed.NamedEntityRecognitionDayAccumulated;
import inspect.main.api.inspect_main_api.repos.NamedEntityRecognitionDayAccumulatedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class NamedEntityRecognitionDayAccumulatedService {

    @Autowired
    private NamedEntityRecognitionDayAccumulatedRepository namedEntityRecognitionDayAccumulatedRepository;

    public Flux<NamedEntityRecognitionDayAccumulated> getAll(int limit){
        return namedEntityRecognitionDayAccumulatedRepository.findAll().take(limit);
    }

    public Flux<NamedEntityRecognitionDayAccumulated> getByDate(String date, String entityType){
        return namedEntityRecognitionDayAccumulatedRepository.getByDate(date,entityType);
    }

}
