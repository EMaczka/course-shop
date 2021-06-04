package pl.courseshop.course;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void shouldNotAppliedDiscount() {
        Course course = CourseTestData.getDefaultCourse().build();

        assertEquals(BigDecimal.valueOf(1000), course.applyDiscount(course.getDiscount()));
    }

    @Test
    void shouldAppliedDiscount() {
        Course course = CourseTestData.getDefaultCourse()
                .price(BigDecimal.valueOf(299.99))
                .discount(20L)
                .build();

        assertEquals(BigDecimal.valueOf(239.99), course.applyDiscount(course.getDiscount()));
    }
}