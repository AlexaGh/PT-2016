import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Simulator implements Runnable {

	//int finishTime = 45; // JodaTime

	//int minProcessTime = 4;
	//int maxProcessTime = 7;
	
	public static int minProcessTime;
	public static int maxProcessTime;
	public static int finishTime;

	int currentTime;

	public String displayAveragepProcTime;
	public String displayaAverageWaitingTime;

	Simulator sim;

	Scheduler s = new Scheduler(this);
	SimulatorFrame sf = new SimulatorFrame();

	@Override
	public void run() {

		// generez task urile
		currentTime = 0;
		while (currentTime < finishTime) {
			currentTime++; // +5

			int processTime = (int) (Math.random() * (maxProcessTime - minProcessTime) + minProcessTime);

			Task t = new Task(currentTime, processTime);

			s.dispatchTaskOnServer(t);
			sf.simulatorFr(s.getTasksFromScheduler(), s.sizeOfServer());
			s.addNewServer();

			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		while (!s.isDone()) {

			sf.simulatorFr(s.getTasksFromScheduler(), s.sizeOfServer());
			currentTime++;
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		sf.setLabelText1("Average waiting time:  " + s.computeAverageWaitingTime());
		sf.setLabelText2("Peak Hour: " + s.computePeakHour());
		sf.setLabelText3("Average process time: " + s.computeAverageProcTimeTime());

		sf.simulatorFr(s.getTasksFromScheduler(), s.sizeOfServer());

	}

	int getCurrentTime() {
		return currentTime;
	}

	public static void main(String[] args) throws IOException {

		String string = "";
		String file = "textFile.txt";

		// reading
		/*try {
			
			InputStream ips = new FileInputStream(file);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String line;
			
			//ArrayList<String> lines = new ArrayList<String>();
			
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				
				minProcTime2 = Integer.parseInt(line);
				minProcTime2 = Integer.parseInt(line);
				minProcTime2 = Integer.parseInt(line);
				minProcTime2 = Integer.parseInt(line);
				minProcTime2 = Integer.parseInt(line);
				
				string += line + "\n";
			}
			br.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}*/
		
		FileReader fr = new FileReader("C:/Users/Alexa/Desktop/GIT Repositories/PT-2016/Project3/textFile.txt");
		BufferedReader textReader = new BufferedReader(fr);
		
		int numberOfLines = 5;
		String[] textData = new String[numberOfLines];
		
		for(int i = 0; i<numberOfLines; i++){
			textData[i] = textReader.readLine();
		}
		
		minProcessTime = Integer.parseInt(textData[2]);
		maxProcessTime = Integer.parseInt(textData[3]);
		finishTime = Integer.parseInt(textData[4]);;

		//System.out.println("minProcTime: " + finishTime);
		
		Simulator size = new Simulator();
		Thread th = new Thread(size);
		th.start();

		

	}

}
