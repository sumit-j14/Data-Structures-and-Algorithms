import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class nonRepeating_Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("keep entring numbers -1 for exit");
        ArrayList<Integer> al = new ArrayList<>();
        int t = 0;
        while ((t = sc.nextInt()) != -1)
            al.add(t);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int temp : al) {
            if (hm.containsKey(temp)) {
                hm.put(temp, hm.get(temp) + 1);
            } else {
                hm.put(temp, 1);
            }
        }
        System.out.println("distinct elements are");
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() == 1)
                System.out.println(entry.getKey());
        }
        sc.close();
    }
}
