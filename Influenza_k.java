import java.util.Scanner;

public class Influenza_k {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for the file name
        System.out.println("Enter the name of the text file:");
        String fileName = scanner.nextLine() + ".txt";

        // Read the file and store cities in an array
        ReadFile readFile = new ReadFile(fileName);
        City[] cities = readFile.getCities();

        // Ask the user for the number of cities to compare
        System.out.println("Enter the number of cities to compare:");
        int k = scanner.nextInt();

        // Perform heap sort on the cities array
        HeapSort heapSort = new HeapSort();
        cities = heapSort.heapSort(cities);

        // Display the top k cities with the least amount of cases
        System.out.println("Top " + k + " cities with the least amount of cases:");
        for (int i = 0; i < k; i++) {
            System.out.println(cities[i].getName());
        }

        scanner.close();
    }
}
