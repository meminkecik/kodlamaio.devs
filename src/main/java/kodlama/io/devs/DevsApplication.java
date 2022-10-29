package kodlama.io.devs;

import kodlama.io.devs.business.concretes.LanguageManager;
import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.dataAccess.concretes.InMemoryLanguageRepository;
import kodlama.io.devs.entities.concretes.Language;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevsApplication.class, args);

		LanguageManager languageManager = new LanguageManager(new InMemoryLanguageRepository());
		Language language1 = new Language();
		language1.setId(6);
		language1.setName("PHP");
		languageManager.addLanguage(language1);
		Language language2 = new Language();
		language2.setId(7);
		language2.setName("Script");
		languageManager.updateLanguage(5,language2);

	}



}
