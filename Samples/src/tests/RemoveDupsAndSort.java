package tests;

/**
 * Replace duplicates in array with 0's and print array in sorted order
 *
 */
public class RemoveDupsAndSort {

	public static void main(String [] args) {

        int[] a = new int[] { 7,1,6,1,22,1,9,7,1 };
        int[] output = new int[a.length];
        int zeroSize =0;
            for(int i= 0; i < a.length; i++) {
                for(int j = i+1; j < a.length; j++) {
                    if(a[i] > a[j]) {
                        int tmp = a[i];
                        a[i] = a[j];
                        a[j] = tmp;
                    }
                   if(a[i] == a[j] && a[i]!=0) {
                        a[i] = 0;
                        i = 0;
                        break;
                    }
                }
            }
        for(int x=0; x < a.length; x++) {
            System.out.println(a[x]);
        }
    }
}
