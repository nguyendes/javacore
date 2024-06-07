

public class QuickSort {
    
    public static void main(String[] args) {
        int[] array = {9, 2, 4, 7, 3, 7, 10};
        
        System.out.println("Mang ban dau`:");
        printArray(array);
        
        quickSort(array, 0, array.length - 1);
        
        System.out.println("Sau khi sap xep");
        printArray(array);
    }

    public static void quickSort(int[] array, int sonho, int soto) {
        if (sonho < soto) {
            int moc = partition(array, sonho, soto);
            quickSort(array, sonho, moc - 1);
            quickSort(array, moc + 1, soto);
        }
    }

    public static int partition(int[] array, int sonho, int soto) {
        int moc = array[soto];
        int i = sonho - 1;

        for (int j = sonho; j < soto; j++) {
            if (array[j] <= moc) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, soto);
        return i + 1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
