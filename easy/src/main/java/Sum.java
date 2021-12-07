import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @className: Sum
 * @description:
 * @author: Yang Naihua
 * @create: 2021-11-18 17:05
 **/
public class Sum {
    public static int[] twoSum(int[] sums, int target) {
        for (int i = 0; i < sums.length; i++) {
            for (int j = i + 1; j <= sums.length - 1; j++) {
                if (sums[i] + sums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static int[] generateRandom(int size, int scope) {
        int[] arr = new int[(int) ((size + 1) * Math.random())];
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 1; i < arr.length; i++) {
//            maps.put((int) ((scope + 1) * Math.random()),i) ;
            // TODO 如何生成随机且不包含重复数字的数组？
            arr[i] = (int) ((scope + 1) * Math.random());
//            arr[i] = (int) ((scope + 1) * Math.random()) - (int) ((scope) * Math.random());
        }

//        return ;
        return arr;
    }

//    /**
//     * @description: 系统排序
//     * @method systemArrays
//     * @date 2021-12-06 23:56:56
//     * @author Yang Naihua
//     */
//    public static void systemCompare(int[] arrays) {
//        Arrays.sort(arrays);
//    }

    public static int[] sumByMap(int[] sums, int target) {
        Map<Integer, Integer> maps = new HashMap<Integer, Integer>();
        for (int j = 0; j < sums.length; j++) {
            if (maps.containsKey(target - sums[j])) {
                return new int[]{maps.get(target - sums[j]), j};

            }
            maps.put(sums[j], j);

        }
        return new int[]{};
    }


    public static void main(String[] args) {
        // 次数
        int times = 500000000;
        // 规模
        int size = 10;
        // 范围
        int scope = 10;

        // 目标
        int total = 50;

        for (int i = 1; i < times; i++) {
            int[] arr = generateRandom(size, scope);
            int[] copyArrays = copyArray(arr);
            int[] byMaps = sumByMap(arr, total);
            int[] byOrign = twoSum(copyArrays, total);

            if (!isEqual(byMaps, byOrign)) {
                System.err.println("error");
            }
        }
    }

    private static boolean isEqual(int[] byMaps, int[] byOrigin) {
        if (byMaps.length != byOrigin.length) {
            return false;
        }
        for (int i = 1; i < byMaps.length; i++) {
            if (byMaps[i] != byOrigin[i]) {
                return false;
            }
        }

        return true;
    }

    private static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
}