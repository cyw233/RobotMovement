import java.util.Arrays;
import java.util.List;

public class Game {

    ToyRobot robot;

    public Game(ToyRobot robot) {
        this.robot = robot;
    }


    /**
     * Evals and executes commands.
     */
    public String eval(String inputString) {

        List<String> commands = Arrays.asList(inputString.split(",[ ]*"));
        if (!isValidInput(commands)) {
            return "Invalid command";
        }

        Position startPos = robot.getPosition();
        for (int i = 0; i < commands.size(); i++) {
            String command = commands.get(i);

            char moveCmd = command.charAt(0);
            int moveTimes = Integer.parseInt(command.substring(1).trim());
            for (int j = 0; j < moveTimes; j++) {
                switch (moveCmd) {
                    case 'F':
                        Position fPosition = robot.getPosition().getForwardPosition();
                        robot.move(fPosition);
                        break;
                    case 'B':
                        Position bPosition = robot.getPosition().getBackPosition();
                        robot.move(bPosition);
                        break;
                    case 'L':
                        robot.rotateLeft();
                        break;
                    case 'R':
                        robot.rotateRight();
                        break;

                }
            }
        }

        Position endPos = robot.getPosition();
        String output = getDistance(startPos, endPos);

        // Reset the start position for next move
        robot.setPosition(robot.getPosition());
        return output;
    }

    /**
     * Returns the robot's distance from its starting point
     */
    public String getDistance(Position startPos, Position endPos) {

        return Math.abs(startPos.getX() - endPos.getX()) +
                Math.abs(startPos.getY() - endPos.getY()) + "";
    }

    /**
     * Check the validation of input commands
     */
    public boolean isValidInput(List<String> commands) {

        for (int i = 0; i < commands.size(); i++) {
            String command = commands.get(i);

            if (command == null || command.isEmpty()) {
                return false;
            }

            if (command.length() != 2) return false;

            if (!Character.isUpperCase(command.charAt(0)) ||
                    !Character.isDigit(command.charAt(1))) {
                return false;
            }
        }

        return true;
    }


}
