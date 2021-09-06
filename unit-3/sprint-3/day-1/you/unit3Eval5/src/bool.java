import java.util.Scanner;

public class bool {
    static boolean boo;
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
             boo=false;
            String s = "";
            subseq(s,ar,low,high);
            if(boo){
                System.out.println("no");
            }else{
                System.out.println("yes");
            }


        }
    }

    public static void subseq(String s, int[] ar, int low, int high) {
        if (low <= high && !s.equals("")) {

            if (Integer.parseInt(String.valueOf(s.charAt(0))) % 2 == 1 && Integer.parseInt(String.valueOf(s.charAt(s.length() - 1))) % 2 == 1) {
                boo=true;

            }else{
                boo=false;
            }

        }
        for (int j = low; j < high; j++) {
            subseq(s + ar[j], ar, j + 1, high);
        }

    }
}
