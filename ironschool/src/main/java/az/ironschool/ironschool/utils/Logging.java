package az.ironschool.ironschool.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logging {

    public static void log(String message){

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("log.txt", true))) {

            writer.write(LocalDateTime.now() + " ---> " + message);
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
