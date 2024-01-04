import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(scanner.nextInt());
        quickSort(list, 0 , list.size() - 1);
        System.out.println(list);
    }

    private static void quickSort(List<Integer> list, int left, int right) {
        if (left < right) {
            int partition = partition(list, left, right);
            quickSort(list, left, partition - 1);
            quickSort(list, partition + 1, right);
        }
    }
    private static int partition(List<Integer> list, int left, int right) {
        int i = left + 1;
        int j = right;
        int pivot = list.get(left);
        while(i <= j) {
            while(i <= j && list.get(i) <= pivot) i++;
            while(i <= j && list.get(j) > pivot) j--;
            if (i <= j) {
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;j--;
            }
        }
        list.set(left, list.get(j));
        list.set(j, pivot);
        return j;
    }
}