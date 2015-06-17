package tests;

public class RemoveDuplicates {
	public static void main(String... args) {
		// remove duplicate elements logic
        int[] a = {4, 3, 6, 4, 9, 6, 4, 3};
        int length = a.length;

     // sorting elements in the array logic
        for (int i = 0; i < length; i++) 
        {
            for (int j = 0; j < length - 1; j++) 
            {
                if (a[j] > a[j + 1])
                {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]);
        }

        int k = 0;
        a[k] = a[0];
        for (int i = 1; i < a.length; i++)
        {
            if (a[k] != a[i])
            {
                k++;
                a[k]=a[i];

            }
            else {
            	System.out.println("duplicate: " + a[k]);
            }

        }
        System.out.println("k=" +k);
        
        for (int i = k+1; i < length; i++){
        	a[i] = Integer.MIN_VALUE;
         }
        
        for(int i=0;i<length;i++)
        {
            System.out.println(a[i]);
        }
        

	}
	
	
}
