package tests;

public class SleepMessages {
    public static void main(String args[]) {
        String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
        };

        for (int i = 0; i < importantInfo.length; i++) {
            //Pause for 4 seconds
            try {
            	if (!Thread.currentThread().isInterrupted())
            		Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            //Print a message
            System.out.println(importantInfo[i]);
        }
    }
}