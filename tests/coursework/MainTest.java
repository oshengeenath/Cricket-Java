package coursework;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainTest {
    Main main = new Main();
    ArrayList<Players> players = new ArrayList();
    ArrayList<Teams> teams = new ArrayList<>();
    @Test
    public void testSetTeams() {
        main.setTheTeams();
        assertNotNull(teams);
    }

    @Test
    public void testSetPlayers() {
        main.setTheTeams();
        assertNotNull(players);
    }

    @Test
    public void testTossOne(){
        int[] batFirstTossWon = main.startToss(1, 2);
        assertTrue((batFirstTossWon[0] == 1)||(batFirstTossWon[0] == 2));
    }


    @Test
    public void testTossTwo(){
        int[] batFirstTossWon = main.startToss(1, 2);
        assertTrue((batFirstTossWon[1] == 1)||(batFirstTossWon[1] == 2));
    }
}