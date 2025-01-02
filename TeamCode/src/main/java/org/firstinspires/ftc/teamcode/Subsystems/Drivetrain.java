package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Drivetrain {

    private DcMotor leftMotor;
    private DcMotor rightMotor;

    // Constructor to initialize the motors
    public Drivetrain(HardwareMap hardwareMap) {
        leftMotor = hardwareMap.get(DcMotor.class, "left_motor");
        rightMotor = hardwareMap.get(DcMotor.class, "right_motor");

        // Set motor directions if needed
        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    // Drive forward at a given speed
    public void driveForward(double power) {
        leftMotor.setPower(power);
        rightMotor.setPower(power);
    }

    // Turn the robot (positive value for right turn, negative for left turn)
    public void turn(double power) {
        leftMotor.setPower(-power);
        rightMotor.setPower(power);
    }

    // Stop all motors
    public void stop() {
        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }

    // Move robot backward (optional)
    public void driveBackward(double power) {
        leftMotor.setPower(-power);
        rightMotor.setPower(-power);
    }
}
2. Updated TestMovement Autonomous Class:
Now we will modify the TestMovement class so that it utilizes the new Drivetrain class methods to drive the robot forward, turn, and stop.

java
Copy code
package org.firstinspires.ftc.teamcode.OpMode.AutoCommands;

import Subsystems.Drivetrain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Test Movement", group="Test")
public class TestMovement extends OpMode {

    // Declare a Drivetrain object
    Drivetrain drivetrain;

    // Create a timer for autonomous actions
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {
        // Initialize the drivetrain subsystem
        drivetrain = new Drivetrain(hardwareMap);
    }

    @Override
    public void start() {
        // Reset the runtime timer when autonomous starts
        runtime.reset();
    }

    @Override
    public void loop() {
        // Example: Drive the robot forward for 2 seconds
        if (runtime.seconds() < 2.0) {
            drivetrain.driveForward(0.5);  // Drive forward at 50% power
        }
        // After 2 seconds, stop the robot
        else if (runtime.seconds() < 3.0) {
            drivetrain.stop();  // Stop the robot
        }
        // Turn the robot to the right for 2 seconds
        else if (runtime.seconds() < 5.0) {
            drivetrain.turn(0.5);  // Turn right at 50% power
        }
        // After 2 seconds, stop the robot
        else {
            drivetrain.stop();  // Stop the robot
        }
    }

    @Override
    public void stop() {
        // Stop all motors when the autonomous mode stops
        drivetrain.stop();
    }
}
