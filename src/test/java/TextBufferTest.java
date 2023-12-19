import fr.einfolearning.tp2.metiers.TextBuffer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class TextBufferTest {
    private TextBuffer textBuffer;

    @BeforeEach
    /*
     * J'initialise un nouveau textBuffer que je pourrais utiliser dans mes méthodes,
     * elle s'initialise avant tout.
     * */
    public void init(){
        textBuffer = new TextBuffer("Ceci est un test de la méthode toString");
    }

    @Test
    /**
     * Je test la méthode toString, je vérifie qu'elle me renvoie le text attendu.
     * */
    public void TestTextBufferToString(){
        //Arrange
        TextBuffer bu = new TextBuffer("Je test la méthode toString() de la classe TextBuffer");

        String expectedText = "Je test la méthode toString() de la classe TextBuffer";

        //Act
        String action = bu.toString();
        //Asset
        Assertions.assertEquals(expectedText, action);
    }




    @Test
    /**
     * Je test la méthode MaxP, la longueur de mon texte est de 23, je vérifie donc si mon texte attendu,
     * a la même taille.
     * */
    public void TestTextBufferMaxP(){
        //Arrange
        TextBuffer buf = new TextBuffer("je suis le roi Louis 14");

        int expectedTaille = 23;

        //Act
        int taille = buf.maxP();
        //Asset
        Assertions.assertEquals(expectedTaille, taille);
    }

    @Test
    /**
     * Je test la méthode Ins, j'insère un mot(MahmutAli) en plein milieu d'un text à la position 22,
     * puis je vérifie si ce texte est bien le texte attendu.
     * */
    public void testTextBufferIns() {
        // Arrange
        TextBuffer textBuffer = new TextBuffer("Bonjour, je m'appelle !");
        String expectedText = "Bonjour, je m'appelle MahmutAli !";
        int position = 22;
        String insertedText = "MahmutAli ";

        // Act
        textBuffer.ins(insertedText, position);
        String result = textBuffer.toString();

        // Assert
        Assertions.assertEquals(expectedText, result);
    }
    @Test
    /**
     * Je test la méthode Del, je supprime une partie du texte déjà existant, de la position 9 à la position 15
     * puis je vérifie si ce texte est bien le texte attendu.
     * */
    public void testTextBufferDel() {
        // Arrange
        TextBuffer textBuffer = new TextBuffer("Bonjour, MahmutAli!");
        String expectedText = "Bonjour, Ali!";
        int from = 9;
        int to = 15;

        // Act
        textBuffer.del(from, to);
        String result = textBuffer.toString();

        // Assert
        Assertions.assertEquals(expectedText, result);
    }
    @Test
    /**
     * Je test la méthode substr, je sélectionne une partie du texte entre la position 9 et 15, puis je supprime le restant
     * puis je vérifie si ce texte est bien le texte attendu.
     * */
    public void testTextBufferSubstr() {
        // Arrange
        TextBuffer textBuffer = new TextBuffer("Bonjour, MahmutAli!");
        String expectedText = "Mahmut";
        int from = 9;
        int to = 15;

        // Act
        String result = textBuffer.substr(from, to);

        // Assert

        Assertions.assertEquals(expectedText, result);
    }

    @Test
    public void should_return_same_inserted_string_when_insert_string() {
        // Arrange

        String expectedText = "test";
        int from = 4;
        int to = from + "test".length();

        // Act
        textBuffer.ins("test", 4);

        // Assert
        String result = textBuffer.substr(from, to);
        assertThat(result, is(expectedText));
    }

    @Test
    public void should_return_trunced_string_when_out_of_limit() {
        // Arrange

        String expectedText = "String";
        int from = "Ceci est un test de la méthode toString".length()-6;
        int to = 200;

        // Act
        String result = textBuffer.substr(from, to);

        // Assert

        assertThat(result, is(expectedText));
    }
    @Test
    public void should_return_nothing_string_where_when_from_and_out_of_limit() {
        // Arrange

        String expectedText = "String";
        int from = 200;
        int to = 200;

        // Act
        String result = textBuffer.substr(from, to);

        // Assert

        assertThat(result, is(""));
    }

    @Test
    public void should_delete_substring_where_when_from_and_correct() {
        // Arrange

        String expectedText = "Ceci est un  de la méthode toString";
        int from = 12;
        int to = 16;

        // Act
        textBuffer.del(from, to);

        // Assert

        assertThat(textBuffer.toString(), is(expectedText));
    }

    @Test
    public void should_delete_trunced_substring_where_to_out_of_limit() {
        // Arrange

        String expectedText = "Ceci est un test de la méthode to";
        int from = "Ceci est un test de la méthode toString".length() - 6;
        int to = 200;

        // Act
        textBuffer.del(from, to);

        // Assert

        assertThat(textBuffer.toString(), is(expectedText));
    }

    @Test
    public void should_del_nothing_where_from_and_to_out_of_limit() {
        // Arrange

        String expectedText = "Ceci est un test de la méthode toString";
        int from = 200;
        int to = 200;

        // Act
        textBuffer.del(from, to);

        // Assert

        assertThat(textBuffer.toString(), is(expectedText));
    }

    @Test
    public void should_ins_before_start() {
        //pas fini
        // Arrange

        String expectedText = "Ceci est un test de la méthode toString";
        int position = -5;




        // Act
        textBuffer.ins("ce",position);

        // Assert

        assertThat(textBuffer.toString(), is(expectedText));
    }

    @Test
    public void should_ins_after_end() {
        //pas fini
        // Arrange

        String expectedText = "Ceci est un test de la méthode toString";
        int position = 50;




        // Act
        textBuffer.ins("ce",position);

        // Assert

        assertThat(textBuffer.toString(), is(expectedText));
    }

    @Test
    public void should_del_nothing_where_from_and_to_in_of_limit() {
        // Arrange

        String expectedText = "Ceci est un test de la méthode toString";
        int from = -5;
        int to = 0;

        // Act
        textBuffer.del(from, to);

        // Assert

        assertThat(textBuffer.toString(), is(expectedText));
    }

    @Test
    public void should_substr_nothing_where_from_and_to_in_of_limit() {
        // Arrange

        String expectedText = "Ceci est un test de la méthode toString";
        int from = -5;
        int to = 0;

        // Act
        textBuffer.substr(from, to);

        // Assert

        assertThat(textBuffer.toString(), is(expectedText));
    }

    @Test
    public void should_del_nothing_where_to_in_of_limit() {
        // Arrange

        String expectedText = "Ceci est un test de la méthode toString";
        int from = -2;
        int to = -2;

        // Act
        textBuffer.del(from, to);

        // Assert

        assertThat(textBuffer.toString(), is(expectedText));
    }

    @Test
    public void should_substr_nothing_where_to_in_of_limit() {
        // Arrange

        String expectedText = "Ceci est un test de la méthode toString";
        int from = -2;
        int to = -2;

        // Act
        textBuffer.substr(from, to);

        // Assert

        assertThat(textBuffer.toString(), is(expectedText));
    }





}
