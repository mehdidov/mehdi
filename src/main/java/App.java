import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.TextBuffer;
import fr.einfolearning.tp2.metiers.TextEditor;
import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;

public class App {

    public static void main(String[] args) {
        TextBuffer bu = new TextBuffer("Cours de qualité logiciel");
        EmacsKillRing kc = new EmacsKillRing();
        TextEditor ed = new TextEditor("Je suis un éditeur de texte");

        try {
            System.out.println(ed.getBuffer());
            ed.setCursor(3);
            ed.setMark(7);
            ed.killRingBackup();
            System.out.println(ed.getBuffer());

            ed.setCursor(11);
            ed.setMark(16);
            ed.killSection();
            System.out.println(ed.getBuffer());
            ed.setCursor(8);
            ed.yank();
            System.out.println(ed.getBuffer());


        } catch (EmacsKillRingOverflowException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}