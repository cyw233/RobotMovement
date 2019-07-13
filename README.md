# RobotMovement

This is a command line Java application that can parse commands and display the the minimum amount of distance for a robot to get back to the starting point.

## Design

- The application assumes that the robot moving on a infinite rectangular coordinate system.
- The robot has four directions: North, South, West and East. 
- The robot always has a coordiante while moving.
- The application uses the formula `|x1 - x2| + |y1 -y2|` to calculate the minimum amount of distance for a robot to get back to the starting point.

- Users will be notified for any incorrect input command and the invalid input will be ignored.

## Example Input and Output:

1)

```
Input: F1,R1,B2,L1,B3

Output: 4
```

2)

```
Input: F5, R2, B3, L3, B2

Output: 10
```

3)

```
Input: f2, R2

Output: Error: Move command must be F, B, R or L
				Robot didn't move due to the invalid command.
```

## Compile and Run

**Method 1:** 

Directly compile and run the java files.

```bash
# cd to the src folder
cd RobotMovement/src

# Compile all java files in the folder
javac *.java

# Run
java Main
```



**Method 2:** 

Additionally, you can run the jar file that sits inside the RobotMovement folder

```bash
cd RobotMovement
java -jar RobotMovement.jar
```

