public class Position {
    int x;
    int y;
    Direction direction;

    public Position(Position position) {
        this.x = position.getX();
        this.y = position.getY();
        this.direction = position.getDirection();
    }

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void change(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    public Position getForwardPosition() {

        // new position to validate
        Position newPosition = new Position(this);
        switch (this.direction) {
            case NORTH:
                newPosition.change(0, 1);
                break;
            case EAST:
                newPosition.change(1, 0);
                break;
            case SOUTH:
                newPosition.change(0, -1);
                break;
            case WEST:
                newPosition.change(-1, 0);
                break;
        }
        return newPosition;
    }

    public Position getBackPosition() {

        // new position to validate
        Position newPosition = new Position(this);
        switch (this.direction) {
            case NORTH:
                newPosition.change(0, -1);
                break;
            case EAST:
                newPosition.change(-1, 0);
                break;
            case SOUTH:
                newPosition.change(0, 1);
                break;
            case WEST:
                newPosition.change(1, 0);
                break;
        }
        return newPosition;
    }
}
