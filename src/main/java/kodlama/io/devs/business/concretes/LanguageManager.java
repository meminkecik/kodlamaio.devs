package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LanguageManager implements LanguageService {
    List<Language> languageList;
    private LanguageRepository languageRepository;
    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.getAll();
    }

    @Override
    public void getById(int id) {
     languageRepository.getById(id);
    }

    @Override
    public void addLanguage(Language language) {
        languageList = languageRepository.getAll();
        for (int i = 0; i<languageList.size();i++){
            if (languageList.get(i).getId() == language.getId()){
                System.out.println("Bu id mevcuttur. Lütfen farklı bir id giriniz.");
            } if (languageList.get(i).getName()==language.getName()) {
                System.out.println("Bu dil mevcuttur. Lütfen farklı bir dil giriniz.");
            }else {
                languageRepository.addLanguage(language);
            }
        }
        System.out.println("Dil eklendi : " +language.getName());
    }

    @Override
    public void updateLanguage(int id, Language language) {
    languageRepository.updateLanguage(id,language);
    }

    @Override
    public void removeLanguage(int id) {
    languageRepository.removeLanguage(id);
    }
}
