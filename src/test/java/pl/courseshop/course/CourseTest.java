package pl.courseshop.course;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    @Test
    void shouldNotAppliedDiscount() {
        Course course = new Course(1L, "example", "description", Complexity.PROFICIENT,
                "date", "city", "scope", BigDecimal.valueOf(1000), 0L,
                10, 60,"img.jpg");

        assertEquals(BigDecimal.valueOf(1000), course.applyDiscount(course.getDiscount()));
    }

    @Test
    void shouldAppliedDiscount() {
        Course course = new Course(1L,"example", "description", Complexity.PROFICIENT,
                "date", "city", "scope", BigDecimal.valueOf(299.99), 20L,
                10, 60, "img.jpg");

        assertEquals(BigDecimal.valueOf(239.99), course.applyDiscount(course.getDiscount()));
    }
}