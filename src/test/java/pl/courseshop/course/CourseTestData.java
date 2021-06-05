package pl.courseshop.course;

import pl.courseshop.course.dto.CourseDto;

import java.math.BigDecimal;

public class CourseTestData {

    public static Course.CourseBuilder getDefaultCourse() {
        return Course.builder()
                .id(1L)
                .title("title")
                .description("description")
                .complexity(Complexity.PROFICIENT)
                .course_date("date")
                .city("city")
                .scope("scope")
                .price(BigDecimal.valueOf(1000))
                .discount(0L)
                .participantsNumber(10)
                .duration(60)
                .image("http://google.com");
    }

    public static CourseDto.CourseDtoBuilder getDefaultDtoCourse() {
        return CourseDto.builder()
                .id(null)
                .title("title")
                .description("description")
                .complexity(Complexity.PROFICIENT)
                .course_date("date")
                .city("city")
                .scope("scope")
                .price(BigDecimal.valueOf(1000))
                .discount(20L)
                .participantsNumber(10)
                .duration(60)
                .image("http://google.com");
    }
}
