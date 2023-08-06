package com.items;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sistemaComercial.MenuPrincipal;

import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Desktop;

import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class frmConsultar extends JInternalFrame {
	private JTable tablaInventario;
	public static DefaultTableModel modeloTabla;
	
	private JScrollPane scrollPane;
	private JTextField ctModelo;
	private JTextField ctPrecio;
	private JTextField ctMarco;
	private JTextField ctAro;
	private JTextField ctCantidad;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmConsultar frame1 = new frmConsultar();
					frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmConsultar() {
		setTitle("Consultar Inventario");
		setClosable(true);
		setBounds(100, 100, 632, 279);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(244, 41, 362, 149);
		getContentPane().add(scrollPane);
		
		tablaInventario = new JTable();
		tablaInventario.setBorder(null);
		tablaInventario.setFillsViewportHeight(true);
		tablaInventario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaInventario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tablaInventario.setRowHeight(17);
		modeloTabla = new DefaultTableModel();
		tablaInventario.setModel(modeloTabla);
		modeloTabla.addColumn("Modelo");
		modeloTabla.addColumn("Precio $");
		modeloTabla.addColumn("Marco (cm)");
		modeloTabla.addColumn("Aro (cm)");
		modeloTabla.addColumn("Cantidad");
		tablaInventario.getColumnModel().getColumn(0).setPreferredWidth(107);
		tablaInventario.getColumnModel().getColumn(1).setPreferredWidth(50);
		tablaInventario.getColumnModel().getColumn(2).setPreferredWidth(63);
		tablaInventario.getColumnModel().getColumn(3).setPreferredWidth(52);
		tablaInventario.getColumnModel().getColumn(4).setPreferredWidth(56);
		scrollPane.setViewportView(tablaInventario);
		
		JLabel etiquetaModelo = new JLabel("MODELO:");
		etiquetaModelo.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaModelo.setBounds(20, 41, 65, 21);
		getContentPane().add(etiquetaModelo);
		
		JLabel etiquetaPrecio = new JLabel("PRECIO:");
		etiquetaPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaPrecio.setBounds(20, 73, 65, 21);
		getContentPane().add(etiquetaPrecio);
		
		JLabel etiquetaMarco = new JLabel("MARCO:");
		etiquetaMarco.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaMarco.setBounds(20, 105, 65, 21);
		getContentPane().add(etiquetaMarco);
		
		JLabel etiquetaAro = new JLabel("ARO:");
		etiquetaAro.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaAro.setBounds(20, 137, 65, 21);
		getContentPane().add(etiquetaAro);
		
		JLabel etiquetaCantidad = new JLabel("CANTIDAD:");
		etiquetaCantidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaCantidad.setBounds(20, 169, 76, 21);
		getContentPane().add(etiquetaCantidad);
		
		ctModelo = new JTextField();
		ctModelo.setHorizontalAlignment(SwingConstants.CENTER);
		ctModelo.setBounds(105, 42, 129, 21);
		getContentPane().add(ctModelo);
		ctModelo.setColumns(10);
		
		ctPrecio = new JTextField();
		ctPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		ctPrecio.setColumns(10);
		ctPrecio.setBounds(105, 74, 129, 20);
		getContentPane().add(ctPrecio);
		
		ctMarco = new JTextField();
		ctMarco.setHorizontalAlignment(SwingConstants.CENTER);
		ctMarco.setColumns(10);
		ctMarco.setBounds(105, 106, 129, 20);
		getContentPane().add(ctMarco);
		
		ctAro = new JTextField();
		ctAro.setHorizontalAlignment(SwingConstants.CENTER);
		ctAro.setColumns(10);
		ctAro.setBounds(105, 138, 129, 20);
		getContentPane().add(ctAro);
		
		ctCantidad = new JTextField();
		ctCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		ctCantidad.setColumns(10);
		ctCantidad.setBounds(105, 170, 129, 20);
		getContentPane().add(ctCantidad);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarTabla();
			}
		});
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConsultar.setBounds(409, 201, 123, 38);
		getContentPane().add(btnConsultar);
		
		JButton btnLimpiar = new JButton("ELIMINAR");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					eliminarItem();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(desktopIcon, "Selecciona la fila a eliminar");
				}
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimpiar.setBounds(244, 201, 123, 38);
		getContentPane().add(btnLimpiar);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					agregarItem();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(desktopIcon, "Ingresa valores correctos");
				}
			}
		});
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAgregar.setBounds(80, 201, 123, 38);
		getContentPane().add(btnAgregar);
		
		JLabel etiquetaTitulo = new JLabel("INVENTARIO DE BICICLETAS");
		etiquetaTitulo.setForeground(new Color(255, 0, 0));
		etiquetaTitulo.setFont(new Font("Arial Black", Font.BOLD, 18));
		etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaTitulo.setBounds(10, 11, 596, 21);
		getContentPane().add(etiquetaTitulo);

	}
	
	public void eliminarItem() {
		int fila = tablaInventario.getSelectedRow();
		MenuPrincipal.datos.remove(fila);
		modeloTabla.removeRow(fila);
	}

	public void agregarItem(){
	    // Crear arreglo de datos de las bicicletas
	    String modelo = ctModelo.getText();
	    int precio = Integer.parseInt(ctPrecio.getText());
	    int marco = Integer.parseInt(ctMarco.getText());
	    int aro = Integer.parseInt(ctAro.getText());
	    int cantidad = Integer.parseInt(ctCantidad.getText());
	    
	    Object[] array= {modelo, precio, marco, aro, cantidad};

	    MenuPrincipal.datos.add(array);
	    modeloTabla.addRow(array);
	    
    }
      
	public static void consultarTabla(){
		if(modeloTabla.getRowCount() == 0) {
			llenarTabla();
		}else {
			modeloTabla.setRowCount(0);
			llenarTabla();
		}
	}

	private static void llenarTabla() {
		// TODO Auto-generated method stub
		for(Object[] ob : MenuPrincipal.datos) {
			modeloTabla.addRow(ob);
		}
	}
		
}
