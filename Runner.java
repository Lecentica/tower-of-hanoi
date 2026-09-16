import java.util.Scanner;
//Brayden Kim
public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of disks:");
        int n = sc.nextInt(); // Number of disks
        Tower test = new Tower(n);
        test.print();
        test.solve();
    }
}