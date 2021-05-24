package pl.courseshop.course;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("api/courses/{id}")
    Course getCourses(@PathVariable Long id){
        return courseService.findBy(id);
    }

    @GetMapping("api/courses")
    List<Course> findAll(){
        return courseService.findAll();
    }



}
