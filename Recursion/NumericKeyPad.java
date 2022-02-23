//this code is used to print all the combinations of strings
//which are produced when user enters the keypad numbers
import java.util.*;
public class NumericKeyPad {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
         System.out.println("Enter the number ");
        int number=sc.nextInt();
        dial(number);
        sc.close();
    }
    //helper function
    public static void dial(int num)
    {
        dial(num,"");
    }
    //acctual function
    public static void dial(int num ,String str){
        if(num==0)
        {
            System.out.println(str);
        }
        else
        {
            String add=keypad(num%10);
            for(int i =0;i<add.length();i++)
            {
             dial(num/10,str+add.charAt(i));   
            }
        }
    }
    //this function defines your desired keypad
    public static String keypad(int num)
    {
        if(num==1||num==0)
        return "";
        if(num==2)
        return "abc";
        if(num==3)
        return "def";
        if(num==4)
        return "ghi";
        if(num==5)
        return "jkl";
        if(num==6)
        return "mno";
        if(num==7)
        return "pqrs";
        if(num==8)
        return "tuv";
        if(num==9)
        return "wxyz";
        return "";
    }
}
