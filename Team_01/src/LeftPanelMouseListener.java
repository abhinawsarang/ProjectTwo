import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Adding mouse listeners for providing mouse click functionality
 * to add the shape to the right panel.
 * @author Parikshith Kedilaya Mallar
 * @version 1.0
 */
public class LeftPanelMouseListener extends MouseAdapter {
	
	private static boolean isTriangleClicked = false;
	private static boolean isSquareClicked = false;
	private static boolean isCircleClicked = false;
	
	public static boolean isTriangleClicked() {
		return isTriangleClicked;
	}

	public static void setTriangleClicked(boolean isTriangleClicked) {
		LeftPanelMouseListener.isTriangleClicked = isTriangleClicked;
	}

	public static boolean isSquareClicked() {
		return isSquareClicked;
	}

	public static void setSquareClicked(boolean isSquareClicked) {
		LeftPanelMouseListener.isSquareClicked = isSquareClicked;
	}

	public static boolean isCircleClicked() {
		return isCircleClicked;
	}

	public static void setCircleClicked(boolean isCircleClicked) {
		LeftPanelMouseListener.isCircleClicked = isCircleClicked;
	}
	
	/**
	 * Overridden method to add mouse click event handler.
	 * Used to track which shape has been clicked on the left panel,
	 * so that only that shape can be created on the right panel.
	 */
	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
		try {
			for (int i = Frame.getShapes().size() - 1; i >= 0; i--) {
				if (Frame.getShapes().get(i).contains(mouseEvent.getPoint())) {
					markIsClickedTrue(Frame.getShapesMap().get(Frame.getShapes().get(i)));
					return;
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

    /**
	 * @param shape
	 * Instantiates or uses the created instance of different shapes' class
	 * and sets isClicked value as true for the shape which was clicked.
	 */
	public static void markIsClickedTrue(ShapesEnum shape) {
		try {
			if (ShapesEnum.SQUARE == shape) {
				setTriangleClicked(false);
				setSquareClicked(true);
				setCircleClicked(false);
			}
			if (ShapesEnum.TRIANGLE == shape) {
				setTriangleClicked(true);
				setSquareClicked(false);
				setCircleClicked(false);
			}
			if (ShapesEnum.CIRCLE == shape) {
				setTriangleClicked(false);
				setSquareClicked(false);
				setCircleClicked(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return
	 * returns which shape was clicked.
	 */
	public static ShapesEnum getSelectedShape() {
		if (isSquareClicked()) {
			return ShapesEnum.SQUARE;
		} else if (isTriangleClicked()) {
			return ShapesEnum.TRIANGLE;
		} else if (isCircleClicked()) {
			return ShapesEnum.CIRCLE;
		} else {
			return null;
		}
	}
	
}
