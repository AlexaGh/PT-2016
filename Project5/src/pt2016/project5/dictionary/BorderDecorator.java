package pt2016.project5.dictionary;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JComponent;

public class BorderDecorator extends JComponent {

	// decorated component
	protected JComponent child;

	public BorderDecorator(JComponent component) {
		child = component;
		this.setLayout(new BorderLayout());
		this.add(child);
	}

	public void paint(Graphics g) {
		super.paint(g);
		int height = this.getHeight();
		int width = this.getWidth();
		g.drawRect(0, 0, width - 1, height - 1);
	}

}
