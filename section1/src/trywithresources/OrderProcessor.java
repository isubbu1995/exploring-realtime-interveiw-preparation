import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OrderProcessor {
    public static void main(String[] args) {
        String fileName = "orders.txt";

      try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
          String line ;
          while ((line=bufferedReader.readLine())!=null){
              processOrder(line);
          }
      }catch (IOException e){
          System.err.println("Error reading file: " + e.getMessage());
      }
    }

    private static void processOrder(String order) {
        // Placeholder for order processing logic
        System.out.println("Processing order: " + order);
    }
}
