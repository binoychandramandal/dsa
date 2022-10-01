package binary.tuf;

public class AllocateMinimumNumberOfPages {
    public static void main(String[] args) {

        int[] books = {12, 34, 67, 90};
        System.out.println(findMinimumPages(books, 2));

    }

    static int findMinimumPages(int[] books, int students) {
        int result = Integer.MAX_VALUE;
        int low = books[0];
        int high = books[0];
        for (int i = 1; i < books.length; i++) {
            low = Math.min(low, books[i]);
            high +=books[i];
        }
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (isPosibileAllocation(books, mid, students)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    private static boolean isPosibileAllocation(int[] books, int pages, int students) {
        int studentCount = 1;
        int pgCount = 0;
        for (int i = 0; i < books.length; i++) {
            if (pgCount + books[i] > pages) {
                studentCount++;
                pgCount = books[i];
            } else {
                pgCount += books[i];
            }
        }
        return studentCount <= students;
    }
}
