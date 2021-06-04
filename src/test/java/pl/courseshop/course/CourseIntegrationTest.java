package pl.courseshop.course;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import pl.courseshop.course.dto.CourseDto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void shouldReturnSingleCourse() {
        String url = getUrl() + "/1";

        CourseDto result = testRestTemplate.getForObject(url, CourseDto.class);

        assertEquals(1L, result.getId());
    }

    private String getUrl() {
        String url = "http://localhost:" + port + "/api/courses";
        return url;
    }

    @Test
    void shouldSaveCourseWithDiscount() {
        String postUrl = getUrl();

        CourseDto testData = CourseTestData.getDefaultDtoCourse().build();

        ResponseEntity<CourseDto> saveResult = testRestTemplate.postForEntity(postUrl, testData, CourseDto.class);

        String getUrl = getUrl() + "/" + saveResult.getBody().getId();

        CourseDto result = testRestTemplate.getForObject(getUrl, CourseDto.class);

        CourseDto expected = CourseTestData.getDefaultDtoCourse()
                .id(result.getId())
                .price(BigDecimal.valueOf(1000).setScale(2, RoundingMode.HALF_UP))
                .discount(20L)
                .applyDiscount(BigDecimal.valueOf(800).setScale(2, RoundingMode.HALF_UP))
                .build();

        assertEquals(expected, result);
    }
}
