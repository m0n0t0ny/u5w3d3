package antoniobertuccio.u5w3d3.part1.entities;

import antoniobertuccio.u5w3d3.part1.interfaces.DataSource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserData implements DataSource {
  private String nomeCompleto;
  private int eta;

  public UserData(DataSource ds) {
    nomeCompleto = ds.getNomeCompleto();
    eta = ds.getEta();
  }
}
