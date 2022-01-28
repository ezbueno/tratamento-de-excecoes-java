package unchecked.exceptions;

import javax.swing.JOptionPane;

public class UncheckedExceptionExemplo {
	public static void main(String[] args) {
		String a = JOptionPane.showInputDialog("Numerador: ");
		String b = JOptionPane.showInputDialog("Denominador: ");

		try {
			int resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));
			JOptionPane.showMessageDialog(null, "Resultado: " + resultado);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valor inválido! Forneça um valor válido.");
		} catch (ArithmeticException e) {
			JOptionPane.showMessageDialog(null, "Não é possíve dividir " + a + " por " + b);
		}
	}

	private static int dividir(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException();
		}
		return a / b;
	}
}
