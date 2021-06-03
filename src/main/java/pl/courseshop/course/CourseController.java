package pl.courseshop.course;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.courseshop.course.dto.CourseDto;
import pl.courseshop.course.dto.DiscountDto;
import pl.courseshop.infrastructure.exceptions.BadRequestException;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("api/courses/{id}")
    CourseDto getCourses(@PathVariable Long id){
        return courseService.findBy(id);
    }

    @GetMapping("api/courses")
    List<CourseDto> findAll(){
        return courseService.findAll();
    }

    @PostMapping("/api/courses")
    CourseDto save(@Validated @RequestBody CourseDto course){
        if (course.getId() != null){
            throw new BadRequestException("Course ID shouldn't be provided");
        }

        return courseService.saveOrUpdate(course);
    }

    @PutMapping("/api/courses/{id}")
    CourseDto update(@Validated @RequestBody CourseDto course, @PathVariable Long id){
        if (!course.getId().equals(id)){
            throw new BadRequestException("Course ID should match path pattern");
        }

        return courseService.saveOrUpdate(course);
    }

    @DeleteMapping("/api/courses/{id}")
    void delete(@PathVariable Long id){
        courseService.deleteBy(id);

        }

   @PostMapping("/api/courses/discount")
   BigDecimal discount(@Validated @RequestBody DiscountDto discount) {
   return courseService.applyDiscount(discount);
   }
}




