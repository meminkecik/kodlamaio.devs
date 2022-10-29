package kodlama.io.devs.dataAccess.abstracts;

import kodlama.io.devs.entities.concretes.Language;

import java.util.List;

public interface LanguageRepository {
    List<Language> getAll();
    void getById(int id);
    void addLanguage(Language language);
    void updateLanguage(int id, Language language);
    void removeLanguage(int id);
    List<Language> getList();
}
