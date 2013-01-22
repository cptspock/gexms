package threads;

public class ExampleThread extends Thread {
	private int delay;

	public ExampleThread(String label, int d) {
		// Give this particular thread a
		// name: "thread 'LABEL'".
		super("thread '" + label + "'");
		delay = d;
	}

	@SuppressWarnings("static-access")
	public void run() {
		for (int count = 1, row = 1; row < 20; row++, count++) {
			try {
				System.out.format("Line #%d from %s\n", count, getName());
				Thread.currentThread().sleep(delay);
			} catch (InterruptedException ie) {
				// This would be a surprise.
			}
		}
	}
}
