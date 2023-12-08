import java.util.Scanner;


public class Influenza_k{
    public static void main(String[] args) {
        ReadFile temp=new ReadFile();
        System.out.println(temp.getCities());
        HeapSort sort=new HeapSort();
        City[] cities=sort.heapSort(temp.getCities());
        System.out.println("Enter the number of cities you want to compare:");
        Scanner input=new Scanner(System.in);
        int k=input.nextInt();
        for(int i=0;i<k;i++){
            System.out.println(cities[i].getName());
        }
        

    }
}

