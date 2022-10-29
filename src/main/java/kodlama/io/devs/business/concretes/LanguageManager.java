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

    private LanguageRepository languageRepository;
    List<Language> languageList;
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
        if (isUnique(language)){
            languageRepository.addLanguage(language);
            System.out.println("Eklendi : " + language.getName());
        }else {
            System.out.println("Eklenemedi.");
        }
    }

    @Override
    public void updateLanguage(int id, Language language) {
        for (int i = 0; i<languageList.size();i++){
            if (languageList.get(i).getId() == language.getId()){
                id = i;
            }
        }
        languageRepository.updateLanguage(id,language);

    }

    @Override
    public void removeLanguage(int id) {
    languageRepository.removeLanguage(id);
    }
    public boolean isUnique(Language language){
        languageList = languageRepository.getList();
        boolean unique = false;
        for (int i = 0; i<languageList.size();i++){
            if (languageList.get(i).getName().equalsIgnoreCase(language.getName()) || languageList.get(i).getId() == language.getId()){
                unique = false;
            }else {
                unique = true;
            }

        }
        return unique;
    }
}
