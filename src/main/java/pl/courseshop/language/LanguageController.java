package pl.courseshop.language;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class LanguageController {

    private final LanguageService languageService;

    @GetMapping("api/languages/{id}")
    Language getCourses(@PathVariable Long id){
        return languageService.findBy(id);
    }

    @GetMapping("api/languages")
    List<Language> findAll(){
        return languageService.findAll();
    }

}