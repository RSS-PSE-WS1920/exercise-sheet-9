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
	 * @return the winning hamster: The hamster which picks the grain at the end of
	 *         the territory first.
	 * 
	 * @requires !racers.empty()
	 * @requires for all hamsters there is a grain in the direction
	 *           aHamster.getDirection()
	 * @requires for all hamsters there is no wall inbetween aHamster.getLocation()
	 *           and the grain
	 * 
	 */

	private void doRace() {

		assert (!racers.isEmpty());

		Hamster winner = null;

		while (winner == null) {

			performRound();
			checkWinner();
		}
	}

	private void checkWinner() {
		for (final RacingHamster aHamster : racers) {
			if(!aHamster.mouthEmpty()) {
				winner = aHamster;
			}
		}
		
	}

	private void performRound() {
		for (final RacingHamster aHamster : racers) {

			aHamster.doRaceMove();

		}
	}
}
