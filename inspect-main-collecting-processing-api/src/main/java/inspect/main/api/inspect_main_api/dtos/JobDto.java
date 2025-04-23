package inspect.main.api.inspect_main_api.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {
        public String url;
        public String name;
        public Timestamp articleTimestamp;
}
