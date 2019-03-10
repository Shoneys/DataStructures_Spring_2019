import java.util.Scanner;


public class MainBenchmark<T> {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

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
                typeofSet = new SetAVL<>();
                break;
            default:
                System.out.println("Please enter a valid selection");
                main(args);
                typeofSet = null;
                System.exit(0);
                break;
        }

        System.out.print("Enter your number of objects: ");
        int n = sc.nextInt();

        System.out.println("How many searches for contains?:");
        int numSearches = sc.nextInt();

        System.out.println("How many tests for each?:");
        int numTests = sc.nextInt();

        long startTime, endTime;
        System.out.println("Type of Set & memory location: " + typeofSet);

        long avetimeforInsertRand = 0;
        for (int i = 0; i < numTests; i++) {
            startTime = System.nanoTime();
            benchmarkArrayList.insertRandoms(typeofSet, n);
            endTime = System.nanoTime();
            System.out.println("Total execution time for insertRandoms: " + (endTime - startTime) + "ns");
            avetimeforInsertRand += endTime - startTime;
        }
        avetimeforInsertRand = avetimeforInsertRand / numTests;

        long avetimeforInsertInOrder = 0;
        for (int i = 0; i < numTests; i++) {
            startTime = System.nanoTime();
            benchmarkArrayList.insertInOrder(typeofSet, n);
            endTime = System.nanoTime();
            System.out.println("Total execution time for insertInOrder: " + (endTime - startTime) + "ns");
            avetimeforInsertInOrder += endTime - startTime;
        }
        avetimeforInsertInOrder = avetimeforInsertInOrder / numTests;

        long avetimeforcontainsRandom = 0;
        for (int i = 0; i < numTests; i++) {
            startTime = System.nanoTime();
            benchmarkArrayList.containsRandom(typeofSet, n, numSearches);
            endTime = System.nanoTime();
            System.out.println("Total execution time for containsRandom: " + (endTime - startTime) + "ns");
            avetimeforcontainsRandom += endTime - startTime;
        }
        avetimeforcontainsRandom = avetimeforcontainsRandom / numTests;

        long avetimeforcontainsInOrder = 0;
        for (int i = 0; i < numTests; i++) {
            startTime = System.nanoTime();
            benchmarkArrayList.containsInOrder(typeofSet, n, numSearches);
            endTime = System.nanoTime();
            System.out.println("Total execution time for containsInOrder: " + (endTime - startTime) + "ns");
            avetimeforcontainsInOrder += endTime - startTime;
        }
        avetimeforcontainsInOrder = avetimeforcontainsInOrder / numTests;

        System.out.println("\nAverage time for insertRandoms: " + avetimeforInsertRand);
        System.out.println("Average time for insertInOrder: " + avetimeforInsertInOrder);
        System.out.println("Average time for containsRandom: " + avetimeforcontainsRandom);
        System.out.println("Average time for containsInOrder: " + avetimeforcontainsInOrder);
    }
}

/*private double x = Math.PI;

    @Benchmark
    public void myBenchmark() {
        return Math.log(x);
    }*/
