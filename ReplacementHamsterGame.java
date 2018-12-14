import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.Hamster;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Location;
import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.Territory;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Direction;
import java.io.IOException;

/**
 * Write a description of class ReplacementHamsterGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ReplacementHamsterGame extends SimpleHamsterGame {

    public ReplacementHamsterGame() {
        game.displayInNewGameWindow();
        try {
            game.initialize("/territories/rotate.ter");

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void run(){
        // call your rotatin method here
    }

    public void main(){
        game.startGame(false);
        doRun();
        game.stopGame();
    }

    public void rotate180() {
    }

    public void rotate90() {
    }
}
