package de.unistuttgart.iste.rss.oo.hamstersimulator.exercise9.presence.datastructures;

import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.Hamster;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Location;
import de.unistuttgart.iste.rss.oo.hamstersimulator.external.model.Territory;
import de.unistuttgart.iste.rss.oo.hamstersimulator.datatypes.Direction;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/**
 * Write a description of class MemoryHamster here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MemoryHamster extends SimpleHamsterGame{


    public MemoryHamster(){
    	File terFile = new File("territories/territory-ub8.ter");
		try {
			InputStream targetStream = new FileInputStream(terFile);
			game.initialize(targetStream);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		game.displayInNewGameWindow();
    }


    public void reverseOrder(){
    	paule.move();

    }

    public void inOrder(){

    }
    
    public static void main(String[] args) {
    	// needs to be filled by you
    }
} 