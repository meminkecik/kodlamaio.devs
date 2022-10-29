package kodlama.io.devs.business.abstracts;

import kodlama.io.devs.entities.concretes.Language;

import java.util.List;

public interface LanguageService {
    List<Language> getAll();
    void getById(int id);
    void addLanguage(Language language);
    void updateLanguage(int id, Language language);
    void removeLanguage(int id);
}
