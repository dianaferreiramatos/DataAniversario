public class DiaInvalidoException extends IllegalArgumentException {

        public DiaInvalidoException() {
            super("Argumento fora dos limites !!!");
        }

        public DiaInvalidoException(String mensagem) {
            super(mensagem);
        }

}

