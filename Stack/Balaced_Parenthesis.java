import java.util.*;
public class Parenthesis_Balanced {
	static boolean check_Paren(String Test_String){
		Deque<Character> stack= new ArrayDeque<Character>();
		for (int i = 0; i < Test_String.length(); i++){
			char x = Test_String.charAt(i);
			if (x == '(' || x == '[' || x == '{'){
				stack.push(x);
				continue;
			}
			if (stack.isEmpty())
				return false;
			char check;
			switch (x) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}
		return (stack.isEmpty());
	}	
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
		String Test_String = sc.nextLine();
		if (check_Paren(Test_String))
			System.out.println("yes");
		else
			System.out.println("No ");
	}
}
