package de.unistuttgart.iste.rss.oo.hamstersimulator.exercise9.presence.race;

import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.Hamster;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Location;
import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.Territory;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Direction;

public abstract class RacingHamster extends Hamster
{
    public RacingHamster(){
        super();
    }
    
    public RacingHamster(Territory ter, Location loc, Direction dir, int grainsInMouth) {
        super(ter, loc, dir, grainsInMouth);
    }
    
    protected void pickGrainIfAvailable(){
        if(grainAvailable()){
            pickGrain();
        }
    }
    
    protected void moveIfFrontIsClear(){
        if(frontIsClear()){
            move();
        }
    }
    
    /**
     * The race move is a special move every hamster learns in racing school. 
     * It contains a combination of move and pick grain comands. The actual 
     * characteristics of the move is different for each racing hamster type.
     */
    abstract protected void doRaceMove();
}
