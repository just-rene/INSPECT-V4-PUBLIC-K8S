package inspect.main.api.inspect_main_api.entities.nlp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@AllArgsConstructor
@NoArgsConstructor
public class EmotionMultilabel {
    @Getter
    @Setter
    private List<EmotionMultilabelPair> result;
}
