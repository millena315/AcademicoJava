package br.com.cadaluno.model;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

// Colocando limite de caracteres e apenas permitindo letras

public class SoLetrasJTextField extends PlainDocument {

	private int tamanhoMax = 10;

	public SoLetrasJTextField(int tamanhoMax) {
		super();
		this.tamanhoMax = tamanhoMax;
	}

	@Override
	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {

		if (str == null)
			return;

		String stringAntiga = getText(0, getLength());
		int tamanhoNovo = stringAntiga.length() + str.length();

		if (tamanhoNovo <= tamanhoMax) {
			super.insertString(offset, str.toUpperCase().replaceAll("[^a-z|^A-Z|^ |^����������������������]", ""),
					attr);
		} else {
			super.insertString(offset, "", attr);
		}
	}

}
