public class Task3 {
    public static int left(int i) {
        return (2*i + 1);
    }

    public static int right(int i) {
        return (2*i + 2);
    }

    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void makeHeap(int[] arr, int i, int size)
    {
        int leftBranch = left(i);
        int rightBranch = right(i);

        int largest = i;

        if (leftBranch < size && arr[leftBranch] > arr[i]) {
            largest = leftBranch;
        }

        if (rightBranch < size && arr[rightBranch] > arr[largest]) {
            largest = rightBranch;
        }
        if (largest != i)
        {
            swap(arr, i, largest);
            makeHeap(arr, largest, size);
        }
    }

    public static int pop(int[] arr, int size)
    {
        if (size <= 0) {
            return -1;
        }
        int top = arr[0];
        arr[0] = arr[size-1];
        makeHeap(arr, 0, size - 1);

        return top;
    }

    public static void heapSort(int[] arr)
    {
        int n = arr.length;
        int i = (n - 2) / 2;
        while (i >= 0) {
            makeHeap(arr, i--, n);
        }

        while (n > 0)
        {
            arr[n - 1] = pop(arr, n);
            n--;
        }
    }

    public static void main(String[] args) {
        int[] numbers = new int [] {3, 1, 7, 8, 112, -445, -61};

        heapSort(numbers);

        for(int el: numbers) {
            System.out.printf("%d ", el);
        }
        System.out.println();
    }
}