import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.Hamster;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Location;
import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.Territory;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Direction;
import java.io.IOException;

/**
 * Write a description of class SortingHamsterGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SortingHamsterGame extends SimpleHamsterGame {

    public SortingHamsterGame() {
        game.displayInNewGameWindow();
        try {
            game.initialize("/territories/sorting.ter");

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected void run(){
        // call your sorting method here
    }

    public void main(){
        game.startGame(false);
        doRun();
        game.stopGame();
    }
}
