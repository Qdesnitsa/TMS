package by.tms.lesson19_multithreading.task05;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class SaveAsThread implements Runnable {
    private int[] array;
    private String filePath;

    public SaveAsThread(String filePath, int arrayLength) {
        this.array = initArray(arrayLength);
        this.filePath = filePath;
    }

    private int[] initArray(int arrayLength) {
        array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = new Random().nextInt(100);
        }
        return array;
    }

    public static void cleanFile(String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath, false)) {
            fileWriter.write("");
        } catch (IOException e) {
            throw new RuntimeException("Error in cleaning file", e);
        }
    }

    @Override
    public void run() {
        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            try {
                fileWriter.write(Arrays.toString(array) + "\n");
            } catch (IOException e) {
                throw new RuntimeException("Error in writing to file", e);
            }
        } catch (IOException ex) {
            throw new RuntimeException("File to write can not be opened.", ex);
        }
    }
}
