import java.util.Arrays;
import java.util.Scanner;

public class QQ1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
            int x = sc.nextInt();

            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = sc.nextInt();
            }
            Arrays.sort(ar);
            int num = 0;
            for (int i = 0; i < ((2 * n)-1); i = i + 2) {
                if(i==((2*n)-2)){
                    num=ar[i];
                }else
                if (ar[i] != ar[i + 1]) {
                    num = ar[i];
                    break;
                }
            }
            System.out.println(num);
        }


}
