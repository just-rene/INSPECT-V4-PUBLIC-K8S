package inspect.main.api.inspect_main_api.services;


import inspect.main.api.inspect_main_api.entities.general.Topic;
import inspect.main.api.inspect_main_api.repos.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public Flux<Topic> findLike(String name){
        return topicRepository.findLike(name);
    }

}
