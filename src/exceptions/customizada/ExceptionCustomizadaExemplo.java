package exceptions.customizada;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

public class ExceptionCustomizadaExemplo {
	public static void main(String[] args) {
		String nomeArquivo = "arquivo.txt";

		try {
			imprimirArquivoNoConsole(nomeArquivo);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado! Entre em contato com a equipe técnica!");
		}
	}

	private static void imprimirArquivoNoConsole(String nomeArquivo) throws IOException {
		try (BufferedReader br = lerArquivo(nomeArquivo);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {

			String linha = br.readLine();

			do {
				bw.write(linha);
				bw.newLine();
				linha = br.readLine();
			} while (linha != null);

		} catch (ArquivoNaoEncontradoException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private static BufferedReader lerArquivo(String nomeArquivo) throws ArquivoNaoEncontradoException {
		File file = new File(nomeArquivo);
		try {
			return new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			throw new ArquivoNaoEncontradoException(file.getName());
		}
	}
}
