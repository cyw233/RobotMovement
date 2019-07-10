import java.io.Console;


public class Main {

    public static void main(String[] args) {

        Console console = System.console();

        ToyRobot robot = new ToyRobot();
        Position position = new Position(0, 0, Direction.EAST);
        robot.setPosition(position);
        Game game = new Game(robot);

        System.out.println("Welcome! Please enter a string of comma-separated commands");
        System.out.println("For example: F1, R1, B2, L1, B3");


        while (true) {
            String inputString = console.readLine("Input: ");

            String outputVal = game.eval(inputString);
            System.out.println(outputVal);
        }

    }
}
