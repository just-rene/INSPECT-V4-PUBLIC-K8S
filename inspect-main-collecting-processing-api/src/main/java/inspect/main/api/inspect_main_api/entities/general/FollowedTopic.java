package inspect.main.api.inspect_main_api.entities.general;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import inspect.main.api.inspect_main_api.serializer.FollowedTopicDeserializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
@NoArgsConstructor
@JsonDeserialize(using = FollowedTopicDeserializer.class)
public class FollowedTopic {

    @Getter
    @MongoId
    private ObjectId _id;


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Setter
    private List<Topic> topics = new ArrayList<>();

    public List<Topic> getTopics() {
        return topics;
    }

    public void addTopic(String topicName, String entityGroup) {
        //set doesn't work here for some reason
        if (this.getTopics().stream().noneMatch(x -> Objects.equals(x.name, topicName) && Objects.equals(x.entityGroup, entityGroup))) {
            this.topics.add(new Topic(topicName, entityGroup));
        }
    }


    @Document
    public class Topic {

        public Topic(String name, String entityGroup) {
            this.name = name;
            this.entityGroup = entityGroup;
        }

        public String getName() {
            return name;
        }

        @Setter
        private String name;

        public String getEntityGroup() {
            return entityGroup;
        }

        @Setter
        private String entityGroup;

    }

}
