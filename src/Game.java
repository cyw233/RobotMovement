import java.util.Arrays;
import java.util.List;

public class Game {

    ToyRobot robot;

    public Game(ToyRobot robot) {
        this.robot = robot;
    }


    /**
     * Evals and executes a string command.
     */
    public String eval(String inputString) {

        List<String> commands = Arrays.asList(inputString.split(",[ ]*"));
        if (!isValidInput(commands)) {
            return "Invalid command";
        }

        for (int i = 0; i < commands.size(); i++) {
            String command = commands.get(i);

            char moveCmd = command.charAt(0);
            int movTimes = command.charAt(1) - '0';
            for (int j = 0; j < movTimes; j++) {
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

        String output = getDistance();
        return output;
    }

    /**
     * Returns the X,Y and Direction of the robot
     */
    public String getDistance() {

        return Math.abs(robot.getPosition().getX()) +
                Math.abs(robot.getPosition().getY()) + "";
    }

    public boolean isValidInput(List<String> commands) {

        for (int i = 0; i < commands.size(); i++) {
            String command = commands.get(i);

            if (command.isEmpty() || command == null) {
                return false;
            }

            if (!Character.isLetter(command.charAt(0)) ||
                    !Character.isDigit(command.charAt(1))) {
                return false;
            }
        }

        return true;
    }


}
