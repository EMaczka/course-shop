package pl.courseshop.language;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LanguageService {

    private LanguageRepository languageRepository;

    public Language findBy(long id){
        return languageRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    public List<Language> findAll() {
        return languageRepository.findAll();
    }
}

