import java.util.Arrays;

public class search {

    public static int loweBound(int[] data, int point) {
        int start = 0;
        int end = data.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (data[mid] >= point) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }


    public static int upperBound(int[] data, int point) {
        int start = 0;
        int end = data.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (data[mid] <= point) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }


    public static void main(String[] args) {

        int[] a = {1, 2, 3, 3, 3, 3, 5, 9};

        System.out.println(loweBound(a, 3));
        System.out.println(upperBound(a, 3));

        System.out.println("=");

        System.out.println(loweBound(a, 11));
        System.out.println(upperBound(a, 11));

        System.out.println("=");

        System.out.println(Arrays.binarySearch(a, 2));

        System.out.println(Arrays.binarySearch(a, 4));

    }
}
