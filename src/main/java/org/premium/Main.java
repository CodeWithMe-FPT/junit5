package org.premium;

public class Main {
  public static void main(String[] args) {

    Input input = new Input("No Cover", true, 1, 4999, 200, RequestQuotation.PARKING_LOCATION);
    RequestQuotation requestQuotation = new RequestQuotation();

    try {
      double premium = requestQuotation.calPremium(input);
      System.out.println("Premium: " + premium);
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}