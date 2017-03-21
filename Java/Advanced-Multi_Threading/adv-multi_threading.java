/** Notes for Adv Thread Handling -- Rafat**/

/** running a program in a single thread can sometimes take too much time
 .one solution is to run more than one function in parallel and synchronize 
 the threads.**/

// there are two ways to create a thread
// extend Thread or implement Runnable.

// how to use extends
public class BattingStatisticsThread extends Thread{
	
	public void run(){
		for(int i = 0; i < 1000; i++){
			System.out.println(i);
		}
	}
}

BattingStatisticsThread battingStatThread = new BattingStatisticsThread();
battingStatThread.start();
d
BattingStatisticsThread battingStatThread = new BattingStatisticsThread();
Thread thread1 = new Thread(battingStatThread);
thread1.start();


/**
states of each thread:
1. New:  Newly created
2. Runnable: Created and able to Run
3. Running: Currently Running
4. Blocked/Waiting: Waiting for resource to finish
5. Terminated/Dead: Finished and terminated


Thread Priority
priority of a java thread determines how much process time is scheduled for each thread.
The higher the priority the more process time the thread will accumulate.

default thread priority in java is 5.



**/

ThreadExample thread = new ThreadExample();
thread.setPriority(8);


/** ExecutorService interface is a new way of executing 
tasks asynchronously in the background. An ExecutorService similar to a thread pool**/


// create thread pool that reuses a fixed number of threads
// operating off a shared unbounded queue. At any point, the parameter.
// specifies the most threads that will be active processing tasks.
ExecutorService executorService = Executors.newSingleThreadExecutor();

executorService.execute(new Runnable(){
	public void run() {
		System.out.println("From ExecutorService");
	}
});
System.out.println("End of Main");

executorService.shutdown();

// create multiple thread

ExecutorService executorService2 = Executors.newFixedThreadPool(10);

// Creates a thread pool that can schedule commands to run after a given
// delay, or to execute periodically.

ExecutorService executorService3 = Executors.newScheduledThreadPool(10);

// When using executors service you can check to see when the task has completed

Future future = executorService1.submit(new Runnable(){
	public void run(){
		System.out.println("From executorService1");
	});
future.get(); // returns null when finshed

// What is Callable? How do you execute a Callable from ExecutionService?
// Callable interface has a return type of string to return a value when completed

Future futureFromCallable = executorService1.submit(new Callable(){
	public String call() throws Exception{
		return "RESULT";
	}
});
System.out.println("futurefromCallable.get() = " +futureFromCallable.get());
}

/** Im a multiple thread scenario, if the method below were to be called
twice in two different threads , there is a possiblity for override between threads
consider example where sumValues used in thread 1 has completed assigning values
for cell1 and cell 2,  while sumValues in Thread 2 , assigned the value in cell 3.
in this case, return for sumValues will return sum from two different threads

**/


private int sumValues(int a1, int a2, int a3){
	
	cell1 = a1;
	sleepForSomeTime();
	cell2 = a2;
	sleepForSomeTime();
	cell3 = a3;
	sleepForSomeTime();

return cell1 + cell2 + cell3;
}

// Synchronized -- prevents multiple threads from executing the same method.
// different thread will only be to access synchronized methods when one thread is finished at a time.

synchronized int sumValues(int a1, int a2, int a3){...}

void synchronizedExample(){
	synchronized (this){
		// synchronized lines of code
	}
}

synchronized static int getCount(){
	return count;
}


// what if you want to run the next line only if the 
// previous thread has completed?

thread1.start();
thread2.start();
thread1.join();  // wait for thread 1 to complete

thread3.start();

// join -- wait for thread to complete before execution.



// if thread does not complete within xx miliseconds then proceed

thread1.join(1000);

// thread.yield()  -- dont mind using other threads for execution. Opposite of join
thread.yield(); // -- running to runnable
// thread.yield()  will make thread from running to runnable.
//thread.sleep() will sleep the thread in miliseconds
thread.sleep(1000);
/** deadlock is when 2 threads are mutually waiting for each other
to complete. thread 1 is waiting for thread 2 and thread 3 is waiting for blah blah 
 **/

// inter-thread communication ... wait(), notify(), notifyAll().

synchronized(thread){
	thread.start();
	thread.wait();
}

synchronized(this){
	calculateSumUpToMillion();
	notify();
}

// notifyAll method is used if more than one thread is waiting for an object
// usually wait method is called with notify to stop and resume thread.


class Calculator extends Thread{
	long sumUptoMillion;
	long sumUpToTenMillion;
}


class Calculator extends Thread{
	long sum;

	public void run(){
		synchronized(this){
			for(int i = 0; i < 1000000; i++){
				sum +=i;
			}
			notify();
		}
	}
}

public class ThreadWaitAndNotify{

	public static void main(String[] args){
		Calculator thread = new Calculator();
		thread.start();
		synchronized(thread){
			try{
				thread.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		// without thread.wait(); print will be 0, 
		//because this execution will not wait for thread.run to
		// complete before printing statement
		
		System.out.println(thread.sum);

	}
}