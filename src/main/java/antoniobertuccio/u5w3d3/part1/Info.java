package antoniobertuccio.u5w3d3.part1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Info {
  private String nome;
  private String cognome;
  private Date dataDiNascita;
}