public class ToyRobot {

    private Position position;

    public ToyRobot() {
    }

    public ToyRobot(Position position) {
        this.position = position;
    }

    public boolean setPosition(Position position) {

        this.position = position;
        return true;
    }

    public boolean move() {
        return move(position.getNextPosition());
    }

    public boolean move(Position newPosition) {

        // change position
        this.position = newPosition;
        return true;
    }


    public Position getPosition() {
        return this.position;
    }

    public boolean rotateLeft() {

        this.position.direction = this.position.direction.leftDirection();
        return true;
    }

    public boolean rotateRight() {

        this.position.direction = this.position.direction.rightDirection();
        return true;
    }

}
