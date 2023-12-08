import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public City[] cities;
    public int id;
    public String city;
    public int population;
    public int area;
    public float density;
    public int cityCount;

    public void lineProcessor(String[] tokens) {
        id = Integer.parseInt(tokens[0]);
        city = tokens[1];
        population = Integer.parseInt(tokens[2]);
        area = Integer.parseInt(tokens[3]);
        density = Float.parseFloat(tokens[5]);
    }

    public ReadFile() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the txt file:");
        String txtfile = input.nextLine();
        txtfile = txtfile + ".txt";

        try (BufferedReader br = new BufferedReader(new FileReader(txtfile))) {
            String line;

            // Count the number of lines in the file to determine the array size
            while ((line = br.readLine()) != null) {
                cityCount++;
            }

            // Initialize the array with the determined size
            cities = new City[cityCount];

            // Reset the BufferedReader to read from the start of the file
            br.close();
            br = new BufferedReader(new FileReader(txtfile));

            int index = 0;
            while ((line = br.readLine()) != null) {
                String[] elements = line.split("\\s+");
                lineProcessor(elements);
                cities[index] = new City(id, city, population, area, density);
                index++;
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            input.close();
        }
    }

    public City[] getCities() {
        return cities;
    }
}
