public class MesInvalidoException extends IllegalArgumentException {

    public MesInvalidoException() {
        super("Argumento fora dos limites !!!");
    }

    public MesInvalidoException(String mensagem) {
        super(mensagem);
    }

}