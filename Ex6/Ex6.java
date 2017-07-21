import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Ex6 {

    /**
     * The function receives 2 arrays and rearrange the first array to get the second one
     * @param parkingLot - an array that describe a parking lot with 1 space and N-1 cars in it
     * @param afterRearranging - an array that describe a parking lot after rearranging the cars
     * @return - a list of moves
     */
    public static List<Move> rearrangingCars (int[] parkingLot, int[] afterRearranging) {
        int emptySlot = findSlot(parkingLot, 0);
        int index = 0;
        List<Move> moves = new ArrayList<>();

        while(index < afterRearranging.length - 1) {

            if (parkingLot[index] == afterRearranging[index]) {
                index++;
                continue;
            }

            if (index != emptySlot) {
                swap(parkingLot, index, emptySlot, parkingLot[index]);
                moves.add(new Move(index, emptySlot));
                emptySlot = index;
            }

            int carSlot = findSlot(parkingLot, afterRearranging[index]);
            swap(parkingLot, emptySlot, carSlot, parkingLot[carSlot]);
            moves.add(new Move(carSlot, emptySlot));
            emptySlot = carSlot;
            index++;
        }
        return moves;
    }

    // The function receives an array that described parking lot and swapping between the elements
    private static void swap (int[] parkingLot, int from, int to, int carVal) {
        parkingLot[to] = carVal;
        parkingLot[from] = 0;
    }

    // The function receives an array the described a parking lot and return the slot index of the car.
    private static int findSlot(int[] parkingLot, int car){
        int slotIndex = 0;
        for (int i = 0; i < parkingLot.length; i++) {
            if (parkingLot[i] == car) {
                slotIndex = i;
                break;
            }
        }
        return slotIndex;
    }

    // The function receives a move list and print them
    public static void printMoves (List<Move> moves) {
        for (ListIterator<Move> iterator = moves.listIterator(); iterator.hasNext();) {
            Move currMove = iterator.next();
            System.out.println("move from " + currMove.getOrigin() + " to " + currMove.getDestination());
        }
    }
}
