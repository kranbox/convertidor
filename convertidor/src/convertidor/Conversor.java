
package convertidor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;


public class Conversor extends JFrame {

	private static final long serialVersionUID = 1583724102189855698L;
        public int res = 0 ;
        public int valorP = 20;
	/** numero tecleado */
	JTextField pantalla;

	double resultado;

        JButton boton;
	String operacion;

        
	JPanel panelNumeros, panelOperaciones;


	boolean nuevaOperacion = true;
        
        


	public Conversor() {
		super();
		setSize(250, 300);
		setTitle("Calculadora Simple");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);

		
		JPanel panel = (JPanel) this.getContentPane();
		panel.setLayout(new BorderLayout());

		pantalla = new JTextField("0", 20);
		pantalla.setBorder(new EmptyBorder(4, 4, 4, 4));
		pantalla.setFont(new Font("Arial", Font.BOLD, 25));
		pantalla.setHorizontalAlignment(JTextField.RIGHT);
		pantalla.setEditable(false);
		pantalla.setBackground(Color.WHITE);
		panel.add("North", pantalla);
                boton = new JButton("Convertir");
		panelNumeros = new JPanel();
		panelNumeros.setLayout(new GridLayout(4, 3));
		panelNumeros.setBorder(new EmptyBorder(4, 4, 4, 4));

		for (int n = 9; n >= 0; n--) {
			nuevoBotonNumerico("" + n);
		}

		nuevoBotonNumerico(".");
                
		panel.add("Center", panelNumeros);

		panelOperaciones = new JPanel();
		panelOperaciones.setLayout(new GridLayout(6, 1));
		panelOperaciones.setBorder(new EmptyBorder(4, 4, 4, 4));

                nuevoBotonOperacion("CE");


		panel.add("East", panelOperaciones);
                panelOperaciones.add(boton);
		validate();
                con();

	}

	
	private void nuevoBotonNumerico(String digito) {
		JButton btn = new JButton();
		btn.setText(digito);
		btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evt) {
				JButton btn = (JButton) evt.getSource();
				numeroPulsado(btn.getText());
			}
		});

		panelNumeros.add(btn);
	}

	
	private void nuevoBotonOperacion(String operacion) {
		JButton btn = new JButton(operacion);
		btn.setForeground(Color.RED);

		btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evt) {
				JButton btn = (JButton) evt.getSource();
				operacionPulsado(btn.getText());
			}
		});

		panelOperaciones.add(btn);
	}

	
	private void numeroPulsado(String digito) {
		if (pantalla.getText().equals("0") || nuevaOperacion) {
			pantalla.setText(digito);
		} else {
			pantalla.setText(pantalla.getText() + digito);
		}
		nuevaOperacion = false;
	}

	
	private void operacionPulsado(String tecla) {
		if (tecla.equals("Convertir")) {
			convertir(); 
		} else if (tecla.equals("CE")) {
			resultado = 0;
			pantalla.setText("");
			nuevaOperacion = true;
		} else {
			
		}

		nuevaOperacion = true;
	}

/*
	private double convertir() {
		resultado = resultado / 20;
                return resultado;
		
	}
*/
        public void con() {
             boton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent evt){
                 if(resultado!=0)
                        resultado=resultado/Double.parseDouble(pantalla.getText());
                    else
                        resultado=Double.parseDouble(pantalla.getText());
                        
                 resultado= resultado/20;
                 pantalla.setText(String.valueOf(resultado));

                 
            }
        });
             
}
       




 
        
}