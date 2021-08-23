import java.util.Scanner;

public class subset {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=sc.nextInt();
        int[] ar=new int[n];
        for (int i=0;i<n;i++){
            ar[i]=sc.nextInt();
        }
        int count=0;
        int add=0;
        for (int i=0;i<n-1;i++){
            add=0;
            for (int j=i+1;j<n;j++){
                add=ar[i]+ar[j];
                if(add==sum){
                   count++;
                }
            }
        }
        System.out.println(count);



    }
}
