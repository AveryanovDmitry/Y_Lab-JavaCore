import java.util.Arrays;
import java.util.HashMap;

public class Task2 {
     /**
      * Task2
      * [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
     */
     public static void solutionTask2(int[] ints, int target) {
         HashMap<Integer, Integer> differenceAndIndex = new HashMap<>();
         int[] result = new int[2];

         for (int i = 0; i < ints.length; i++) {
             if (differenceAndIndex.containsKey(ints[i])) {
                 result[0] = differenceAndIndex.get(ints[i]);
                 result[1] = ints[i];
             } else
                 differenceAndIndex.put(target - ints[i], ints[i]);
         }
         System.out.println(Arrays.toString(result));
     }

    public static void main(String[] args) {

        solutionTask2(new int[]{3, 4, 2, 7}, 10);

    }
}
