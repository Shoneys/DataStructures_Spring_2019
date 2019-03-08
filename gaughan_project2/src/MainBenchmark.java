import java.util.*;


public class MainBenchmark{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which data strucutre would you like to test?\n1.) ArrayList\n2.)");

        System.out.print("Enter your number of objects: ");
        int n = sc.nextInt();
        long startTime, endTime;

        BenchmarkTests benchmarkArrayList = new BenchmarkTests();

        startTime = System.nanoTime();
        System.out.println(benchmarkArrayList.insertRandoms(set, n));
        endTime = System.nanoTime();
        System.out.println("Total execution time for insertRandoms: " + (endTime - startTime) + "ns");

        startTime = System.nanoTime();
        System.out.println(benchmarkArrayList.insertInOrder(set, n));
        endTime = System.nanoTime();
        System.out.println("Total execution time for insertInOrder: " + (endTime - startTime) + "ns");
    }
}

/*private double x = Math.PI;

    @Benchmark
    public void myBenchmark() {
        return Math.log(x);
    }*/
