//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Player class
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

import java.util.ArrayList;

/**
 * This is the PLayer class which sets the player conditions in the game.
 */
public class Player {
    private Room currentRoom; //current location of the player

    /**
     * This is the constructor for the player class which sets the current room the player is in.
     * @param currentRoom
     */
    public Player(Room currentRoom){
        this.currentRoom = currentRoom;
    }

    /**
     * This method gets the current room of the player as defined in the construcctor.
     *
     * @return Current room of the player
     */
    public Room getCurrentRoom(){
        return currentRoom;
    }

    /**
     * This method gets the list of adjacent rooms to the one the player is in.
     *
     * @return List of adjacent rooms
     */
    public ArrayList<Room> getAdjacentRoomsToPlayer(){
        return getCurrentRoom().getAdjacentRooms();
    }

    /**
     * This method changes the current room of a player to the desired room.
     *
     * @param newRoom New room that the player will enter
     */
    public void changeRoom(Room newRoom){
        currentRoom = newRoom;
    }

    /**
     * This method checks whether it woould be legal for the player to move to the selected room.
     *
     * @param destination Desired room
     * @return True if the player can move there and false if not.
     */
    public boolean canMoveTo(Room destination) {
        for (int i = 0; i < getAdjacentRoomsToPlayer().size(); i++) {
            if (getAdjacentRoomsToPlayer().get(i).equals(destination)) {
                return true;
            }
        }
            return false;
    }

    /**
     * This method checks whether the player can teleport or not
     * based on if the room is a portal room.
     *
     * @return True if the player is in a portal room and false if not.
     */
    public boolean shouldTeleport(){
        if(currentRoom.getType() == RoomType.PORTAL){
            return true;
        }
        return false;
    }

    /**
     * This method tells us if a portal is nearby or not.
     *
     * @return True if a portal room is adjacent and false if not.
     */
    public boolean isPortalNearby(){
        for(int i = 0;i<getAdjacentRoomsToPlayer().size();i++){
            if(getAdjacentRoomsToPlayer().get(i).getType() == RoomType.PORTAL){
                return true;
            }
        }
        return false;
    }

    /**
     * This method tells us if the treasure is nearby or not.
     *
     * @return True if the treasure room is adjacent and false if not.
     */
    public boolean isTreasureNearby() {
        for (int i = 0; i < getAdjacentRoomsToPlayer().size(); i++) {
            if (getAdjacentRoomsToPlayer().get(i).getType() == RoomType.TREASURE) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method tells us if the dragon is nearby or not.
     *
     * @return True if the dragon is adjacent and false if not.
     */
    public boolean isDragonNearby(Dragon d){
        for (int i = 0; i < getAdjacentRoomsToPlayer().size(); i++) {
            if (getAdjacentRoomsToPlayer().get(i) == d.getCurrentRoom()) {
                return true;
            }
        }
        return false;
    }
}
