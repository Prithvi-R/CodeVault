package Java.lab3;

import java.util.*;

public class Count {
    static int[] EvenOddArray(int t){
        int even = 0,crrEven = 0, crrOdd = 0, odd = 0;
        Scanner sc = new Scanner(System.in);
        int a[] = new int[(2*t)+2];
        while(t > 0){
            int n;
            crrEven = 0; crrOdd = 0;
            n = sc.nextInt();
            int []arr = new int[n];
            for(int i=0; i < n; ++i ){
                arr[i] = sc.nextInt();
                if(arr[i]%2==0)
                    {crrEven=crrEven+1;}
                else{crrOdd=crrOdd+1;}
            }
            a[2*t] = crrEven;
            a[1+(2*t)] = crrOdd;
            odd = odd + crrOdd;
            even = even +crrEven;
            t=t-1;
        }
        a[0] = even;
        a[1] = odd;
        sc.close();
        return a;
    }
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
        int a[] = new int[2+(2*t)];
        a = EvenOddArray(t);
        System.out.println("Total Even no.: "+a[0]);
        System.out.println("Total Odd no.: "+a[1]);
        System.out.println("---------------------");
        for(int i=t;i>0;--i){
            System.out.println("Even: "+a[2*i]+" Odd: "+a[(2*i)+1]);
        }
        

        sc.close();
	}
}