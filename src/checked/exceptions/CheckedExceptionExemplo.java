package checked.exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

public class CheckedExceptionExemplo {
	public static void main(String[] args) {
		String nomeArquivo = "arquivo.txt";

		try {
			imprimirArquivoNoConsole(nomeArquivo);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "O arquivo: '" + nomeArquivo + "' não existe!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado! Entre em contato com a equipe técnica!");
		}
	}

	private static void imprimirArquivoNoConsole(String nomeArquivo) throws IOException {
		File file = new File(nomeArquivo);

		if (!file.exists()) {
			throw new FileNotFoundException();
		}

		try (BufferedReader br = new BufferedReader(new FileReader(file));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

			String linha = br.readLine();

			do {
				bw.write(linha);
				bw.newLine();
				linha = br.readLine();
			} while (linha != null);
		}
	}
}
