package antoniobertuccio.u5w3d3;

import antoniobertuccio.u5w3d3.part1.adapter.InfoAdapter;
import antoniobertuccio.u5w3d3.part1.entities.Info;
import antoniobertuccio.u5w3d3.part1.entities.UserData;
import antoniobertuccio.u5w3d3.part2.entities.Book;
import antoniobertuccio.u5w3d3.part2.entities.Page;
import antoniobertuccio.u5w3d3.part2.entities.Section;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@SpringBootApplication
public class U5w3d3Application {

	public static void main(String[] args) {
		Faker faker = new Faker();

		Info fakeInfo = new Info();
		fakeInfo.setNome(faker.name().firstName());
		fakeInfo.setCognome(faker.name().lastName());
		fakeInfo.setDataDiNascita(faker.date().birthday(10, 50));

		InfoAdapter adapter = new InfoAdapter(fakeInfo) {
			@Override
			public int getEta() {
				Date birthDate = fakeInfo.getDataDiNascita();
				LocalDate birthLocalDate = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				return Period.between(birthLocalDate, LocalDate.now()).getYears();
			}
		};

		UserData userData = new UserData(adapter);

		System.out.println("Nome Completo: " + userData.getNomeCompleto());
		System.out.println("Età: " + userData.getEta());

		Book book = new Book();
		book.addAuthor(faker.book().author());
		book.addAuthor(faker.book().author());
		book.setPrice(faker.number().randomDouble(2,2,39));

		Page page1 = new Page("Page Content 1");
		Page page2 = new Page("Page Content 2");
		Page page3 = new Page("Page Content 3");

		Section section1 = new Section("Chapter 1");
		section1.addElement(page1);
		section1.addElement(page2);

		Section section2 = new Section("Chapter 2");
		section2.addElement(page3);

		Section mainSection = new Section("Book");
		mainSection.addElement(section1);
		mainSection.addElement(section2);

		book.addElement(mainSection);

		book.print();
		System.out.println("Total number of pages in the book: " + book.getTotalPages());
	}
}
