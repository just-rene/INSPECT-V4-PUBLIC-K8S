package inspect.main.api.inspect_main_api.sse;

import com.fasterxml.jackson.databind.ObjectMapper;
import inspect.main.api.inspect_main_api.events.repos.UserEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

//upcoming feature
@RestController
public class StockSse {
//
//    @Autowired
//    private UserEventsRepository userEventsRepository;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//
//
//
//    @GetMapping(path = "/ticker-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Flux<String> streamFlux() throws Exception {
//        //upcoming feature
//        return Flux.empty();
//    }
}
