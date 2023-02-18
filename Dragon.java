//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Dragon class
// Course:   CS 300 Fall 2022
//
// Author:   Chaitanya Sharma
// Email:    csharma4@wisc.edu
// Lecturer: Mouna Kacem
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: None
// Online Sources:  None

///////////////////////////////////////////////////////////////////////////////
import java.util.Random;

/**
 * This is the Dragon class which makes a dragon character for the game.
 */
public class Dragon {
    private Room currentRoom; //current location of the dragon
    private Random randGen; //random num generator used for moving
    private static final String DRAGON_WARNING = "You hear a fire breathing nearby!\n"; //dragon warning for when its near

    /**
     * This is the constructor for the dragon class.
     *
     * @param currentRoom The current room the dragon is in.
     */
    public Dragon(Room currentRoom){
        this.currentRoom = currentRoom;
        int rooms = currentRoom.getAdjacentRooms().size();
        randGen = new Random();
    }

    /**
     * This method gets the current room the dragon is in.
     *
     * @return Currenr room
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * This method gets the warning for when the dragon is near.
     *
     * @return Dragon warning
     */
    public static String getDragonWarning(){
        return DRAGON_WARNING;
    }

    /**
     * This method changes the dragons room to a random room adjacent to it based
     * on if it is a portal room or not.
     */
    public void changeRooms(){
        int rooms = currentRoom.getAdjacentRooms().size();
        int randRoom = randGen.nextInt(rooms);
        if(getCurrentRoom().getAdjacentRooms().get(randRoom).getType() != RoomType.PORTAL){
            currentRoom = getCurrentRoom().getAdjacentRooms().get(randRoom);
        } else {
            changeRooms();
        }
    }
}
