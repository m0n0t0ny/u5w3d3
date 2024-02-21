package antoniobertuccio.u5w3d3.part1.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Info {
  private String nome;
  private String cognome;
  private Date dataDiNascita;

  public int calcolaEta() {
    return 0;
  }
}
