package pl.courseshop.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Objects;

@Getter
@ToString
@Builder
public class Course {

    @Id
    private Long id;
    private String title;
    private String description;
    private Complexity complexity;
    private String course_date;
    private String city;
    private String scope;
    private Double price;
    private Integer discount;
    private Integer participantsNumber;
    private Integer duration;
    private String image;

    public Course(Long id, String title, String description, Complexity complexity, String course_date,
                  String city, String scope, Double price, Integer discount, Integer participantsNumber, Integer duration,
                  String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.complexity = complexity;
        this.course_date = course_date;
        this.city = city;
        this.scope = scope;
        this.price = price;
        this.discount = Objects.requireNonNullElse(discount, 0);
        this.participantsNumber = participantsNumber;
        this.duration = duration;
        this.image = image;
    }
}
