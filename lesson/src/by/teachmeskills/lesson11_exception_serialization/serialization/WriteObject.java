package by.teachmeskills.lesson11_exception_serialization.serialization;

import by.teachmeskills.lesson11_exception_serialization.entity.Car;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public final class WriteObject {
  private static String fileSerializeTo = "./src/by/teachmeskills/lesson11_exception_serialization/resource/car.bin";

  private WriteObject() {}

  public static void main(String[] args) {
    Car car1 = new Car();
    Car car2 = new Car();

    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileSerializeTo))) {
      oos.writeObject(car1);
      oos.writeObject(car2);
    } catch (IOException e) {
      throw new RuntimeException("Problems with the OutputStream", e);
    }
  }
}
