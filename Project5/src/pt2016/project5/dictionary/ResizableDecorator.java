package pt2016.project5.dictionary;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;

public class ResizableDecorator extends JComponent {

	// decorated component
	protected JComponent child;
	private JButton button = new JButton();
	boolean minimum = false;
	private Rectangle r;

	public ResizableDecorator(JComponent component) {
		child = component;
		this.setLayout(new BorderLayout());
		this.add(child);
		child.setLayout(null);
		button.setBounds(0, 0, 8, 8);
		child.add(button);
		button.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button_actionPerformed(e);
			}
		});
	}

	void button_actionPerformed(ActionEvent e) {
		if (minimum) {
			this.setBounds(r);
		} else {
			r = this.getBounds();
			this.setBounds(r.x, r.y, 8, 8);
		}
		minimum = !minimum;
	}

}
