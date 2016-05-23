import java.util.ArrayList;
import java.util.Comparator;

public class Scheduler { // decide la care coada

	public ArrayList<Server> servers; /* = new ArrayList<Server>(); */
	// public Server server;

	public Simulator createdSimulator;

	int minNoOfServers = 1;
	int maxNoOfServers = 4;

	//threshold
	int maxWaitingTime = 20;

	public Scheduler(Simulator createdSimulator) {

		this.createdSimulator = createdSimulator;

		servers = new ArrayList<Server>();
		for (int i = 0; i < minNoOfServers; i++) {
			Server server = new Server(this);
			servers.add(server);
			Thread t = new Thread(servers.get(0));
			t.start();
		}

	}

	public void addNewServer() {

		boolean addNewServer = false;
		for (Server s : servers) {
			if (s.getWaitingTimeInt() > maxWaitingTime) {
				addNewServer = true;
			}
		}
		if (servers.size() >= maxNoOfServers)
			addNewServer = false;
		if (addNewServer) {
			Server server = new Server(this);
			servers.add(server);
			Thread thread = new Thread(server);
			thread.start();
		}
	}

	public void dispatchTaskOnServer(Task t) {

		if (servers.size() == 0) {
			servers.add(new Server(this));
		}

		servers.sort(new Comparator<Server>() {

			@Override
			public int compare(Server arg0, Server arg1) {
				return Integer.compare(arg0.getWaitingTimeInt(), arg1.getWaitingTimeInt());
			}

		});
		// task is always added to the server which has the smallest
		// waiting time up until that point
		servers.get(0).addTask(t);

		// removeUnneededServers();
	}

	/*public void removeUnneededServers() {
		if (sizeOfServer() > minNoOfServers) {
			ArrayList<Server> serversToRemove = new ArrayList<>();
			for (Server s : servers) {
				// if(s.isEmpty())
				if (s.getWaitingTimeInt() == 0) {
					serversToRemove.add(s);
				}
			}
			for (Server s : serversToRemove) {
				servers.remove(s);
			}
		}
	}*/

	public int sizeOfServer() {
		return servers.size();
	}

	double computePeakHour() {
		double max = 0;
		int[] peekHours = new int[2048];
		for (Server s : servers) {
			int[] serverPeekHours = s.getPeakHours();
			for (int i = 0; i < 2048; i++) {
				peekHours[i] += serverPeekHours[i];
			}
		}

		for (int i = 0; i < 2048; i++) {
			if (max < peekHours[i]) {
				max = peekHours[i];
			}
		}
		return max;
	}

	double computeAverageWaitingTime() {
		
		double allServers = 0;
		int allTasks = 0;
		for (Server s : servers) {
			allServers += s.getSum();
			allTasks += s.getHowManyTasks();
		}
		return allServers / allTasks;
	}

	double computeAverageProcTimeTime() {
		
		double allServers = 0;
		int allTasks = 0;
		
		for (Server s : servers) {
			allServers += s.getProcTime();
			allTasks += s.getHowManyTasks();
		}

		return allServers / allTasks;
	}

	public Task[][] getTasksFromScheduler() {

		Task[][] tasks = new Task[servers.size()][];// = new Task[][];// =
													// server.getTasks();
		for (int i = 0; i < servers.size(); i++) {
			tasks[i] = servers.get(i).getTasks();
		}

		return tasks;
	}

	boolean isDone() {
		boolean isDone = true;

		for (Server s : servers) {
			if (!s.isEmpty())
				isDone = false;
		}
		return isDone;
	}

	@Override
	public String toString() {
		String result = "Average arrival time: " + Double.toString(computeAverageWaitingTime());
		result = result + " Peak hour: " + Double.toString(computePeakHour());
		return result;
	}

}
