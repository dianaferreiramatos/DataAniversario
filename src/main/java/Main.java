import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Formatter;
import java.util.Scanner;

public class Main {

    public static Scanner ler;
    public static Formatter escrever;

    public Main() {
    }

    public static void main(String[] args) {
        boolean ficheiroCriado = false;
        System.out.print("Nome do ficheiro: ");
        Formatter ficheiro = null;

        String nome;
        do {
            nome = ler.nextLine();

            try {
                ficheiro = new Formatter(new File(nome), "UTF-8");
                ficheiroCriado = true;
            } catch (UnsupportedEncodingException | FileNotFoundException var5) {
                System.out.printf("Impossível criar ficheiro!!%n%s (Acesso negado)%nDigite novamente o nome do ficheiro: ", nome);
            }
        } while(!ficheiroCriado);

        nome = "";

        do {
            System.out.println("Nome (\"ENTER para terminar\"):");
            nome = ler.nextLine();
            if (!nome.trim().isEmpty()) {
                Data data = lerData();
                ficheiro.format("%s, %s", nome, data.toString());
            }
        } while(!nome.trim().isEmpty());

        ficheiro.close();
        System.out.println("Aplicação terminada.");
    }

    public static Data lerData() {
        Data d = null;
        boolean dataValida = false;
        System.out.print("Data de aniversário (ano/mes/dia): ");

        do {
            String[] data = ler.nextLine().split("/");

            try {
                if (data.length != 3) {
                    throw new NumberFormatException();
                }

                d = new Data(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                dataValida = true;
            } catch (NumberFormatException var4) {
                System.out.println("Formato é inválido");
                System.out.println("Digite novamente a data de aniversário (ano/mês/dia):");
            } catch (MesInvalidoException | DiaInvalidoException var5) {
                System.out.println(var5.getMessage());
                System.out.println("Digite novamente a data de aniversário (ano/mês/dia):");
            }
        } while(!dataValida);

        return d;
    }

    static {
        ler = new Scanner(System.in);
        escrever = new Formatter(System.out);
    }
}
