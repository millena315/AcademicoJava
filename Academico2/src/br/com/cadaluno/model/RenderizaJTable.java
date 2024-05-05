package br.com.cadaluno.model;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

// Centralizando o Jtable

public class RenderizaJTable extends DefaultTableCellRenderer {

	public RenderizaJTable() {
		super();
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		this.setHorizontalAlignment(CENTER);

		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}
}
