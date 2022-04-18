package by.teachmeskills.lesson11_exception.entity;

import by.teachmeskills.lesson11_exception.exception.EvenNumberException;
import java.io.Serializable;
import java.util.Objects;

public class Car implements Serializable {

  private static final long serialVersionUID = -6014008208280340074L;
  private String model;
  private int maxSpeed;
  private double sellingPrice;
  private Engine engine;

  private Car() {
  }

  public Car(String model, int maxSpeed, double sellingPrice) {
    this.engine = new Engine();
    this.model = model;
    this.maxSpeed = maxSpeed;
    this.sellingPrice = sellingPrice;
  }

  public void start() throws EvenNumberException {
    engine.obtainResult();
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(int maxSpeed) {
    this.maxSpeed = maxSpeed;
  }

  public double getSellingPrice() {
    return sellingPrice;
  }

  public void setSellingPrice(double sellingPrice) {
    this.sellingPrice = sellingPrice;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car car = (Car) o;
    return maxSpeed == car.maxSpeed && Double.compare(car.sellingPrice, sellingPrice) == 0
        && model.equals(car.model);
  }

  @Override
  public int hashCode() {
    return Objects.hash(model, maxSpeed, sellingPrice);
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() +
        "model='" + model + '\'' +
        ", maxSpeed=" + maxSpeed +
        ", sellingPrice=" + sellingPrice +
        '}';
  }
}
