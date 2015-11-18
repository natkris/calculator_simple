package calculator;

import javax.swing.SwingUtilities;

public class CalculatorMain {

	public static void main(String [] args){
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				Calculator tr = new Calculator();
				tr.setVisible(true);
			}
		});
	}
	
}
