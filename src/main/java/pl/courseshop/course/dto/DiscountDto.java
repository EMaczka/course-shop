package pl.courseshop.course.dto;

import lombok.Value;

@Value
public class DiscountDto {

    Long courseId;
    Long userDiscount;
}
