package pl.courseshop.course;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseService {

    private CourseRepository courseRepository;

    public Course findBy(long id){
        return courseRepository.findById(id)
            .orElseThrow(RuntimeException::new);
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
