import java.util.Random;

//is mergesort hyperthreading?
//is it not because on runs after the other
public class heapSort
{
    public void sort(int arr[])
    {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        heapSort sortedheap = new heapSort();
        int[] springbreak = new int[19];

        Random r = new Random();
        for (int i = 0; i < 19; i++) {
            springbreak[i] = r.nextInt((50 - 30) + 1) + 1;
        }

        sortedheap.sort(springbreak);
        sortedheap.printArray(springbreak);
    }
}



/*

public class heapSort {
    int size;
    int[] heap;

    public void heapsort(int[] heaptemp) {
        heap = heaptemp;
        size = heap.length;
    }

    public void sort() {
        //build heap (rearrange array)
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(size,i);
        }

        //one by one extract an element from heap
        for(int i=size-1;i>=0;i--){
            //move current root to end
            int temp = heap[0];
            heap[0]=heap[i];
            heap[i]=temp;

            //call max heapify on the reduced heap
            heapify(i,0);
        }

    }

    // to heapify subtree rooted with node i which is
    // an index in arr[]. n is size of heap

    private void heapify(int size, int i) {
        int largest = i; //initialize largest as root
        int l = 2 * i + 1; // left 2*i +1
        int r = 2 * i + 2; // right 2*i+2

        // If left child is larger than root
        if (l < size && heap[l] > heap[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < size && heap[r] > heap[largest]) {
            largest = r;
        }

        //if largest != root
        if (largest != i) {
            int swap = heap[i];
            heap[largest] = swap;
            heap[largest] = swap;

            // recursively heapify the affected subtree
            heapify(size, largest);
        }
    }

    */
/* A utility function to print array of size n *//*

    void printArray() {
        int n = heap.length;
        for (int i = 0; i < n; ++i)
            System.out.print(heap[i] + " ");
        System.out.println();
    }
}
*/
