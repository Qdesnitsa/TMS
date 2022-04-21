package by.teachmeskills.lesson11_exception.serialization;

import by.teachmeskills.lesson11_exception.entity.Car;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {
  private static String fileSerializeFrom = "./src/by/teachmeskills/lesson11_exception/resource/car.bin";

  public static void main(String[] args) {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileSerializeFrom))) {
      Car car1 = (Car)ois.readObject();
      Car car2 = (Car)ois.readObject();
      System.out.println(car1);
      System.out.println(car2);
    } catch (IOException e) {
      throw new RuntimeException("Problems with the InputStream", e);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException("Class Car is not found", e);
    }
  }

}
