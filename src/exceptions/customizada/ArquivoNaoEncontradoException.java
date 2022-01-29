package exceptions.customizada;

public class ArquivoNaoEncontradoException extends Exception {
	private static final long serialVersionUID = 1L;

	private final String nomeArquivo;

	public ArquivoNaoEncontradoException(String nomeArquivo) {
		super("O arquivo '" + nomeArquivo + "' não foi encontrado!");
		this.nomeArquivo = nomeArquivo;
	}

	public String getNomeArquivo() {
		return this.nomeArquivo;
	}
}
