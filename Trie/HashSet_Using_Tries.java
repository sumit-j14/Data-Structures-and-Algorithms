//this only handles 3 digit numbers
//uses concept like trie data structure
import java.util.Scanner;
public class implement_HashSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyHashSet hs = new MyHashSet();
        System.out.println("keep entring 3 digit numbers till -1 for exit");
        int t;
        while ((t = sc.nextInt()) != -1)
            hs.add(t);
        System.out.println("keep entring numbers to search -1 for exit");
        while ((t = sc.nextInt()) != -1) {
            System.out.println(hs.contains(t));
        }
        sc.close();
    }
}

class pair {
    boolean isEnding;
    boolean ispresent;
}

class MyHashSet {

    pair first[] = new pair[10];
    pair[] second = new pair[10];
    pair third[] = new pair[10];

    public MyHashSet() {
        for (int i = 0; i < 10; i++)
            first[i] = new pair();
        for (int i = 0; i < 10; i++)
            second[i] = new pair();
        for (int i = 0; i < 10; i++)
            third[i] = new pair();

    }

    void add(int number) {
        if (number == 0)
            return;
        else {
            first[number % 10].ispresent = true;
            if (number / 10 == 0) {
                first[number % 10].isEnding = true;
                return;
            } else {
                number = number / 10;
                second[number % 10].ispresent = true;
                if (number / 10 == 0) {
                    second[number % 10].isEnding = true;
                    return;
                } else {
                    number = number / 10;
                    third[number % 10].ispresent = true;
                    if (number / 10 == 0) {
                        third[number % 10].isEnding = true;
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    boolean contains(int number) {
        if (number == 0)
            return false;
        else {
            if (first[number % 10].ispresent == true) {
                if (number / 10 == 0)
                    return first[number % 10].isEnding;
                else {
                    number = number / 10;
                    if (second[number % 10].ispresent == true) {
                        if (number / 10 == 0)
                            return second[number % 10].isEnding;
                        else {
                            number = number / 10;
                            if (third[number % 10].ispresent == true) {
                                if (number / 10 == 0)
                                    return third[number % 10].isEnding;
                                else {
                                    return false;
                                }
                            } else
                                return false;
                        }
                    } else
                        return false;
                }
            } else
                return false;
        }
    }
}
