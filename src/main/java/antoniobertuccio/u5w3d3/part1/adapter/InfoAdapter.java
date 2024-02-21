package antoniobertuccio.u5w3d3.part1.adapter;

import antoniobertuccio.u5w3d3.part1.entities.Info;
import antoniobertuccio.u5w3d3.part1.interfaces.DataSource;

public class InfoAdapter implements DataSource {
  private final Info info;

  public InfoAdapter(Info info) {
    this.info = info;
  }

  @Override
  public String getNomeCompleto() {
    return info.getNome() + " " + info.getCognome();
  }

  @Override
  public int getEta() {
    return info.calcolaEta();
  }
}
