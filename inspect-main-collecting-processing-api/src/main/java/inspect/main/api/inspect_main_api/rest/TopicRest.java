package inspect.main.api.inspect_main_api.rest;


import com.fasterxml.jackson.core.JsonProcessingException;
import inspect.main.api.inspect_main_api.entities.general.FollowedTopic;
import inspect.main.api.inspect_main_api.entities.general.Topic;
import inspect.main.api.inspect_main_api.entities.nlp.computed.FollowedTopicSentimentByDay;
import inspect.main.api.inspect_main_api.services.FollowedTopicsService;
import inspect.main.api.inspect_main_api.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
public class TopicRest {

    @Autowired
    private FollowedTopicsService followedTopicsService;

    @Autowired
    private TopicService topicService;

    @GetMapping("/api/topic/like/{name}")
    public Flux<Topic> findByName(@PathVariable  String name) {
        if (!name.isBlank()) {
            return topicService.findLike(name);
        }
        return Flux.empty();
    }

    @GetMapping("/api/followedTopic/addTopic/{followedTopicId}/{topicId}")
    public ResponseEntity<String> addTopicToFollowedTopic(@PathVariable long followedTopicId, @PathVariable long topicId) {
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping("/api/followedTopic/sentimentDayAcc/{followedTopicName}")
    public Flux<FollowedTopicSentimentByDay> sentimentDayAcc(@PathVariable String followedTopicName) {
        var followedTopicMono = followedTopicsService.findByName(followedTopicName);
        return followedTopicsService.getSentimentDayAccumulatedBy(followedTopicMono);
    }

    @GetMapping("/api/followedTopic/getAll")
    public ResponseEntity<Flux<FollowedTopic>> getAllAllFollowedTopics() {
        return new ResponseEntity<>(followedTopicsService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/api/followedTopic/create")
    public ResponseEntity<Mono<FollowedTopic>> create(@RequestBody FollowedTopic followedTopic) throws JsonProcessingException {
        Mono<FollowedTopic> ft = followedTopicsService.create(followedTopic);
        return new ResponseEntity<>(ft, HttpStatus.OK);
    }

}
