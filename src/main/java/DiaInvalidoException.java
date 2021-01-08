public class DiaInvalidoException extends IllegalArgumentException {

        public DiaInvalidoException() {
            super("Dia fora dos limites !!!");
        }

        public DiaInvalidoException(String mensagem) {
            super(mensagem);
        }

}

