import java.util.Scanner;

public class Q1 {
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        for (int k = 0; k < testcase; k++) {
            int n = sc.nextInt();
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = sc.nextInt();
            }
            int low = 0;
            int high = n - 1;
            boolean boo=false;
            String s = "";
            count=0;
          subseq(s,ar,low,high);
          System.out.println(count);


        }
    }

    public static void subseq(String s, int[] ar, int low, int high) {
        if (low <= high+1 && !s.equals("")) {
            int sum=0;
           for (int i=0;i<s.length();i++){
               sum=sum+Integer.parseInt(String.valueOf(s.charAt(i)));
           }
           if(sum%2==1){
               count++;
           }


        }
        for (int j = low; j <= high; j++) {
            subseq(s + ar[j], ar, j + 1, high);
        }
    }
}








