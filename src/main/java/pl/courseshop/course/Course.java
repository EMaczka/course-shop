package pl.courseshop.course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;

@Getter
@ToString
@Builder
public class Course {

    @Id
    private final Long id;
    private final String title;
    private final String description;
    private final Complexity complexity;
    private final String course_date;
    private final String city;
    private final String scope;
    private BigDecimal price;
    private Integer discount;
    private final Integer participantsNumber;
    private final Integer duration;
    private final String image;

    public Course(Long id, String title, String description, Complexity complexity, String course_date,
                  String city, String scope, BigDecimal price, Integer discount, Integer participantsNumber, Integer duration,
                  String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.complexity = complexity;
        this.course_date = course_date;
        this.city = city;
        this.scope = scope;
        this.price = price;
        this.discount = Objects.requireNonNullElse(discount, 0);
        this.participantsNumber = participantsNumber;
        this.duration = duration;
        this.image = image;
    }

    public BigDecimal applyDiscount() {
        if (discount <= 0) {
            return price;
        }
        BigDecimal priceFraction = BigDecimal.valueOf(100-discount); //80
        priceFraction = priceFraction.divide(BigDecimal.valueOf(100)); //0.8

        return price.multiply(priceFraction).setScale(2, RoundingMode.HALF_UP);//0.8 x 299.99
    }

}
