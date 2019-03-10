import java.util.Scanner;


public class MainBenchmark<T> {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter your number of objects: ");
        int n = sc.nextInt();

        BenchmarkTests benchmarkArrayList = new BenchmarkTests();


        System.out.println("Which data structure would you like to test?\n1.) ArrayList\n2.) AVL\n3.) BST");
        int breaker = sc.nextInt();

        Set<Integer> typeofSet;
        switch (breaker) {
            case 1:
                typeofSet = new SetArrayList<>();
                break;
            case 2:
                typeofSet = new SetBST<>();
                break;
            case 3:
                typeofSet = new SetBST<>();
                break;
            default:
                typeofSet = new SetBST<>();
                System.out.println("Please enter a valid selection");
                main(args);
                break;
        }

        System.out.println("How many searches for contains?:");
        int numSearches = sc.nextInt();

        long startTime, endTime;
        System.out.println("Type of Set & memory location: " + typeofSet);

        startTime = System.nanoTime();
        benchmarkArrayList.insertRandoms(typeofSet, n);
        endTime = System.nanoTime();
        System.out.println("Total execution time for insertRandoms: " + (endTime - startTime) + "ns");

        startTime = System.nanoTime();
        benchmarkArrayList.insertInOrder(typeofSet, n);
        endTime = System.nanoTime();
        System.out.println("Total execution time for insertInOrder: " + (endTime - startTime) + "ns");

        startTime = System.nanoTime();
        benchmarkArrayList.containsRandom(typeofSet, n, numSearches);
        endTime = System.nanoTime();
        System.out.println("Total execution time for containsInOrder: " + (endTime - startTime) + "ns");

        startTime = System.nanoTime();
        benchmarkArrayList.containsInOrder(typeofSet, n, numSearches);
        endTime = System.nanoTime();
        System.out.println("Total execution time for insertInOrder: " + (endTime - startTime) + "ns");

    }
}

/*private double x = Math.PI;

    @Benchmark
    public void myBenchmark() {
        return Math.log(x);
    }*/
