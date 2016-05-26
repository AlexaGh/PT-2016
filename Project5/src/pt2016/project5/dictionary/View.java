package pt2016.project5.dictionary;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View extends JFrame {

	private JButton add = new JButton("Add");
	private JButton rem = new JButton("Remove");
	private JButton search = new JButton("Search");
	private JButton populate = new JButton("Populate");
	private JButton save = new JButton("Save");
	
	private JTextArea tarea = new JTextArea(30, 15);
	private JTextField tfield1 = new JTextField(10);
	private JTextField tfield2 = new JTextField(10);
	
	//private BorderDecorator tfield1 = new BorderDecorator(new JTextField());
	//private BorderDecorator tfield2 = new BorderDecorator(new JTextField());
	
	//private BorderDecorator tarea = new BorderDecorator(new JTextArea());
	
	ResizableDecorator button1 = new ResizableDecorator(new JButton("Button"));
	 
	private JPanel dic = new JPanel();
	private JPanel dic1 = new JPanel();
	private JPanel dic2 = new JPanel();
	private JPanel dic3 = new JPanel();


	public View() {

		setVisible(true);
		initialize();

	}

	public void initialize() {

		setTitle("Dictionary");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(420, 560));
		//setResizable(false);

		dic.setBackground(Color.WHITE);
		FlowLayout flow = new FlowLayout();
		//GridLayout grid = new GridLayout(1, 2);
		
		//setLayout(grid);
		
		//button1.setBounds(new Rectangle(10, 110, 120, 25));
		
		dic.setLayout(flow);
		this.add(dic);
		dic.add(dic1);
		  
		dic1.add(add);
		dic1.add(rem);
		dic1.add(search);
		dic1.add(populate);
		dic1.add(save);
		
		//dic1.add(button1);
		

		dic2.add(tfield1);
		dic2.add(tfield2);

		dic3.add(tarea);

		dic.add(dic2);
		dic.add(dic3);

		tarea.setEditable(false);
	}

	public JButton getAdd() {
		return add;
	}

	public void setAdd(JButton add) {
		this.add = add;
	}

	public JButton getRem() {
		return rem;
	}

	public void setRem(JButton rem) {
		this.rem = rem;
	}

	public JButton getSearch() {
		return search;
	}

	public void setSearch(JButton search) {
		this.search = search;
	}

	public JButton getPopulate() {
		return populate;
	}

	public void setPopulate(JButton populate) {
		this.populate = populate;
	}

	public JButton getSave() {
		return save;
	}

	public void setSave(JButton save) {
		this.save = save;
	}

	public JTextArea getTarea() {
		return tarea;
	}

	public void setTarea(JTextArea tarea) {
		this.tarea = tarea;
	}

	public JTextField getTfield1() {
		return tfield1;
	}

	public void setTfield1(JTextField tfield1) {
		this.tfield1 = tfield1;
	}

	public JTextField getTfield2() {
		return tfield2;
	}

	public void setTfield2(JTextField tfield2) {
		this.tfield2 = tfield2;
	}

	public JPanel getDic() {
		return dic;
	}

	public void setDic(JPanel dic) {
		this.dic = dic;
	}

	public JPanel getDic1() {
		return dic1;
	}

	public void setDic1(JPanel dic1) {
		this.dic1 = dic1;
	}

	public JPanel getDic2() {
		return dic2;
	}

	public void setDic2(JPanel dic2) {
		this.dic2 = dic2;
	}

	public JPanel getDic3() {
		return dic3;
	}

	public void setDic3(JPanel dic3) {
		this.dic3 = dic3;
	}
	
	public void setAddSynonymActionListener(ActionListener a) {
		add.addActionListener(a);
	}

	public void setRemoveSynonymActionListener(ActionListener a) {
		rem.addActionListener(a);
	}

	public void setSearchSynonymActionListener(ActionListener a) {
		search.addActionListener(a);
	}

	public void setPopulateDictionaryActionListener(ActionListener a) {
		populate.addActionListener(a);
	}

	public void setSaveDictionaryActionListener(ActionListener a) {
		save.addActionListener(a);
	}


}
