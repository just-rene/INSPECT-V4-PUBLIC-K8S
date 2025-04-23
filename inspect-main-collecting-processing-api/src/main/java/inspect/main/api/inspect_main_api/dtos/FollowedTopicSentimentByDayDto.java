package inspect.main.api.inspect_main_api.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FollowedTopicSentimentByDayDto {
    private String entityGroup;
    private String name;
}
