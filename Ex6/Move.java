/**
 * Created by adi on 7/20/2017.
 */
class Move {
    private int origin;
    private int destination;

    public Move(int moveFrom, int moveTo) {
        this.origin = moveFrom;
        this.destination = moveTo;
    }
    public int getOrigin(){
        return origin;
    }

    public int getDestination(){
        return destination;
    }

    @Override
    public boolean equals(Object move) {
        if(this.origin == ((Move) move).origin && this.destination == ((Move) move).destination) {
            return true;
        }
        return false;
    }
}
