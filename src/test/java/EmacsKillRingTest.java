import fr.einfolearning.tp2.metiers.EmacsKillRing;
import fr.einfolearning.tp2.metiers.TextBuffer;
import fr.einfolearning.tp2.metiers.exceptions.EmacsKillRingOverflowException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EmacsKillRingTest {
    private TextBuffer textBuffer;



    @Test
    public void should_throw_emacskillringoverflowexception_when_buffer_full(){
        //Arrange
        EmacsKillRing emacsKillRing = new EmacsKillRing();

        //Act
        try {
            for (int i =0; i< emacsKillRing.MAX; i++){
                emacsKillRing.add("test");
            }
        } catch (EmacsKillRingOverflowException e) {
            Assertions.fail();
        }
        //Assert
        Assertions.assertThrows(EmacsKillRingOverflowException.class, ()->{emacsKillRing.add("test");});

    }

    @Test
    public void testEmacsKillRingToString() throws EmacsKillRingOverflowException {
        //Arrange
        EmacsKillRing emacsKillRing = new EmacsKillRing();

        emacsKillRing.add("test1");
        emacsKillRing.add("test2");

        //Act

        //Asset
        Assertions.assertEquals("[test2, test1]", emacsKillRing.toString());
    }

    @Test
    public void testEmacsKillRingRotate() throws EmacsKillRingOverflowException {
        //Arrange
        EmacsKillRing emacsKillRing = new EmacsKillRing();



        //Act
        emacsKillRing.add("test1");
        emacsKillRing.add("test2");
        //Assert

        Assertions.assertEquals("test2", emacsKillRing.currentElt());
        emacsKillRing.rotateFwd();
        Assertions.assertEquals("test1", emacsKillRing.currentElt());


    }




}
