//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Room class
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
 * This is the room class which sets the methods of a room in the game.
 */
public class Room {
    private RoomType type; //one of the four types a room could be
    private String roomDescription; //a brief description of the room
    private ArrayList<Room> adjRooms; //arraylist that holds the rooms adjacent
    private final int ID; //unique ID for each room to identify it
    private static int teleportLocationID; //place where all portal rooms will go to
    private static final String PORTAL_WARNING = "You feel a distortion in space nearby.\n"; // A warning for when a portal is nearby
    private static final String TREASURE_WARNING = "You sense that there is treasure nearby.\n"; // A warning for when the treasure is nearby

    /**
     * This is the constructor for the room class.
     *
     * @param id The unique id assigned to each room through constructor arguments.
     * @param roomDescription The unique description assigned to each room through constructor arguments.
     */
    public Room(int id,String roomDescription){
        ID = id;
        type = RoomType.NORMAL;
        this.roomDescription = roomDescription;
        adjRooms = new ArrayList<Room>(); // initialises the adjacent rooms array list
    }

    /**
     * This method gets the type of the room.
     * @return Room type
     */
    public RoomType getType(){
        return type;
    }

    /**
     * This method gets the ID of the room declared the constructor.
     *
     * @return Room ID
     */
    public int getID(){
        return ID;
    }

    /**
     * This method gives us the list of adjacent rooms to the current room.
     *
     * @return List of adjacent rooms.
     */
    public ArrayList<Room> getAdjacentRooms(){
        return adjRooms;
    }

    /**
     * This method returns the room description that was declared in the room constructor.
     *
     * @return Room description
     */
    public String getRoomDescription(){
        return roomDescription;
    }

    /**
     * Gets portal warning from the private field.
     *
     * @return Portal warning
     */
    public static String getPortalWarning(){
        return PORTAL_WARNING;
    }

    /**
     * Gets treasure warning from the private field.
     *
     * @return Treasure warning
     */
    public static String getTreasureWarning(){
        return TREASURE_WARNING;
    }

    /**
     * This method gets the ID of the room to be teleported to
     *
     * @return Teleport location ID
     */
    public static int getTeleportationRoom(){
        return teleportLocationID;
    }

    /**
     * This method adds a particular room to the list of adjacent rooms.
     *
     * @param toAdd Room to be added to the list
     */
    public void addToAdjacentRooms(Room toAdd){
        adjRooms.add(toAdd);
    }

    /**
     * This method sets the room type as the input type.
     *
     * @param newType New room type
     */
    public void setRoomType(RoomType newType){
        type = newType;
    }

    /**
     * This method assigns the ID of the room to be teleported to.
     *
     * @param teleportID ID of the new room
     */
    public static void assignTeleportLocation(int teleportID){
        teleportLocationID = teleportID;
    }

    /**
     * This method checks whether a room is adjacent to the current room or not.
     *
     * @param newRoom The room we check for being adjacent to the current one
     * @return true if the newRoom is adjacent and false if not.
     */
    public boolean isAdjacent(Room newRoom){
        for(int i = 0;i<adjRooms.size();i++){
            if(adjRooms.get(i) == newRoom){
                return true;
            }
        }
        return false;
    }

    /** Determines if the given object is equal to this room.
     * They are equal if other is a Room and their IDs are the same.
     * @param other, another object to check if it is equal to this
     * @return true if the two rooms are equal, false otherwise
     * @author Michelle */
    @Override
    public boolean equals(Object other){
        if(other instanceof Room) {
            Room otherRoom = (Room)other;
            return this.ID == otherRoom.ID;
        }
        return false;
    }
    /** Returns a String representation of this room.
     * @return the string representation of this room and,
     * it’s object data field values
     * @author Michelle*/
    @Override
    public String toString(){
        String s = this.ID +": " + this.roomDescription+ " (" + type +")\n Adjacent Rooms: ";
        for(int i = 0; i<adjRooms.size(); i++){
            s+= adjRooms.get(i).ID +" ";
        }
        return s;
    }
}
