package antoniobertuccio.u5w3d3.part2.entities;

import antoniobertuccio.u5w3d3.part2.interfaces.CompositeElement;

import java.util.ArrayList;
import java.util.List;

public class Book implements CompositeElement {
  private List<CompositeElement> elements;
  private List<String> authors;
  private double price;

  public Book() {
    this.elements = new ArrayList<>();
    this.authors = new ArrayList<>();
  }

  public void addElement(CompositeElement element) {
    elements.add(element);
  }

  public void addAuthor(String author) {
    authors.add(author);
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public void print() {
    System.out.println("Book Information:");
    System.out.println("Authors: " + authors);
    System.out.println("Price: " + price);
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
