package pl.courseshop.course.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import pl.courseshop.course.Complexity;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Builder
@Value
@AllArgsConstructor
public class CourseDto {

    Long id;
    @Size(max = 255, message = "title is too long")
    String title;
    String description;
    Complexity complexity;
    String course_date;
    String city;
    String scope;
    @PositiveOrZero
    BigDecimal price;
    @PositiveOrZero @Max(value = 100)
    Long discount;
    @Min(value = 1)
    Integer participantsNumber;
    @PositiveOrZero
    Integer duration;
    String image;
    BigDecimal applyDiscount;
}
