package antoniobertuccio.u5w3d3;

import antoniobertuccio.u5w3d3.part1.adapter.InfoAdapter;
import antoniobertuccio.u5w3d3.part1.entities.Info;
import antoniobertuccio.u5w3d3.part1.entities.UserData;
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
	}
}
