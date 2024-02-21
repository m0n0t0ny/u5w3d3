package antoniobertuccio.u5w3d3.part1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.sql.DataSource;

@Getter
@Setter
@NoArgsConstructor
public class UserData {
  private String nomeCompleto;
  private int eta;

  public void getData(DataSource ds) {
    nomeCompleto = ds.getNomeCompleto();
    eta = ds.getEta();
  }
}