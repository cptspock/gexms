package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

 class Entry implements Comparable {
	final int value;
	final int timestamp;
	final boolean isStartEvent;

	public Entry(int value, int timestamp, boolean isStartEvent) {
		this.value = value;
		this.timestamp = timestamp;
		this.isStartEvent= isStartEvent;
	}
	
	

	@Override
	public int compareTo(Object o) {
		Entry e = (Entry)o;
		if(timestamp != e.timestamp) return timestamp - e.timestamp;
		return isStartEvent ? -1 : 1; // start events must be smaller then end events
	}
}

public class Flow {
	
		int start;
		int end;
		int value;
		
		public Flow(int start, int end, int value) {
			this.start=start;
			this.end = end;
			this.value = value;
		}
	

	public static int maxFlow(List<Flow> flows) {
		PriorityQueue<Entry> queue = new PriorityQueue<>();

		// push all start and end times on queue
		for(Flow f : flows) {
			queue.add(new Entry( f.value, f.start, true));
			queue.add(new Entry( -f.value, f.end, false));
		}

		int maxSum = 0;
		int curSum = 0;
		// process queue
		while( !queue.isEmpty()) {
			Entry e = queue.poll();
			curSum = curSum + e.value;
			maxSum = Math.max(maxSum, curSum);	
		}
		return maxSum;
	}
	public static void main(String[] args) {
		List<Flow> flows = new ArrayList<>();
		flows.add(new Flow(0,10,100));
		flows.add(new Flow(10,15,300));
		flows.add(new Flow(16,20,400));
		flows.add(new Flow(5,15,200));
		
		System.out.print(Flow.maxFlow(flows));


	}

}
