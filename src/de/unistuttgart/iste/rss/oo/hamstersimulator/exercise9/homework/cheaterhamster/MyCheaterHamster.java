package de.unistuttgart.iste.rss.oo.hamstersimulator.exercise9.homework.cheaterhamster;

import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.Hamster;
import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.HamsterGame;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Direction;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Location;
import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.Territory;

public class MyCheaterHamster extends Hamster
{

    public MyCheaterHamster(final Territory territory, final Location location,
                   final Direction direction, final int newGrainCount) {
        super(territory, location, direction, newGrainCount);
    }
    
    @Override
    public void move(){
        super.move();
        super.move();
    }

}

