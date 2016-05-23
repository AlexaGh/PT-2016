import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SimulatorFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel simulatorFrame = new JPanel();
	private JPanel displayInfo;
	
	private JLabel labelDisplayPeakHour;
	private JLabel labelDisplatAvgWaitingTime;
	private JLabel labelDisplayAcgProcTime;
	
	public SimulatorFrame() {

		setSize(new Dimension(600, 600));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(2, 1));
		
		labelDisplayPeakHour = new JLabel("Average Processing time: ");
		labelDisplatAvgWaitingTime = new JLabel("Average Waiting time: ");
		labelDisplayAcgProcTime =  new JLabel("Average processing time: ");
		
		displayInfo = new JPanel();
		
		displayInfo.add(labelDisplatAvgWaitingTime);
		displayInfo.add(labelDisplayPeakHour);
		displayInfo.add(labelDisplayAcgProcTime);
		
		add(simulatorFrame);
		//add(displayInfo);
		
		setVisible(true);

	}

	void simulatorFr(Task[][] tasks, int nrOfServers) {
		
		simulatorFrame.removeAll();
		simulatorFrame.revalidate();
		
		//JList<Task> jtasks = new JList<Task>(tasks[0]);
		
		for(int i=0; i<nrOfServers; i++) {
			JScrollPane sp = new JScrollPane(new JList<Task>(tasks[i]));
			simulatorFrame.add(sp);
			
			simulatorFrame.repaint();
			simulatorFrame.revalidate();
		}
		
	}
	
	public void setLabelText1(String text){	
		this.labelDisplayPeakHour.setText(text);
	}
	
	public void setLabelText2(String text2){
		this.labelDisplatAvgWaitingTime.setText(text2);
	}
	
	public void setLabelText3(String text3){
		this.labelDisplayAcgProcTime.setText(text3);
	}
}
