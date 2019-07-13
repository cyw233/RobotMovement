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
            return "Robot didn't move due to the invalid command.";
        }

        Position startPos = robot.getPosition();
        for (int i = 0; i < commands.size(); i++) {
            String command = commands.get(i);

            char moveCmd = command.charAt(0);
            int moveTimes = Integer.parseInt(command.substring(1));
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
        boolean isCompleteCommand = true;
        boolean isValidMove = true;
        boolean isValidNumber = true;

        for (int i = 0; i < commands.size(); i++) {
            String command = commands.get(i);

            if (command == null || command.isEmpty() || command.length() < 2) {
                System.out.println("Error: Found incomplete command!");
                isCompleteCommand = false;
                continue;
            }

            if (!"FBRL".contains(Character.toString(command.charAt(0)))) {
                System.out.println("Error: Move command must be F, B, R or L");
                isValidMove = false;
            }

            try {
                int moveTimes = Integer.parseInt(command.substring(1));
                if (moveTimes < 0) {
                    System.out.println("Error: Number command could not be negative!");
                    isValidNumber = false;
                }
            } catch (Exception e) {
                System.out.println("Error: Number command should be integer!");
                isValidNumber = false;
            }



        }

        return isCompleteCommand && isValidMove && isValidNumber;
    }


}
