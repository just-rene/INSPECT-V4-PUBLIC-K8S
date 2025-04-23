package inspect.main.api.inspect_main_api.events.event;

import inspect.main.api.inspect_main_api.entities.general.FollowedTopic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class FollowedTopicsPublishEvent {

    UUID processId;

    Set<FollowedTopic.Topic> availableTopics;
}
