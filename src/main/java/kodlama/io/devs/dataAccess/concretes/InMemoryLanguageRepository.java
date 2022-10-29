package kodlama.io.devs.dataAccess.concretes;

import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concretes.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class InMemoryLanguageRepository implements LanguageRepository {
    public List<Language> languages;

    public InMemoryLanguageRepository() {
        languages = new ArrayList<Language>();
        languages.add(new Language(1,"C++"));
        languages.add(new Language(2,"Swift"));
        languages.add(new Language(3,"Java"));
        languages.add(new Language(4,"Python"));
        languages.add(new Language(5,"Kotlin"));
    }


    @Override
    public List<Language> getAll() {
        return languages;
    }

    @Override
    public void getById(int id) {
        for (int i = 0; i<languages.size();i++){
            if (languages.get(i).getId() == id){
                System.out.println("Getirildi : " +languages.get(i).getName());
            }
        }
    }

    @Override
    public void addLanguage(Language language) {
    languages.add(language);
    System.out.println("Dil eklendi : " +language.getName());
    }

    @Override
    public void updateLanguage(int id, Language language) {
    languages.set(id,language);
    System.out.println("Dil güncellendi." +language.getName());
    }

    @Override
    public void removeLanguage(int id) {
        for (int i = 0; i<languages.size();i++){
            if (languages.get(i).getId() == id){
                System.out.println("Silindi : " +languages.remove(i).getName());
                languages.remove(i);
            }
        }
    }
    public List<Language> getList(){
        return languages;
    }
}
