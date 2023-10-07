package org.premium;

interface IRequestQuotation {
  double calPremium(Input input) throws Exception;
}

public class RequestQuotation implements IRequestQuotation {
  public static final String PARKING_LOCATION = "Public Place";

  public double calPremium(Input input) throws Exception {
    if (input.getEstValue() < 100) {
      throw new Exception("Do not proceed");
    }
    double increase = calIncreaseForCoverType(input.getCoverType());

    double total = input.getEstValue() * increase;

    if (input.isWindScreenRepair()) {
      total += 30;
    }

    if (input.getTotalMileage() > 5000) {
      total += 50;
    }

    if (input.getParkingLocation().equals(PARKING_LOCATION)) {
      total += 30;
    }

    if (input.getAccidents() == 0) {
      total *= 0.7;
    }

    return total;
  }

  private double calIncreaseForCoverType(String coverType) {
    double rate = 1;
    switch (coverType) {
      case CoverType.NO_COVER:
        rate = 0.01;
        break;
      case CoverType.ROADSIDE:
        rate = 0.02;
        break;
      case CoverType.AT_HOME:
        rate = 0.03;
        break;
      case CoverType.EUROPEAN:
        rate = 0.04;
        break;
    }
    return rate;
  }
}
