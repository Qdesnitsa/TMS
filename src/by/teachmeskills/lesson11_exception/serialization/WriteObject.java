package by.teachmeskills.lesson11_exception.serialization;

import by.teachmeskills.lesson11_exception.entity.Car;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
  private static String fileSerializeTo = "./src/by/teachmeskills/lesson11_exception/resource/car.bin";

  public static void main(String[] args) {
    Car car1 = new  Car();
    Car car2 = new  Car();

    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileSerializeTo))) {
      oos.writeObject(car1);
      oos.writeObject(car2);
    } catch (IOException e) {
      throw new RuntimeException("Problems with the OutputStream", e);
    }
  }
}
