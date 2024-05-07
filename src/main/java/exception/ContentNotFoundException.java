package exception;

public class ContentNotFoundException extends Throwable {
    public ContentNotFoundException() {
        super("Você não está matriculado em nenhum conteúdo.");
    }
}
