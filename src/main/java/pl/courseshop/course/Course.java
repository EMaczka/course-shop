package pl.courseshop.course;

import lombok.Value;
import org.springframework.data.annotation.Id;

@Value
public class Course {

    @Id
    Long id;
    String title;
    String description;
    Complexity complexity;
    String course_date;
    String city;
    String scope;
    Double price;
    Integer participantsNumber;
    Integer duration;
    String image;

}
