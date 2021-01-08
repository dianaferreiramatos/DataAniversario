import java.util.Scanner;

public class Util {
    public static Data lerData(){
        Scanner scanner = new Scanner(System.in);
        Data d = new Data();
        boolean dataInvalida = true;

        System.out.println("Introduza a data de aniversário: (ano/mes/dia)");

        do{
            try{
                String[] data = scanner.nextLine().split(/);
                if (data.length != 3){
                    throw new NumberFormatException();
                }
                int ano = Integer.parseInt(data[0]);
                int mes = Integer.parseInt(data[1]);
                int dia = Integer.parseInt(data[2]);

                d.setData(ano, mes, dia);

                dataInvalida = false;
            }
            catch (NumberFormatException e){
                System.out.println("Formato é inválido.");
                System.out.println("Introduza novamente a " +
                        "data de aniversário: (ano/mes/dia)");
            }
            catch (DiaInvalidoException | MesInvalidoException e){
                System.out.println(e.getMessage());
                System.out.println("Introduza novamente a " +
                        "data de aniversário: (ano/mes/dia)");
            }
        }while (dataInvalida);

        return d;
    }
}
