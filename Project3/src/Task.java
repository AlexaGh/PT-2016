
public class Task {

	private int arrivalTime;
	private int processorTime;
	
	public Task() {

	}
	
	public Task(int arrivalTime, int processorTime) {
		this.arrivalTime = arrivalTime;
		this.processorTime = processorTime;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getProcessorTime() {
		return processorTime;
	}

	public void setProcessorTrue(int processorTrue) {
		this.processorTime = processorTrue;
	}


	@Override
	public String toString() {
		String result = "Task: " + Integer.toString(arrivalTime);
		result = result + " " + Integer.toString(processorTime);
		return result;
	}
}
