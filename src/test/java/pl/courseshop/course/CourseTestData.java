package pl.courseshop.course;

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
}
