import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {

	private BlockingQueue<Task> bq;
	private AtomicInteger waitingTime;

	private volatile boolean running;

	private double procTime;
	private double sum;
	private int[] peakHours;

	private int noOfTasks = 0;

	private Scheduler sch;

	public Server(Scheduler sch) {
		bq = new LinkedBlockingQueue<>();
		waitingTime = new AtomicInteger(0);
		this.sch = sch;
		running = true;
		peakHours = new int[2048];
	}

	Task[] getTasks() {

		Task[] tasks = new Task[bq.size()];
		bq.toArray(tasks);
		return tasks;
	}

	@Override
	public void run() {
		while (running) {

			Task t;
			try {
				t = bq.take();
				Thread.sleep(t.getProcessorTime() * 250);
				waitingTime.addAndGet((-1) * t.getProcessorTime());

				// sum of waiting time(s)
				sum += sch.createdSimulator.getCurrentTime() - t.getArrivalTime();
				procTime += t.getProcessorTime();

				noOfTasks++;
				peakHours[sch.createdSimulator.getCurrentTime()]++;

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void stopServer() {
		running = false;
	}

	public void addTask(Task t) {
		bq.add(t);
		waitingTime.addAndGet(t.getProcessorTime());
	}

	boolean isEmpty() {
		return bq.isEmpty();
	}

	public BlockingQueue<Task> getBq() {
		return bq;
	}

	public AtomicInteger getWaitingTime() {
		return waitingTime;
	}

	public int getWaitingTimeInt() {
		return waitingTime.intValue();
	}

	double getSum() {
		return sum;
	}

	public double getProcTime() {
		return procTime;
	}

	public int[] getPeakHours() {
		return peakHours;
	}

	public int getHowManyTasks() {
		return noOfTasks;
	}

	public int getTime2() {
		return getWaitingTime().intValue();
	}

}
