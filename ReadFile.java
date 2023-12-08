import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
    }

    public ReadFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            // Count the number of lines in the file to determine the array size
            while ((line = br.readLine()) != null) {
                cityCount++;
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        // Initialize the array with the determined size
        cities = new City[cityCount];

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int index = 0;
            while ((line = br.readLine()) != null) {
                String[] elements = line.split("\\s+");
                lineProcessor(elements);
                cities[index] = new City(id, city, population, area);
                index++;
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public City[] getCities() {
        return cities;
    }
}
