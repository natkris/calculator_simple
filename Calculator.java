package calculator;

/*
 * Zitat : Unterlagen Prof. Dr. Oliver Bittel, Galileo Computing
 * 6.11.2014
 * @Autor : Nataniel K. Susantoputra
 * 
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class Calculator extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField op1, op2, result, color1, color2;
	JButton sumBt, mulBt, minBt, divBt;
	JButton sinBt, cosBt, xyBt, logBt;
	JButton clearBt;
	JCheckBox display;
	JRadioButton deg, rad;
	
	public Calculator(){
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel op1Label = new JLabel("Operand x");
		JLabel op2Label = new JLabel("Operand y");
		JLabel resLabel = new JLabel("Result");
		
		op1 = new JTextField("0", 10);
		
		op2 = new JTextField("0", 10);
		
		result = new JTextField("0", 10);
		result.setEditable(false);
		
		sumBt = new JButton("+");
		mulBt = new JButton("*");
		minBt = new JButton("-");
		divBt = new JButton("/");
		
		sinBt = new JButton("sin");
		cosBt = new JButton("cos");
		xyBt = new JButton ("x^y");
		logBt = new JButton ("log2");
		
		//Buttons definieren
		deg = new JRadioButton("Deg");
		deg.setSelected(true);
		rad = new JRadioButton("Rad");
		
		//Buttons gruppieren
		ButtonGroup gr = new ButtonGroup();
		gr.add(deg);
		gr.add(rad);
		
		
		display = new JCheckBox("Helles Display");
		display.setSelected(true);
		
		clearBt = new JButton("Clear");
		
		//1. Panel
		sumBt.addActionListener(this);
		mulBt.addActionListener(this);
		minBt.addActionListener(this);
		divBt.addActionListener(this);
		
		//2. Panel 
		deg.addActionListener(this);
		rad.addActionListener(this);
		display.addActionListener(this);
		
		//3. Panel
		sinBt.addActionListener(this);
		cosBt.addActionListener(this);
		xyBt.addActionListener(this);
		logBt.addActionListener(this);
		
		//4. Panel
		clearBt.addActionListener(this);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3, 2));
		panel1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		//Textfields und Labels zu Panel zusammenfassen
		//1. Feld
		panel1.add(op1Label);
		panel1.add(op1);
		panel1.add(op2Label);
		panel1.add(op2);
		panel1.add(resLabel);
		panel1.add(result);
		
		//2. Feld
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(0, 3));
		panel2.add(deg);
		panel2.add(rad);
		panel2.add(display);
		
		//3. Feld
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(2, 4));
		panel3.setBorder(BorderFactory.createLineBorder(Color.yellow));
		panel3.add(sumBt); 
		panel3.add(mulBt);
		panel3.add(minBt);
		panel3.add(divBt);
		panel3.add(sinBt);
		panel3.add(cosBt);
		panel3.add(xyBt);
		panel3.add(logBt);
		
		//4. Feld
		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(2, 0));
		panel4.add(clearBt);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		setContentPane(panel);
		
		pack();
		setResizable(true);
		setVisible(false);
}
	//Um die Displays Op1 und Op2 mit der anderen Farbe zu zeigen
	@Override
	public void actionPerformed(ActionEvent x) {
		Object source = x.getSource();
		String s1 = op1.getText();
		String s2 = op2.getText();
		double o1 = 0;
		double o2 = 0;
		try {
			o1 = Double.parseDouble(s1);
			o2 = Double.parseDouble(s2);

		} catch (NumberFormatException e) {
			
			Component myFrame = null;
			JOptionPane.showMessageDialog(myFrame, "Operanden pruefen!!");
			
			
//			System.out.println("Operanden pr�fen!");
		}
		
		//Funktionen
		//Grundlage Berechnung
		if(source == sumBt){
			result.setText(" " + (o1+o2));
		} else if (source == mulBt) {
			
			result.setText(" " + (o1*o2));
			
		} else if(source == minBt) {
			
			result.setText(" " + (o1-o2));
			
		} else if(source == divBt) {
			
			result.setText(" " + (o1/o2));
			
		} 
		
		//Sinus
		if(source == sinBt){
			double radius = Math.toRadians(o1);
			
			if(deg.isSelected()){
				result.setText(" " + Math.sin(radius));
			} else {
				result.setText(" " + Math.sin(o1));
			}
		}
		
		//Cosinus
		if(source == cosBt) {
			double radius = Math.toRadians(o1);
			
			if(deg.isSelected()){
				result.setText(" " + Math.cos(radius));
			} else {
				result.setText(" " + Math.cos(o1));
			}
		}
		
		
		//hoch Berechnung
		if(source == xyBt) {
			
			result.setText(" " + Math.pow(o1, o2));
		} 
		
		//Logaritmus
		if(source == logBt) { 
			
			result.setText(" " + Math.log10(o1));
			
		} 
		
		//Clear-Taste
		if(source == clearBt) {
			
			op1.setText("0");
			
			op2.setText("0");
			
			result.setText("0");
		}
		
		//Um die Displays Op1 und Op2 mit der anderen Farbe zu zeigen
		if(source == display){
			
			if(display.isSelected()){
				op1.setBackground(Color.WHITE);
				op1.setForeground(Color.BLACK);
				op2.setBackground(Color.WHITE);
				op2.setForeground(Color.BLACK);
			} else {
				op1.setBackground(Color.BLACK);
				op1.setForeground(Color.YELLOW);
				op2.setBackground(Color.BLACK);
				op2.setForeground(Color.YELLOW);
			}
		}
		
		
	}

}
