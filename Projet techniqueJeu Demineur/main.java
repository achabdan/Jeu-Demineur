
import javax.swing.*;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI_initer::new);
        NoGUI Game = new NoGUI("bonjour", 1);

        Game.GameUpdate();
    }
}
