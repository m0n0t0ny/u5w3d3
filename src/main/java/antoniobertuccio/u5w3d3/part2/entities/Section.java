package antoniobertuccio.u5w3d3.part2.entities;

import antoniobertuccio.u5w3d3.part2.interfaces.CompositeElement;

import java.util.ArrayList;
import java.util.List;

public class Section implements CompositeElement {
  private String title;
  private List<CompositeElement> elements;

  public Section(String title) {
    this.title = title;
    this.elements = new ArrayList<>();
  }

  public void addElement(CompositeElement element) {
    elements.add(element);
  }

  @Override
  public void print() {
    System.out.println("Section: " + title);
    for (CompositeElement element : elements) {
      element.print();
    }
  }

  @Override
  public int getTotalPages() {
    int totalPages = 0;
    for (CompositeElement element : elements) {
      totalPages += element.getTotalPages();
    }
    return totalPages;
  }
}
