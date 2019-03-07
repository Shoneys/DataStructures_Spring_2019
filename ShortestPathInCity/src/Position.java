import java.util.ArrayList;
import java.util.List;

public class Position {
    private int street;
    private int ave;

    public Position(int s, int a) {
        street = s;
        ave = a;
    }

    public List<Position> nextPositions() {
        ArrayList<Position> positions = new ArrayList<Position>();
        if (street % 2 == 0) {
            // street is going west
            if (ave > 1) {
                positions.add(new Position(street, ave + 1));
            }
        } else {
            // street is going east
            if (ave < 10) {
                positions.add(new Position(street, ave - 1));
            }
        }

        if (ave % 2 == 0) {
            // ave is going south
            if (street < 100) {
                positions.add(new Position(street - 1, ave));
            }
        } else {
            // ave is going north
            if (street > 1) {
                positions.add(new Position(street + 1, ave));
            }
        }

        return positions;
    }

    public String toString() {
        return street + " st and " + ave + " avenue";
    }

    public boolean equals(Object o) {
        if (! (o instanceof Position)) {
            return false;
        }

        Position other = (Position) o;
        return street == other.street && ave == other.ave;
    }

    public int hashCode() {
        return 31 * street + ave;
    }
}
