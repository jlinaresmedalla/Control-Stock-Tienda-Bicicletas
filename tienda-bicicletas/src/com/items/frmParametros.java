package com.items;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.sistemaComercial.MenuPrincipal;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;

public class frmParametros extends JInternalFrame {
	private JTextField ctDescuento1;
	private JTextField ctDescuento2;
	private JTextField ctDescuento3;
	private JTextField ctDescuento4;
	private JTextField ctObsequio1;
	private JTextField ctObsequio2;
	private JTextField ctObsequio3;
	private JTextField ctObsequio4;
	private JTextField ctImporteObjetivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmParametros frame = new frmParametros();
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
	public frmParametros() {
		setClosable(true);
		setForeground(new Color(255, 255, 255));
		setTitle("CONFIGURACIÓN DE PARAMETROS");
		setBounds(100, 100, 472, 366);
		getContentPane().setLayout(null);
		
		JLabel etiquetaRango1 = new JLabel("Cantidad entre 1 a 2");
		etiquetaRango1.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaRango1.setBounds(20, 69, 150, 21);
		getContentPane().add(etiquetaRango1);
		
		JLabel etiquetaRango2 = new JLabel("Cantidad entre 2 a 5");
		etiquetaRango2.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaRango2.setBounds(20, 101, 150, 21);
		getContentPane().add(etiquetaRango2);
		
		JLabel etiquetaRango3 = new JLabel("Cantidad entre 6 a 10");
		etiquetaRango3.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaRango3.setBounds(20, 133, 150, 21);
		getContentPane().add(etiquetaRango3);
		
		JLabel etiquetaRango4 = new JLabel("Cantidad mayor a 11");
		etiquetaRango4.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaRango4.setBounds(20, 165, 150, 21);
		getContentPane().add(etiquetaRango4);
		
		ctDescuento1 = new JTextField();
		ctDescuento1.setFont(new Font("Tahoma", Font.BOLD, 13));
		ctDescuento1.setHorizontalAlignment(SwingConstants.CENTER);
		ctDescuento1.setBounds(199, 69, 86, 20);
		getContentPane().add(ctDescuento1);
		ctDescuento1.setColumns(10);
		
		ctDescuento2 = new JTextField();
		ctDescuento2.setFont(new Font("Tahoma", Font.BOLD, 13));
		ctDescuento2.setHorizontalAlignment(SwingConstants.CENTER);
		ctDescuento2.setColumns(10);
		ctDescuento2.setBounds(199, 102, 86, 20);
		getContentPane().add(ctDescuento2);
		
		ctDescuento3 = new JTextField();
		ctDescuento3.setFont(new Font("Tahoma", Font.BOLD, 13));
		ctDescuento3.setHorizontalAlignment(SwingConstants.CENTER);
		ctDescuento3.setColumns(10);
		ctDescuento3.setBounds(199, 134, 86, 20);
		getContentPane().add(ctDescuento3);
		
		ctDescuento4 = new JTextField();
		ctDescuento4.setFont(new Font("Tahoma", Font.BOLD, 13));
		ctDescuento4.setHorizontalAlignment(SwingConstants.CENTER);
		ctDescuento4.setColumns(10);
		ctDescuento4.setBounds(199, 166, 86, 20);
		getContentPane().add(ctDescuento4);
		
		ctObsequio1 = new JTextField();
		ctObsequio1.setFont(new Font("Tahoma", Font.BOLD, 13));
		ctObsequio1.setHorizontalAlignment(SwingConstants.CENTER);
		ctObsequio1.setColumns(10);
		ctObsequio1.setBounds(295, 69, 137, 20);
		getContentPane().add(ctObsequio1);
		
		ctObsequio2 = new JTextField();
		ctObsequio2.setFont(new Font("Tahoma", Font.BOLD, 13));
		ctObsequio2.setHorizontalAlignment(SwingConstants.CENTER);
		ctObsequio2.setColumns(10);
		ctObsequio2.setBounds(295, 101, 137, 20);
		getContentPane().add(ctObsequio2);
		
		ctObsequio3 = new JTextField();
		ctObsequio3.setFont(new Font("Tahoma", Font.BOLD, 13));
		ctObsequio3.setHorizontalAlignment(SwingConstants.CENTER);
		ctObsequio3.setColumns(10);
		ctObsequio3.setBounds(295, 134, 137, 20);
		getContentPane().add(ctObsequio3);
		
		ctObsequio4 = new JTextField();
		ctObsequio4.setFont(new Font("Tahoma", Font.BOLD, 13));
		ctObsequio4.setHorizontalAlignment(SwingConstants.CENTER);
		ctObsequio4.setColumns(10);
		ctObsequio4.setBounds(295, 166, 137, 20);
		getContentPane().add(ctObsequio4);
		
		JButton botonModificar = new JButton("MODIFICAR");
		botonModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ModificarParametros();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(desktopIcon, "Ingresa valores correctos");
				}
			}
		});
		botonModificar.setFont(new Font("Tahoma", Font.BOLD, 15));
		botonModificar.setBounds(240, 296, 150, 31);
		getContentPane().add(botonModificar);
		
		JLabel etiquetaObsequios = new JLabel("OBSEQUIOS");
		etiquetaObsequios.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaObsequios.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaObsequios.setBounds(295, 37, 137, 21);
		getContentPane().add(etiquetaObsequios);
		
		JLabel etiquetaDescuentos = new JLabel("DESCUENTOS");
		etiquetaDescuentos.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaDescuentos.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaDescuentos.setBounds(199, 37, 86, 21);
		getContentPane().add(etiquetaDescuentos);
		
		JButton botonConsultar = new JButton("CONSULTAR");
		botonConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					llenarCamposTexto();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(desktopIcon, "Ingresa valores correctos");
				}
			}
		});
		botonConsultar.setFont(new Font("Tahoma", Font.BOLD, 15));
		botonConsultar.setBounds(62, 296, 150, 31);
		getContentPane().add(botonConsultar);
		
		JLabel etiquetaRangos = new JLabel("RANGOS");
		etiquetaRangos.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaRangos.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaRangos.setBounds(20, 37, 150, 21);
		getContentPane().add(etiquetaRangos);
		
		JLabel etiquetaTitutlo1 = new JLabel("PARÁMETROS DE CÁLCULO");
		etiquetaTitutlo1.setForeground(new Color(255, 0, 0));
		etiquetaTitutlo1.setFont(new Font("Arial Black", Font.BOLD, 18));
		etiquetaTitutlo1.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTitutlo1.setBounds(10, 0, 436, 38);
		getContentPane().add(etiquetaTitutlo1);
		
		JLabel lblNewLabel_1 = new JLabel("_____________________________________________________________________");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 197, 436, 21);
		getContentPane().add(lblNewLabel_1);
		
		JLabel etiquetaTitutlo2 = new JLabel("OBJETIVO DEL DÍA");
		etiquetaTitutlo2.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTitutlo2.setForeground(Color.RED);
		etiquetaTitutlo2.setFont(new Font("Arial Black", Font.BOLD, 18));
		etiquetaTitutlo2.setBounds(10, 216, 436, 38);
		getContentPane().add(etiquetaTitutlo2);
		
		JLabel lblCantidadDeUnidades = new JLabel("Objetivo de Importe total al día en $:");
		lblCantidadDeUnidades.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCantidadDeUnidades.setBounds(20, 261, 275, 21);
		getContentPane().add(lblCantidadDeUnidades);
		
		ctImporteObjetivo = new JTextField();
		ctImporteObjetivo.setFont(new Font("Tahoma", Font.BOLD, 13));
		ctImporteObjetivo.setHorizontalAlignment(SwingConstants.CENTER);
		ctImporteObjetivo.setColumns(10);
		ctImporteObjetivo.setBounds(295, 261, 137, 20);
		getContentPane().add(ctImporteObjetivo);

	}

	protected void ModificarParametros() {
		// TODO Auto-generated method stub
		MenuPrincipal.descuentos[0] = Double.parseDouble(ctDescuento1.getText());
		MenuPrincipal.descuentos[1] = Double.parseDouble(ctDescuento2.getText());
		MenuPrincipal.descuentos[2] = Double.parseDouble(ctDescuento3.getText());
		MenuPrincipal.descuentos[3] = Double.parseDouble(ctDescuento4.getText());
		MenuPrincipal.obsequios[0] = ctObsequio1.getText();
		MenuPrincipal.obsequios[1] = ctObsequio2.getText();
		MenuPrincipal.obsequios[2] = ctObsequio3.getText();
		MenuPrincipal.obsequios[3] = ctObsequio4.getText();
		MenuPrincipal.importeObjetivo = Double.parseDouble(ctImporteObjetivo.getText());
	}

	protected void llenarCamposTexto() {
		// TODO Auto-generated method stub
		ctDescuento1.setText(String.valueOf(MenuPrincipal.descuentos[0]));;
		ctDescuento2.setText(String.valueOf(MenuPrincipal.descuentos[1]));;
		ctDescuento3.setText(String.valueOf(MenuPrincipal.descuentos[2]));;
		ctDescuento4.setText(String.valueOf(MenuPrincipal.descuentos[3]));;
		ctObsequio1.setText(MenuPrincipal.obsequios[0]);
		ctObsequio2.setText(MenuPrincipal.obsequios[1]);
		ctObsequio3.setText(MenuPrincipal.obsequios[2]);
		ctObsequio4.setText(MenuPrincipal.obsequios[3]);
		ctImporteObjetivo.setText(String.valueOf(MenuPrincipal.importeObjetivo));
	}
}
