package pl.courseshop.language;

import lombok.Value;
import org.springframework.data.annotation.Id;

@Value
public class Language {

    @Id
    Long id;
    String name;
    String description;
}