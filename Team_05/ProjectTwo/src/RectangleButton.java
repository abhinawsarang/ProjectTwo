
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Shape;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class RectangleButton extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Shape rectangle;
	private Color foreground = new Color(178, 255, 102);
	private Color background = new Color(0, 255, 255);
	private Dimension size;
	public RectangleButton(String label) {
		super(label);
		size = getPreferredSize();
		size.width = size.height = Math.max(size.width,size.height);
		setPreferredSize(size);
		setContentAreaFilled(false);
		setOpaque(false);
		setFocusPainted(false);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		rectangle = createRectangle();
	}

	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(background);
		} else {
			g.setColor(foreground);
		}
		Graphics2D g2d = (Graphics2D)g;
		g2d.fill(rectangle);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(this.getForeground());
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.draw(rectangle);
	}

	public boolean contains(int x, int y) {
		return rectangle.contains(x, y);
	}
	private Shape createRectangle() {
        Polygon p = new Polygon();
        p.addPoint(0, 0);
        p.addPoint(0, size.height - 30);
        p.addPoint(size.width - 1, size.height - 30);
        p.addPoint((size.width - 1), 0);
        
        return p;
	}
}
