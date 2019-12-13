package de.unistuttgart.iste.rss.oo.hamstersimulator.exercise9.presence.race;

import java.util.HashSet;
import java.util.Set;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.Hamster;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Location;
import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.Territory;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Direction;

/**
 * This class represents a HamsterRaceGame. It comes with a specific territory
 * and owns a list of racers.
 * 
 * @invariant racers != null.
 * 
 * @author mfrank
 *
 */
public class HamsterRaceGame extends SimpleHamsterGame {

	private final Set<RacingHamster> racers;
	private Hamster winner;

	public HamsterRaceGame() {

		File terFile = new File("territories/racetrack.ter");
		try {
			InputStream targetStream = new FileInputStream(terFile);
			game.initialize(targetStream);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		game.displayInNewGameWindow();
		racers = new HashSet<RacingHamster>();
	}

	@Override
	protected void run() {
		initRace();
		doRace();
		getWinner().write("Wuhu I won!");
	}

	/**
	 * Return the winner of the race
	 * 
	 * @requires doRace() has been called.
	 * 
	 * @return winner of the race.
	 * @throws IllegalStateException if there is no winner available and doRace has
	 *                               not been called.
	 */
	private Hamster getWinner() throws IllegalStateException {
		if (winner == null) {
			throw new IllegalStateException("Hamster race must be performed first");
		}
		return winner;
	}

	/**
	 * This method inits the race an places two new Hamsters on the start line (2,0)
	 * and (4,0)
	 * 
	 * @requires territory.getSize.getRows > 3
	 * @requires territory.getSize.getColums > 1
	 * @requires no wall at Location 2,0
	 * @requires no wall at Location 4,0
	 * @ensures there exist a Hamster at Location 2,0
	 * @ensures there exist a Hamster at Location 4,0
	 */

	private void initRace() {
		// init Hamster normal on field 2,0
		// init Hamster fast on fild 4,0

		// add Hamster as racer

	}

	/**
	 * This method performs the race. It iterates over the set of hamsters and calls
	 * alternating the methode doRaceMove on a hamster. Scheduling is round robin.
	 * 
	 * @requires for all hamsters there is a grain in the direction
	 *           aHamster.getDirection()
	 * @requires for all hamsters there is no wall inbetween aHamster.getLocation()
	 *           and the grain
	 * 
	 */

	private void doRace() {

		while (winner == null) {
			performRound();
			setWinnerIfAvailable();
		}
	}

	/**
	 * This method checks if there is a hamster which has a grain in it's mouth. If
	 * there is, it sets the hamster as winner. If there are multible hamsters which
	 * have a grain in its mouth. It will declare the last hamster in the racers
	 * list as winner - might not be the first one to pick a grain.
	 * 
	 * @ensures if there is at least one hamster with a grain in its mouth, then the
	 *          last hamster, which has a grain in its mouth, will be set as winner.
	 */
	private void setWinnerIfAvailable() {
		for (final RacingHamster aHamster : racers) {
			if (!aHamster.mouthEmpty()) {
				winner = aHamster;
			}
		}
	}

	/**
	 * Moves every hamster in the racers list by calling doRaceMove on the hamster
	 * 
	 * @requires !racers.empty()
	 * @ensures aRacer.doRaceMove() has been called.
	 * @see doRace();
	 */
	private void performRound() {
		assert (!racers.isEmpty());
		for (final RacingHamster aHamster : racers) {
			aHamster.doRaceMove();

		}
	}
}
