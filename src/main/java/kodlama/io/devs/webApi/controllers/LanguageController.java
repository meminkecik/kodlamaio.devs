package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/languages")
public class LanguageController {
    private LanguageService languageService;
    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }
    @GetMapping("/getall")
    public List<Language> getAll(){return  languageService.getAll();}
    @PostMapping("/addlanguage")
    public void addLanguage(@RequestBody Language language){
        languageService.addLanguage(language);
    }
    @GetMapping("/getbyid/{id}")
    public void getById(@PathVariable("id") int id){
        languageService.getById(id);
    }
    @PatchMapping(value = "/updatelanguage/{id}")
    public void updateLanguage(@PathVariable("id") int id,@RequestBody Language language){
        languageService.updateLanguage(id,language);
    }
    @DeleteMapping(value = "/removelanguage/{id}")
    public void removeLanguage(@PathVariable("id") int id){
        languageService.removeLanguage(id);
    }
}
