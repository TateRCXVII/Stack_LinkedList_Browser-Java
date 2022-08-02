package assign06;

import java.util.LinkedList;
import java.util.Random;

public class StackTimer {
	private static Random rand;

	public static void main(String[] args) {
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		long startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) { // empty block
		}

		// Time adding N values to different kinds of queues
		for (int N = 1000; N <= 15000; N += 1000) {
			timeAddN(N);
		}

		// Time adding then removing N values to different kinds of queues
//		for(int N = 1000; N <= 15000; N += 1000)
//		{
//			timeRemoveN(N);
//		}

//		for(int N = 1000; N <= 15000; N += 1000)
//		{
//			timePeek(N);
//		}

	}

	private static void timeAddN(int N) {
		long startTime, midpointTime, stopTime;
		int timesToLoop = 100000;

		// Generate random input before starting the timer
		int[] testVals = new int[N];
		for (int i = 0; i < N; i++)
			testVals[i] = randomInteger();

		Stack<Integer> q;

		startTime = System.nanoTime();

		for (int i = 0; i < timesToLoop; i++) {
			q = new LinkedListStack<Integer>();
			//q = new ArrayStack<Integer>();
			for (int j : testVals)
				q.push(j);
		}

		midpointTime = System.nanoTime();

		// Run an loop to capture the cost of the overhead
		for (long i = 0; i < timesToLoop; i++) {
			q = new LinkedListStack<Integer>();
			//q = new ArrayStack<Integer>();
			for (int j : testVals) {
			}
		}

		stopTime = System.nanoTime();

		// Subtract the cost of running the loop
		// from the cost of running the loop plus the real work.
		// Average it over the number of runs.
		double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / timesToLoop;

		System.out.println(N + "\t" + averageTime);
	}

	private static void timeRemoveN(int N) {
		long startTime, midpointTime, stopTime;
		int timesToLoop = 75000;
		// int timesToLoop = 500;

		// Generate random input before starting the timer
		int[] testVals = new int[N];
		for (int i = 0; i < N; i++)
			testVals[i] = randomInteger();

		Stack<Integer> q;

		startTime = System.nanoTime();

		for (int i = 0; i < timesToLoop; i++) {
			q = new LinkedListStack<Integer>();
			//q = new ArrayStack<Integer>();
			for (int j : testVals)
				q.push(j);
			for (int j = 0; j < N; j++)
				q.pop();
		}

		midpointTime = System.nanoTime();

		// Run an loop to capture the cost of the overhead
		for (long i = 0; i < timesToLoop; i++) {
			//q = new LinkedListStack<Integer>();
			 q = new ArrayStack<Integer>();
			for (int j : testVals) {
				q.push(j); // subtract the offer time since we are timing poll
			}
			for (int j = 0; j < N; j++) {
			}
		}

		stopTime = System.nanoTime();

		// Subtract the cost of running the loop
		// from the cost of running the loop plus the real work.
		// Average it over the number of runs.
		double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / timesToLoop;

		System.out.println(N + "\t" + averageTime);
	}
	
	private static void timePeek(int N) {
		long startTime, midpointTime, stopTime;
		int timesToLoop = 100000;
		// int timesToLoop = 500;

		// Generate random input before starting the timer
		int[] testVals = new int[N];
		for (int i = 0; i < N; i++)
			testVals[i] = randomInteger();

		Stack<Integer> q;

		startTime = System.nanoTime();

		for (int i = 0; i < timesToLoop; i++) {
			q = new LinkedListStack<Integer>();
			//q = new ArrayStack<Integer>();
			for (int j : testVals)
				q.push(j);
			//for (int j = 0; j < N; j++)
				q.peek();
		}

		midpointTime = System.nanoTime();

		// Run an loop to capture the cost of the overhead
		for (long i = 0; i < timesToLoop; i++) {
			q = new LinkedListStack<Integer>();
			 //q = new ArrayStack<Integer>();
			for (int j : testVals) {
				q.push(j); // subtract the offer time since we are timing poll
			}
			for (int j = 0; j < N; j++) {
			}
		}

		stopTime = System.nanoTime();

		// Subtract the cost of running the loop
		// from the cost of running the loop plus the real work.
		// Average it over the number of runs.
		double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / timesToLoop;

		System.out.println(N + "\t" + averageTime);
	}

	public static Integer randomInteger() {
		return rand.nextInt();
	}
}
