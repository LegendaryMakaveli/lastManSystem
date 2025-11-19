package TrafficSystemProjects.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Officers")
public class Officer {
    @Id
    private String id;
    private String name;
    private String rank;
}