//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Dragon treasure program tester
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

/**
 * This is the Dragon treasure tester  class which contains tester methods for the entire game.
 */
public class DragonTreasureTester {

    /**
     * This method tests all the instance methods of the Room class.
     *
     * @return True if all tests pass and false if not.
     */
    public static boolean testRoomInstanceMethods(){
        Room tester = new Room(20,"Good"); //testing room
        Room testAdd = new Room(40,"Decent"); // testing room to add

        try{
            if(tester.getID() != 20){
                return false; // checks if ID is the same by using getID
            }

            tester.setRoomType(RoomType.TREASURE);
            if(tester.getType() != RoomType.TREASURE){
                return false; // checks if room type is same by using getType
            }

            tester.addToAdjacentRooms(testAdd);
            int a = 0; // int variable to check if the room is adjacent
            for(int i = 0;i<tester.getAdjacentRooms().size();i++){
                if(tester.getAdjacentRooms().get(i).equals(testAdd)){
                    a = 1;
                    break;
                }
            }
            if(a == 0){
                return false; // checks if the room appeared in the adjacent room list
            }
            if(tester.isAdjacent(testAdd) != true){
                return false; // checks if room to add is in the adjacent rooms list.
            }
        }catch(Exception e){
            // an unexpected exception was thrown
            e.printStackTrace(); // this will help locate the source of the bug
            return false;
        }
        return true;
    }

    /**
     * This method checks the correctness of alll static methods in the Room class.
     *
     * @return True if all tests pass and false if not.
     */
    public static boolean testRoomStaticMethods(){
        if(!Room.getPortalWarning().equals("You feel a distortion in space nearby.\n")){
            return false;
        }
        if(!Room.getTreasureWarning().equals("You sense that there is treasure nearby.\n")){
            return false;
        }
        Room tester = new Room(30,"Good"); // tester room object
        tester.assignTeleportLocation(20);
        if(tester.getTeleportationRoom() != 20){
            return false; // checks if getTeleportLocationRoom works after assigning the particular value
        }
        return true;
    }

    /**
     * This method checks the correctness of the canMoveTo method from the Player class.
     *
     * @return True if all tests pass and false if not.
     */
    public static boolean testPlayerCanMoveTo(){
        Room tester = new Room(20,"Good");
        Room testAdd = new Room(40,"Decent"); // room objects for testing purposes

        tester.addToAdjacentRooms(testAdd); // adds test room to adjacent list
        Player one = new Player(tester); // sets the player to tester room

        if(one.canMoveTo(testAdd) != true){
            return false;
        }
        return true;
    }

    /**
     * This method checks the correctness of the shouldTeleport method of the Player class.
     *
     * @return True if all tests pass and false if not.
     */
    public static boolean  testPlayerShouldTeleport(){
        Room tester = new Room(20,"Good");
        tester.setRoomType(RoomType.PORTAL);

        Player one = new Player(tester);

        if(one.shouldTeleport() != true){
            return false;
        }
        return true;
    }

    /**
     * This method tests the correctness of the isPortalNearby and isTreasureNearby methods of
     * the Player class.
     *
     * @return True if all tests pass and false if not.
     */
    public static boolean testPlayerDetectNearbyRooms(){
        Room tester = new Room(20,"Good");
        Room testAdd = new Room(40,"Decent"); // room objects for testing

        testAdd.setRoomType(RoomType.PORTAL); // sets room type to portal

        Room testR = new Room(30,"Gold");
        testR.setRoomType(RoomType.TREASURE); // sets room type to treasure

        Player one = new Player(tester); // sets player to a normal testing room

        tester.addToAdjacentRooms(testAdd);
        tester.addToAdjacentRooms(testR); // adds the special rooms to adjacent rooms list

        if(one.isTreasureNearby() != true){
            return false;
        }
        if(one.isPortalNearby() != true){
            return false;
        }
        return true; // no bugs in both methods
    }

    /**
     * This method checks the correctness of the changeRooms method in the Dragon class.
     *
     * @return True if all tests pass and false if not.
     */
    public static boolean testDragonChangeRooms(){
        Room tester = new Room(20,"Good");
        tester.setRoomType(RoomType.TREASURE); // sets type of tester room to treasure

        try{
            Dragon drago = new Dragon(tester);// dragon object

            Room testing = new Room(20,"Good");
            testing.setRoomType(RoomType.PORTAL);// sets type of testing room to portal

            tester.addToAdjacentRooms(testing);//

            drago.changeRooms();// changes the room the dragon is

            if(drago.getCurrentRoom().equals(testing)) {
                return false; // checks if the dragon can move to a portal room or not
            }
        } catch(Exception e){
            // an unexpected exception was thrown
            e.printStackTrace(); // this will help locate the source of the bug
            return false;
        }
        return true; // no bug detected
    }


}
