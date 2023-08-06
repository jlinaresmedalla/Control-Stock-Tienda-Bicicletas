package com.items;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sistemaComercial.MenuPrincipal;

public class frmReporte extends JInternalFrame {
	public static JTable tablaVentas;
	public static DefaultTableModel historialTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmReporte frame = new frmReporte();
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
	public frmReporte() {
		setClosable(true);
		setTitle("REPORTE DE VENTAS");
		setBounds(100, 100, 583, 234);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		tablaVentas = new JTable();
		historialTabla = new DefaultTableModel();
		tablaVentas.setModel(historialTabla);
		historialTabla.addColumn("Fecha");
		historialTabla.addColumn("Modelo");
		historialTabla.addColumn("Precio $");
		historialTabla.addColumn("Cantidad");
		historialTabla.addColumn("Descuento");
		historialTabla.addColumn("Importe Total");
		historialTabla.addColumn("Obsequio");
		tablaVentas.getColumnModel().getColumn(0).setPreferredWidth(60);
		tablaVentas.getColumnModel().getColumn(1).setPreferredWidth(70);
		tablaVentas.getColumnModel().getColumn(2).setPreferredWidth(45);
		tablaVentas.getColumnModel().getColumn(3).setPreferredWidth(45);
		tablaVentas.getColumnModel().getColumn(4).setPreferredWidth(56);
		tablaVentas.getColumnModel().getColumn(5).setPreferredWidth(56);
		tablaVentas.getColumnModel().getColumn(5).setPreferredWidth(56);
		scrollPane.setViewportView(tablaVentas);
		llenarTablaVentas();
	
	}

	public static void llenarTablaVentas() {
		// TODO Auto-generated method stub
		if(historialTabla.getRowCount() == 0) {
			for(Object[] ob : MenuPrincipal.historial) {
				historialTabla.addRow(ob);
			}
		}
	}
	
	public static void vaciarTabla() {
		historialTabla.setRowCount(0);
	}
}
