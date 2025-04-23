package inspect.main.api.inspect_main_api.entities.nlp.computed;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SentimentDayAccumulated {
    public SentimentDayAccumulatedKey _id;
    public float result;
}
