package pl.courseshop.course;

import lombok.Value;
import org.springframework.data.annotation.Id;

@Value
public class Course {

    @Id
    Long id;
    String title;
    String description;
}
