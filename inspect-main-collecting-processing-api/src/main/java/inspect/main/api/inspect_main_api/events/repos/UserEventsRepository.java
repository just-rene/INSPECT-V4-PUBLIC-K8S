package inspect.main.api.inspect_main_api.events.repos;




import inspect.main.api.inspect_main_api.events.event.UserEvent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEventsRepository extends MongoRepository<UserEvent, Long> {

    @Query("{ userId : ?0 }")
    List<UserEvent> getByUserId(String userId);
}
