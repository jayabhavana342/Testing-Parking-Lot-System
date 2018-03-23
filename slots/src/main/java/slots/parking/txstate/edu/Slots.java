package slots.parking.txstate.edu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import slots.parking.txstate.edu.SlotMain.VehicleType;

/**
 * 
 * @author Mehak Agarwal
 *
 */

public class Slots {

	private static Display display;
	private static Shell shell;
	private static Image layout;
	private static GC gc;
	private static Map<Integer, String> bookingMap;// = new HashMap<Integer,String>();
	private static int level=1;
	private static Label lbl;

	public static void main(String op) {
		init();

		if (op != null && SlotMain.SHOW_ALL_SLOTS_AVAILABLE.equals(op))
			showAllSlotsAvailable(gc, display, shell);

		if (op != null && SlotMain.SHOW_CAR_SLOTS_AVAILABLE.equals(op)) {
			vac_car_a(gc, display);
			vac_car_b(gc, display);
		}

		if (op != null && SlotMain.SHOW_BIKE_SLOTS_AVAILABLE.equals(op))
			vac_bike(gc, display);

		if (op != null && SlotMain.SHOW_BUS_SLOTS_AVAILABLE.equals(op))
			vac_bus(gc, display);

		destroy();
	}

	private static void destroy() {
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	private static void init() {
		initMap();
		
		display = new Display();
		shell = new Shell(display);
		shell.setMaximized(true);
		shell.open();

		layout = new Image(display, "images/layout.png");
		Image loc = new Image(display, "images/location.gif");
		Image updown = new Image(display, "images/updown.png");
		gc = new GC(shell);
		gc.drawImage(layout, 0, 0);
		gc.drawImage(loc, 60, 580);
		gc.drawImage(updown, 1260, 460);
		
		lbl=new org.eclipse.swt.widgets.Label(shell, SWT.None);
		lbl.setBounds(1210, 20, 500, 100);
		org.eclipse.swt.graphics.Font font=new Font(display,"Arial", 13, SWT.BOLD);
		lbl.setFont(font);
		lbl.setForeground(new Color(display, 150, 50, 0));
	}

	private static void initMap() {
		File file = new File("map");
		FileInputStream f;
		ObjectInputStream s = null;
		try {
			f = new FileInputStream(file);

			s = new ObjectInputStream(f);

			bookingMap = (Map<Integer, String>) s.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			bookingMap = new HashMap<Integer, String>();
			bookingMap.put(111, "bike1");
			bookingMap.put(115, "bike2");
			bookingMap.put(1128, "bike2");
			
			bookingMap.put(1210, "car1");
			bookingMap.put(1215, "car2");
			bookingMap.put(1268, "car3");
			bookingMap.put(12195, "car4");
			
			bookingMap.put(132, "bus1");
			bookingMap.put(135, "bus2");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (s != null)
			try {
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

			}
	}

	private static void showAllSlotsAvailable(GC gc, Display display, Shell shell) {

		vac_car_a(gc, display);

		vac_car_b(gc, display);

		vac_bike(gc, display);

		vac_bus(gc, display);
	}

	private static void vac_bus(GC gc, Display display) {
		Image vac_c = new Image(display, "images/vac_c.jpg");
		for (int i = 1; i < 7; i++) {
			gc.drawImage(vac_c, 18 + i * 140, 600);
		}
	}

	private static void vac_bike(GC gc, Display display) {
		Image bike_a = new Image(display, "images/bike_a.jpg");
		for (int i = 1; i < 21; i++) {
			gc.drawImage(bike_a, 242, 18 * i + 134);
		}

		for (int i = 1; i < 21; i++) {
			gc.drawImage(bike_a, 395, 18 * i + 134);
		}
	}

	private static void vac_car_b(GC gc, Display display) {
		Image vac_b = new Image(display, "images/vac_b.jpg");
		for (int i = 1; i < 49; i++) {
			gc.drawImage(vac_b, 87 + 20 * i, 30);
		}
	}

	private static void vac_car_a(GC gc, Display display) {
		// Image carimp = new Image(display,"car.jpg");
		Image vac_a = new Image(display, "images/vac_a.jpg");
		for (int i = 1; i < 21; i++) {
			gc.drawImage(vac_a, 40, 20 * i + 77);
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
	}

	public static void selectSlot(VehicleType vt, String vehicle_number) {
		init();

		switch (vt) {

		case MOTORCYCLE:
			select_bike(gc, display);
			break;
			
		case CAR:
			select_car(gc, display,vehicle_number);
			break;

		case BUS:
			select_bus(gc, display);
			
			break;

		}

		destroy();
	}

	private static void select_bus(GC gc2, Display display2) {
		Image vac_c = new Image(display, "images/vac_c.jpg");
		Image bus = new Image(display, "images/bus.jpg");
		for (int i = 1; i < 7; i++) {
			String key = level+"3"+i;
			if (bookingMap.get(Integer.parseInt(key))==null) {
				gc.drawImage(vac_c, 18 + i * 140, 600);
			}else {
				gc.drawImage(bus, 18 + i * 140, 600);
			}
			
		}
	}

	private static void select_bike(GC gc, Display display) {
		Image bike_a = new Image(display, "images/bike_a.jpg");
		Image bike_booked = new Image(display, "images/bike_booked.jpg");
		for (int i = 1; i < 21; i++) {
			String key = level+"1"+i;
			if (bookingMap.get(Integer.parseInt(key))==null) {
				gc.drawImage(bike_a, 242, 18 * i + 134);
			}else {
				gc.drawImage(bike_booked, 242, 18 * i + 134);
			}

		}

		for (int i = 1; i < 21; i++) {
			String key =level+"1"+(i+20);
			if(bookingMap.get(Integer.parseInt(key))==null) {
				gc.drawImage(bike_a, 395, 18 * i + 134);
			}else {
				gc.drawImage(bike_booked, 395, 18 * i + 134);
			}
		}
	}
	
	private static void select_car(GC gc, Display display, final String vehicle_number) {
		
		
		Image vac_b = new Image(display, "images/vac_b.jpg");
		final Image car_b = new Image(display, "images/car_b.jpg");
		final Image car_b_selected = new Image(display, "images/car_b_selected.jpg");
		
		
		for (int i = 1; i < 49; i++) {
			final String key = level+"2"+i;
			if (bookingMap.get(Integer.parseInt(key))==null) {
				final Button button = new Button(shell, SWT.PUSH);
			    button.setImage(vac_b);
			    //button.setText("car1");
			    button.setBounds(87 + 20 * i, 30,15,48);
			    button.setToolTipText("Select Slot: "+key );
			    button.addSelectionListener(new SelectionAdapter() {
			    	@Override
			    	public void widgetSelected(SelectionEvent e) {
			    		// TODO Auto-generated method stub
			    		super.widgetSelected(e);
			    		button.setImage(car_b_selected);
			    	
			    		System.out.println(key+"selected");
			    		 bookingMap.put(Integer.parseInt(key), vehicle_number);
			    		 
			    		 lbl.setText("Slot selected :"+key+"\n\nCar No."+vehicle_number);
			    		 
			    		 persistMap();
			    	}
			    	
				});
				//gc.drawImage(vac_b, 87 + 20 * i, 30);
			}else {
				//gc.drawImage(car_b, 87 + 20 * i, 30);
				final Button button = new Button(shell, SWT.PUSH);
			    button.setImage(car_b);
			    button.setBounds(87 + 20 * i, 30,15,48);
			    button.setToolTipText("Slot: "+key +"\nCar No.: "+ bookingMap.get(Integer.parseInt(key)) );
			    
			}
			
		}
		// Image carimp = new Image(display,"car.jpg");
				Image vac_a = new Image(display, "images/vac_a.jpg");
				Image car_a = new Image(display, "images/car_a.jpg");
				Image car_c = new Image(display, "images/car_c.jpg");
				
				for (int i = 1; i < 21; i++) {
					String key = level+"2"+(50+i);
					if (bookingMap.get(Integer.parseInt(key))==null) {
						gc.drawImage(vac_a, 40, 20 * i + 77);
					}else {
						gc.drawImage(car_a, 40, 20 * i + 77);
					}
					
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

					String key = level+"2"+(190+i);
					if (bookingMap.get(Integer.parseInt(key))==null) {
						gc.drawImage(vac_a, 1027, 20 * i + 130);
					}else {
						gc.drawImage(car_c, 1027, 20 * i + 130);
					}
					
				
					
					
					
				}
				
				
				
	}

	protected static void persistMap() {
		File file = new File("map");
		FileOutputStream f = null;
		ObjectOutputStream s = null;
		try {
			f = new FileOutputStream(file);

			s = new ObjectOutputStream(f);

			s.writeObject(bookingMap);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(s != null) {
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(f!=null) {
				try {
					f.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			
	}

	public static void checkOut(String vehicle_number) {
		
		initMap();
		for(Map.Entry<Integer, String> entry: bookingMap.entrySet()) {
			if(entry.getValue().equals(vehicle_number)) {
				bookingMap.remove(entry.getKey());
				break;
			}
		}
		persistMap();
	}

}
