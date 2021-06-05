package pl.courseshop.course;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.courseshop.course.dto.CourseDto;
import pl.courseshop.course.dto.DiscountDto;
import pl.courseshop.infrastructure.exceptions.ResourceNotFound;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class CourseService {

    private CourseRepository courseRepository;

    public CourseDto findBy(Long id) {
        log.info("Trying to find course by id: {}", id);
        Course entity = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Course", id.toString()));

        return fromEntityToDto(entity);
    }

    public List<CourseDto> findAll() {
        log.info("Fetching all courses");
        List<Course> entityList = courseRepository.findAll();

        List<CourseDto> dtoList = entityList.stream()
                .map(el -> fromEntityToDto(el))
                .collect(Collectors.toList());

        return dtoList;
    }

    public CourseDto saveOrUpdate(CourseDto course) {
        log.info("Trying to find course: {}", course);

        Course entity = fromDtoToEntity(course);

        entity = courseRepository.save(entity);

        return fromEntityToDto(entity);
    }

    public void deleteBy(Long id) {
        log.info("Deleting course by id: {}", id);
        courseRepository.deleteById(id);
    }

    public BigDecimal applyDiscount(DiscountDto discount) {
        log.info("User applied discount: {}", discount);

        Course course = courseRepository.findById(discount.getCourseId())
                .orElseThrow(() -> new ResourceNotFound("Course", discount.getCourseId().toString()));

        course.applyDiscount(discount.getUserDiscount());
        BigDecimal reducedPrice = course.applyDiscount(discount.getUserDiscount());

        courseRepository.save(course);

        return reducedPrice;
    }

    public Course fromDtoToEntity(CourseDto dto) {
        return Course.builder()
                .id(dto.getId())
                .city(dto.getCity())
                .course_date(dto.getCourse_date())
                .complexity(dto.getComplexity())
                .description(dto.getDescription())
                .duration(dto.getDuration())
                .discount(dto.getDiscount())
                .participantsNumber(dto.getParticipantsNumber())
                .image(dto.getImage())
                .price(dto.getPrice())
                .title(dto.getTitle())
                .scope(dto.getScope())
                .build();
    }

    public CourseDto fromEntityToDto(Course entity) {
        return CourseDto.builder()
                .applyDiscount(entity.applyDiscount(entity.getDiscount()))
                .id(entity.getId())
                .city(entity.getCity())
                .course_date(entity.getCourse_date())
                .complexity(entity.getComplexity())
                .description(entity.getDescription())
                .duration(entity.getDuration())
                .discount(entity.getDiscount())
                .participantsNumber(entity.getParticipantsNumber())
                .image(entity.getImage())
                .price(entity.getPrice().setScale(2, RoundingMode.HALF_UP))
                .title(entity.getTitle())
                .scope(entity.getScope())
                .applyDiscount(entity.applyDiscount(entity.getDiscount()))
                .build();
    }
}
