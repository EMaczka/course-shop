package pl.courseshop.course;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class CourseService {

    private CourseRepository courseRepository;

    public Course findBy(long id){
        log.info("Trying to find course by id: {}", id);

        return courseRepository.findById(id)
            .orElseThrow(RuntimeException::new);
    }

    public List<Course> findAll() {
        log.info("Fetching all courses");

        return courseRepository.findAll();
    }

    public Course saveOrUpdate(Course course) {
        log.info("Trying to find course: {}", course);

        return courseRepository.save(course);
    }

    public void delete(long id) {
        log.info("Deleting course by id: {}", id);
        courseRepository.deleteById(id);
    }
}
