package org.premium;

public class Input {
  public String coverType;
  public boolean isWindScreenRepair;
  public int accidents;
  public int totalMileage;
  public int estValue;
  public String parkingLocation;

  public Input() {

  }

  public Input(String coverType, boolean isWindScreenRepair, int accidents, int totalMileage, int estValue,
      String parkingLocation) {
    this.coverType = coverType;
    this.isWindScreenRepair = isWindScreenRepair;
    this.accidents = accidents;
    this.totalMileage = totalMileage;
    this.estValue = estValue;
    this.parkingLocation = parkingLocation;
  }

  public String getCoverType() {
    return coverType;
  }

  public void setCoverType(String coverType) {
    this.coverType = coverType;
  }

  public boolean isWindScreenRepair() {
    return isWindScreenRepair;
  }

  public void setWindScreenRepair(boolean isWindScreenRepair) {
    this.isWindScreenRepair = isWindScreenRepair;
  }

  public int getAccidents() {
    return accidents;
  }

  public void setAccidents(int accidents) {
    this.accidents = accidents;
  }

  public int getTotalMileage() {
    return totalMileage;
  }

  public void setTotalMileage(int totalMileage) {
    this.totalMileage = totalMileage;
  }

  public int getEstValue() {
    return estValue;
  }

  public void setEstValue(int estValue) {
    this.estValue = estValue;
  }

  public String getParkingLocation() {
    return parkingLocation;
  }

  public void setParkingLocation(String parkingLocation) {
    this.parkingLocation = parkingLocation;
  }
}
