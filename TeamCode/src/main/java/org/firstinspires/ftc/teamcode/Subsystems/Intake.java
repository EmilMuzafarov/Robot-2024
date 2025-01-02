package Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {
    private DcMotor intakeMotor;

    // Constructor to initialize the intake motor
    public Intake(HardwareMap hardwareMap) {
        intakeMotor = hardwareMap.get(DcMotor.class, "intake_motor");
        intakeMotor.setDirection(DcMotor.Direction.FORWARD);
    }

    // Intake operation
    public void runIntake(double power) {
        intakeMotor.setPower(power);
    }

    // Stop intake motor
    public void stop() {
        intakeMotor.setPower(0);
    }
}
