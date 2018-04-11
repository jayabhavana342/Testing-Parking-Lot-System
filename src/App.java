//package slots.parking.txstate.edu;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 *
 * @author Mehak Agarwal
 *
 */

public class App {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setMaximized(true);
		shell.open();

		Image image = new Image(display, "images/layout.png");
		GC gc = new GC(shell);
		gc.drawImage(image, 0, 0);

		// Image carimp = new Image(display,"car.jpg");
		Image vac_a = new Image(display, "images/vac_a.jpg");
		for (int i = 1; i < 21; i++) {
			gc.drawImage(vac_a, 40, 20 * i + 77);
		}

		Image vac_b = new Image(display, "images/vac_b.jpg");
		for (int i = 1; i < 49; i++) {
			gc.drawImage(vac_b, 87 + 20 * i, 30);
		}

		for (int i = 1; i < 19; i++) {
			gc.drawImage(vac_a, 180, 20 * i + 130);
		}

		for (int i = 1; i < 19; i++) {
			gc.drawImage(vac_a, 445, 20 * i + 130);
		}

		for (int i = 1; i < 19; i++) {
			gc.drawImage(vac_a, 595, 20 * i + 130);
		}

		for (int i = 1; i < 19; i++) {
			gc.drawImage(vac_a, 656, 20 * i + 130);
		}

		for (int i = 1; i < 19; i++) {
			gc.drawImage(vac_a, 815, 20 * i + 130);
		}

		for (int i = 1; i < 19; i++) {
			gc.drawImage(vac_a, 877, 20 * i + 130);
		}

		for (int i = 1; i < 19; i++) {
			gc.drawImage(vac_a, 1027, 20 * i + 130);
		}
		Image bike_a = new Image(display, "images/bike_a.jpg");
		for (int i = 1; i < 21; i++) {
			gc.drawImage(bike_a, 242, 18 * i + 134);
		}

		for (int i = 1; i < 21; i++) {
			gc.drawImage(bike_a, 395, 18 * i + 134);
		}

		Image vac_c = new Image(display, "images/vac_c.jpg");
		for (int i = 1; i < 7; i++) {
			gc.drawImage(vac_c, 18 + i * 140, 600);
		}

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

}
