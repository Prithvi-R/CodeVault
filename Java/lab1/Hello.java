import java.util.*;

public class Hello{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i=0;i<10;i++){
            arr[i] = sc.nextInt();
        }
        int max = arr[0];
		int index = -1;
		for(int i = 1;i<10;i++){
			if(arr[i]>max){
				max = arr[i];
				index = i;
				}
			}
		System.out.println("Maximum: " + max);
		arr[index] = -191312;
		max = arr[0];
		for(int i = 1;i<10;i++){
			if(arr[i]>max){
				max = arr[i];
				}
			}
		System.out.println("Second Maximum:" + max);
		sc.close();
    }
}