import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile {
    public static City[] cities;
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

    public WriteFile() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the txt file:");
        String txtfile = input.nextLine();
        txtfile = txtfile + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(txtfile))) {
            System.out.println("Enter the data");
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                String[] tokens = line.split("\\s+");
                lineProcessor(tokens);
                writer.write("ID: " + id + ", City: " + city + ", Population: " + population
                        + ", Area: " + area + ", Density: " + density + "\n");
                // Assuming cityCount is known, resize the array if necessary
                if (cities == null || cityCount >= cities.length) {
                    resizeArray();
                }
                cities[cityCount++] = new City(id, city, population, area, density);
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            input.close();
        }
    }

    private void resizeArray() {
        // Double the array size when resizing
        City[] newCities = new City[cities == null ? 1 : cities.length * 2];
        if (cities != null) {
            System.arraycopy(cities, 0, newCities, 0, cities.length);
        }
        cities = newCities;
    }
}
