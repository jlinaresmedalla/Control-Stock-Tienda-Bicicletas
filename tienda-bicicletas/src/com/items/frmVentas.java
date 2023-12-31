package com.items;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.sistemaComercial.MenuPrincipal;

import javax.swing.DefaultComboBoxModel;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class frmVentas extends JInternalFrame {
	private JTextArea areaTextoResultado;
	private JTextField ctCantidad;
	private JComboBox comboBoxModelo;
	private DefaultComboBoxModel modeloCombobox;
	private JButton btnRefresh;
	protected int cantidadInicial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmVentas frame = new frmVentas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmVentas() {
		setClosable(true);
		setBounds(100, 100, 450, 403);
		getContentPane().setLayout(null);
		
		JLabel etiquetaCantidad = new JLabel("CANTIDAD");
		etiquetaCantidad.setFont(new Font("Tahoma", Font.BOLD, 15));
		etiquetaCantidad.setBounds(57, 88, 89, 20);
		getContentPane().add(etiquetaCantidad);
		
		ctCantidad = new JTextField();
		ctCantidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		ctCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		ctCantidad.setBounds(156, 90, 218, 20);
		getContentPane().add(ctCantidad);
		//validacionNumeroCantidad();
		ctCantidad.setColumns(10);
		
		comboBoxModelo = new JComboBox();
		modeloCombobox = new DefaultComboBoxModel();
		comboBoxModelo.setModel(modeloCombobox);
		llenarComboBox();
		
		comboBoxModelo.setBounds(156, 55, 185, 22);
		getContentPane().add(comboBoxModelo);
		
		JLabel etiquetaModelo = new JLabel("MODELO");
		etiquetaModelo.setFont(new Font("Tahoma", Font.BOLD, 15));
		etiquetaModelo.setBounds(57, 55, 89, 22);
		getContentPane().add(etiquetaModelo);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Object[] item1 = MenuPrincipal.datos.get(comboBoxModelo.getSelectedIndex());
					cantidadInicial = Integer.parseInt(String.valueOf(item1[4]));
					if(cantidadInicial >= Double.valueOf(ctCantidad.getText())) {
						aceptar();
					}else {
						JOptionPane.showMessageDialog(desktopIcon, "No hay stock suficiente");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(desktopIcon, "Ingresa una cantidad");
				}
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAceptar.setBounds(41, 127, 97, 33);
		getContentPane().add(btnAceptar);
		
		JButton btnReporte = new JButton("REPORTE");
		btnReporte.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmReporte x = new frmReporte();
				MenuPrincipal.escritorioPrincipal.add(x);
				x.setVisible(true);
			}
		});
		btnReporte.setBounds(282, 127, 109, 33);
		getContentPane().add(btnReporte);
		
		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimpiar.setBounds(162, 127, 97, 33);
		getContentPane().add(btnLimpiar);
		
		JLabel lblNewLabel_1 = new JLabel("VENTA DE BICICLETAS");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 11, 414, 33);
		getContentPane().add(lblNewLabel_1);
		
		btnRefresh = new JButton("O");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modeloCombobox.removeAllElements();
				llenarComboBox();
			}
		});
		btnRefresh.setMargin(new Insets(2, 0, 2, 0));
		btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRefresh.setBounds(348, 55, 26, 22);
		getContentPane().add(btnRefresh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 171, 382, 191);
		getContentPane().add(scrollPane);
		
		areaTextoResultado = new JTextArea();
		scrollPane.setViewportView(areaTextoResultado);
		areaTextoResultado.setFont(new Font("Monospaced", Font.PLAIN, 13));
		areaTextoResultado.setText("");

	}

	protected void limpiar() {
		// TODO Auto-generated method stub
		areaTextoResultado.setText("");
		ctCantidad.setText("");
	}

	protected void aceptar() {
		DecimalFormat df = new DecimalFormat("0.00");
		LocalDate fechaActual = LocalDate.now();
		int cantidad = Integer.parseInt(ctCantidad.getText());;
		int nuevaCantidad = cantidadInicial - cantidad;
		double precio = 0;
		double importeCompra = 0;
		double descuento = 0;
		double importePago = 0;
		String obsequio = null;
		
		
		
		for(Object[] item : MenuPrincipal.datos) {
			if(item[0] == comboBoxModelo.getSelectedItem()) {
				precio = Double.parseDouble(item[1].toString());
				item[4] = nuevaCantidad ;
			}
		}		
		
		importeCompra = cantidad*precio;
		
		if (cantidad < 2) {
			descuento = MenuPrincipal.descuentos[0];
			obsequio = MenuPrincipal.obsequios[0];
		}else if(cantidad >= 2 && cantidad < 6){
			descuento = MenuPrincipal.descuentos[1];
			obsequio = MenuPrincipal.obsequios[1];
		}else if(cantidad >= 6 && cantidad < 11){
			descuento = MenuPrincipal.descuentos[2];
			obsequio = MenuPrincipal.obsequios[2];
		}else if(cantidad >= 11){
			descuento = MenuPrincipal.descuentos[3];
			obsequio = MenuPrincipal.obsequios[3];
		}
		
		importePago = importeCompra - importeCompra*descuento;
		
		areaTextoResultado.append( "\n                   BOLETA\n"
								  +" ==========================================\n"
								  +String.format("%-30s", "  El categoría es:")
								  +String.format("%-15s", comboBoxModelo.getSelectedItem())
								  +"\n"
								  +String.format("%-30s", "  La cantidad de pedida es:")
								  +String.format("%-15s", ctCantidad.getText())
								  +"\n"
								  +String.format("%-30s", "  El importe de compra es:")
								  +String.format("%-15s", "$ " + df.format(importeCompra))
								  +"\n"
								  +String.format("%-30s", "  El descuento es:")
								  +String.format("%-15s", "$ " + df.format(importeCompra*descuento))
								  +"\n"
								  +String.format("%-30s", "  El importe de pago es:")
							  	  +String.format("%-15s", "$ " + df.format(importePago))
								  +"\n"
								  +String.format("%-30s", "  El obsequio es un: ")
								  +String.format("%-15s", obsequio)
							  	  +"\n ==========================================");
		
	    Object[] array= {fechaActual, comboBoxModelo.getSelectedItem(), precio, cantidad, descuento, importePago, obsequio};

	    MenuPrincipal.historial.add(array);
	    
	    MenuPrincipal.contador++;
	    if(MenuPrincipal.contador%5 == 0) {
			for(Object[] item : MenuPrincipal.historial) {
					MenuPrincipal.sumaImporte += Double.parseDouble(item[5].toString());	
			}	
			
			double porcentaje = (MenuPrincipal.sumaImporte/MenuPrincipal.importeObjetivo)*100;
			
			if(MenuPrincipal.sumaImporte > MenuPrincipal.importeObjetivo) {
				JOptionPane.showMessageDialog(desktopIcon, "Objetivo diario alcanzado\nImporte Total de: $ " + df.format(MenuPrincipal.sumaImporte));
			}else {
				JOptionPane.showMessageDialog(desktopIcon, "Vas por el: "+ df.format(porcentaje) + " % del objetivo diario\nImporte Total de: $ " + df.format(MenuPrincipal.sumaImporte));
			}
	    }
	    
	    try {
			frmReporte.vaciarTabla();
			frmReporte.llenarTablaVentas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	    
	    try {
			frmConsultar.consultarTabla();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
	    
	    
	}

	protected void llenarComboBox() {
		// TODO Auto-generated method stub
		if(comboBoxModelo.getItemCount() == 0) {
			for(Object[] item : MenuPrincipal.datos) {
				Object m =item[0]; 
				modeloCombobox.addElement(m);
			}
		}
	}
	
	void validacionNumeroCantidad()  {  

		ctCantidad.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char caracter=e.getKeyChar();
					//verificar si la tecla pulsa es digito
					if(((caracter<'0')||(caracter>'9'))){
							javax.swing.JOptionPane.showMessageDialog(ctCantidad, "Sólo debe Introduir Números");
							e.consume();
					}
					if (ctCantidad.getText().length()>=10) {
					    	javax.swing.JOptionPane.showMessageDialog(ctCantidad, "Sólo Acepta Longuitud de 10 Números");
							e.consume();	
					}
				}
		});
	}	
}
