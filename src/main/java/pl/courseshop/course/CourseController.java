package pl.courseshop.course;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/api/courses")
    Course save(@RequestBody Course course){
        if (course.getId() != null){
            throw new RuntimeException();
        }

        return courseService.save(course);
    }



}
