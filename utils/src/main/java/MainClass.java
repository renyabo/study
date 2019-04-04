import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    class Helper {
        LinkedList<Integer> order = new LinkedList<>();
        boolean ok = false;
        int maxDepth;
        Set<String> set = new HashSet<>();

        Helper(int maxDepth) {
            this.maxDepth = maxDepth;
        }

        boolean reachMaxDepth() {
            return order.size() >= maxDepth;
        }

        boolean cut(int[] a) {
            String string = Arrays.toString(a);
            if (set.contains(string)) {
                return true;
            }
//            System.out.println(string);
            set.add(string);
            return false;
        }
    }

    public List<Integer> pancakeSort(int[] A) {
        if (ordered(A)) {
            return new ArrayList<>();
        }
        Helper helper = new Helper(10 * A.length);
        helper.cut(A);
        dfs(A, helper);
        return helper.order;
    }

    void dfs(int[] array, Helper helper) {
//        System.out.println(Arrays.toString(array)+","+helper.order);
        if (helper.ok || helper.reachMaxDepth()) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            swap(array, i);
            helper.order.addLast(i + 1);
            if (ordered(array)) {
                helper.ok = true;
                return;
            }
            if (!helper.cut(array)) {
                dfs(array, helper);
            }
            if (helper.ok) {
                break;
            }
            helper.order.removeLast();
            swap(array, i);//回溯
        }
    }

    boolean ordered(int[] a) {
        if (a == null || a.length <= 1) {
            return true;
        }
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    void swap(int[] arr, int k) {
        int i = 0;
        while (i <= k) {
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
            i++;
            k--;
        }
    }
}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] A = stringToIntegerArray(line);

            long start = System.currentTimeMillis();
            List<Integer> ret = new Solution().pancakeSort(A);
            System.out.println(System.currentTimeMillis()-start);
            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}