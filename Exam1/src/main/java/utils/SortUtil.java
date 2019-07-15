package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortUtil {
    public static void sortList(List<Integer> list){
        Object[] arr =  list.toArray();
        int n = list.size();
        if (n <= 1) return;       //如果只有一个元素就不用排序了

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位,即一次比较中没有交换任何元素，这个数组就已经是有序的了
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {        //此处你可能会疑问的j<n-i-1，因为冒泡是把每轮循环中较大的数飘到后面，
                // 数组下标又是从0开始的，i下标后面已经排序的个数就得多减1，总结就是i增多少，j的循环位置减多少
                if ((int)arr[j] > (int)arr[j + 1]) {        //即这两个相邻的数是逆序的，交换
                    int temp = (int)arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;//没有数据交换，数组已经有序，退出排序
        }
        list.clear();
        for (int i = 0; i < arr.length; i++) {
            list.add((Integer) arr[i]);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(1);
        integers.add(6);
        integers.add(5);
        sortList(integers);

    }
}
