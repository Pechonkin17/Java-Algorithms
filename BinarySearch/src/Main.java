public class Main {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] {-1, 5, 7, 8, 14, 17, 45, 55, 100}, 55));
        int[] a = {-1, 5, 7, 8, 14, 17, 45, 55, 100};
        System.out.println(binarySearchRecursion(a, 55, 0, a.length - 1));
    }

    // #1
    public static int binarySearch(int []a, int key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (key < a[middle]) high = middle - 1;
            else if (key > a[middle]) low = middle + 1;
            else return middle;
        }
        return -1;
    }

    // #2
    public static int binarySearchRecursion(int[] a, int key, int low, int high) {
        if (low > high) {return -1;}

        int middle = low + (high - low) / 2;

        if (key == a[middle]) return middle;
        else if (key < a[middle]) return binarySearchRecursion(a, key, low, middle - 1);
        else return binarySearchRecursion(a, key, middle + 1, high);
    }
}