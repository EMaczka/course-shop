package pl.courseshop.course;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("api/courses")
    Course getCourses(){
        return new Course("kurs","opis");
    };
}
