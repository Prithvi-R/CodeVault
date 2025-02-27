import java.util.*;

public class Sorted_merge {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		// Scanner sd = new Scanner(System.in);
		int[] arr1 = new int[5];
		int[] arr2 = new int[5];
		int[] mergedArr = new int[10];
		for (int i = 0; i < 5; i++) {
			arr1[i] = sc.nextInt();
		}
		for (int i = 0; i < 5; i++) {
			arr2[i] = sc.nextInt();
		}
		int j=0,k=0;
		for(int i = 0; i < 10; i++){
			if(j < 5 && arr1[j] <= arr2[k]){
				mergedArr[i] = arr1[j];
				j++;
			}else{
				mergedArr[i] = arr2[k];
				k++;
			}
		}
		for(int i = 0; i < 10; i++){
			System.out.print(mergedArr[i]+" ");
		}
        sc.close();
	}
}