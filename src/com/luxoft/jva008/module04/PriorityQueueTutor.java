package com.luxoft.jva008.module04;

import java.util.concurrent.PriorityBlockingQueue;

/*
 * Implement the compareTo() method in order. Print orders in ReadOrderThread so that order with priority==true is the first.
 */

public class PriorityQueueTutor {
    static StringBuffer buf = new StringBuffer();

	PriorityBlockingQueue<Order> orderQueue = new PriorityBlockingQueue<>();
	
	class Order implements Comparable<Order> {
		public String title;
		public boolean priority;

		@Override
		public String toString() {
			return "Order " + title + ", priority=" + priority;
		}

		public Order(String title, boolean priority) {
			this.title = title;
			this.priority = priority;
		}

		@Override
		public int compareTo(Order o) {
			// Higher priority (true) should come before lower priority (false)
			if (this.priority == o.priority) {
				// fallback to title to keep ordering deterministic
				return this.title.compareTo(o.title);
			}
			return this.priority ? -1 : 1;
		}
		
	}
	
	public void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	class AddOrderThread implements Runnable {
		@Override
		public void run() {
			orderQueue.put(new Order("books",false));
			sleep(10);
			orderQueue.put(new Order("table",false));
			sleep(10);
			orderQueue.put(new Order("computer",true));
			sleep(10);
			orderQueue.put(new Order("dog",false));
		}
	}
	
	class ReadOrderThread implements Runnable {
		int orderNum = 0;
		@Override
		public void run() {
			while(orderNum<4) {
				try {
					Order order = orderQueue.take();
					// check that first taken order has priority==true 
					if (order.priority && orderNum==0) { 
						priorityAhead = true;
					}
					log(order.toString());
					orderNum++;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
    static void log(String s) {
        buf.append(s + "\n");
    }
	
	boolean priorityAhead = false;
	
	// Entry point to run without JUnit
	public static void main(String[] args) throws Exception {
		new PriorityQueueTutor().runDemo();
	}

	public void runDemo() throws Exception {
		Thread addOrderThread = new Thread(new AddOrderThread());
		Thread readOrderThread = new Thread(new ReadOrderThread());
		addOrderThread.start();
		// Wait until enough items are present so that the priority order is available
		// This avoids taking the very first non-priority element before the priority one arrives
		while (orderQueue.size() < 3) {
			Thread.yield();
		}
		readOrderThread.start();
		
		addOrderThread.join();
		readOrderThread.join();
		
		if (!priorityAhead) {
			throw new IllegalStateException("Order marked as priority should be the first");
		}
	}


}
