import java.util.*;

class CustomComparator implements Comparator<Map.Entry<Integer, Integer>> {
    public int compare(Map.Entry<Integer, Integer> c1, Map.Entry<Integer, Integer> c2) {
        if (c1.getValue() == c2.getValue())
            return 0;
        else if (c1.getValue() > c2.getValue())
            return 1;
        else if (c1.getValue() < c2.getValue())
            return -1;
        return 0;
    }
}

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter numbers till -1");
        ArrayList<Integer> al = new ArrayList<>();
        int t = 0;
        while ((t = sc.nextInt()) != -1)
            al.add(t);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : al) {
            if (hm.containsKey(i) == true) {
                hm.put(i, hm.get(i) + 1);
            } else {
                hm.put(i, 1);
            }
        }
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hm.entrySet())
            list.add(entry);
        System.out.println("done computation");
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        // hm.forEach((k, v)-> System.out.println(k + " : "+ v));
        System.out.println("sorting according to the number of times the entries appeared in tlist");
        Collections.sort(list, new CustomComparator());
        for (Map.Entry<Integer, Integer> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        sc.close();
    }
}
