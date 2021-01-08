public class MesInvalidoException extends IllegalArgumentException {

    public MesInvalidoException() {
        super("Mes fora dos limites !!!");
    }

    public MesInvalidoException(String mensagem) {
        super(mensagem);
    }

}