import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RightPanel extends JPanel{
	private Hashtable<Integer, JButton> shapes;
	private Frame frame;
	
	public RightPanel() {
		shapes = new Hashtable<Integer, JButton>();
		
	}
	public void AddRound() {
		System.out.println("Adding Round");
		RoundButton round = new RoundButton("");
		round.addMouseListener(new MouseAdapter() {});
		shapes.put(round.hashCode(),round);
		this.add(round);
		frame.contentRepaint();
		System.out.println("AddedRound");
	}
	
	public void AddTriangle()
	{
		TriangleButton triangle = new TriangleButton("");
		triangle.addMouseListener(new MouseAdapter() {});
		shapes.put(triangle.hashCode(),triangle);
		this.add(triangle);
	}
	
	public void AddRectangle()
	{
		RectangleButton rectangle = new RectangleButton("");
		rectangle.addMouseListener(new MouseAdapter() {});
		shapes.put(rectangle.hashCode(),rectangle);
		this.add(rectangle);
	}
	
	public void DeleteShape(int hashCode)
	{
		this.remove(shapes.get(hashCode));
		shapes.remove(hashCode);
	}
	
	public void SetFrame(Frame frame)
	{
		this.frame = frame;
	}
}
