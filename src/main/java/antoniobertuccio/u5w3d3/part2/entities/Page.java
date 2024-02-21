package antoniobertuccio.u5w3d3.part2.entities;

import antoniobertuccio.u5w3d3.part2.interfaces.CompositeElement;

public class Page implements CompositeElement {
  private String content;

  public Page(String content) {
    this.content = content;
  }

  @Override
  public void print() {
    System.out.println(content);
  }

  @Override
  public int getTotalPages() {
    return 1;
  }
}
