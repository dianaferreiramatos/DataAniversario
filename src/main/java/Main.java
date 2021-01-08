import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        try {
            Data data = new Data(2021, 0, 8);
            System.out.println(data);

        } catch (MesInvalidoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


    }
}
