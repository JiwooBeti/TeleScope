package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TeleArm extends SubsystemBase {
    private MotorController elevatorLeft, elevatorRight, armController;
    private DigitalInput limitSwitchA;
    private Encoder encoderOne, encoderTwo;
    private double leftSpeed, rightSpeed, armSpeed;

    public TeleArm(MotorController elevatorLeft, MotorController elevatorRight, MotorController armController, DigitalInput limitSwitchA,Encoder encoderOne, Encoder encoderTwo) {
        this.elevatorLeft = elevatorLeft;
        this.elevatorRight = elevatorRight;
        this.armController = armController;
        this.limitSwitchA = limitSwitchA;
       // this.limitSwitchB = limitSwitchB;
        this.encoderOne = encoderOne;
        this.encoderTwo = encoderTwo;
    }

    public void moveElevator(double leftSpeed, double rightSpeed) {
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
        elevatorLeft.set(leftSpeed);
        elevatorRight.set(rightSpeed);
    }

    public void moveArm(double armSpeed) {
        this.armSpeed = armSpeed;
        armController.set(armSpeed);
    }

    public void stopElevator() {
        elevatorLeft.stopMotor();
        elevatorRight.stopMotor();
    }

    public boolean isLimitSwitchAPressed() {
        return !limitSwitchA.get();
    }

    /*public boolean isLimitSwitchBPressed() {
        return !limitSwitchB.get();
    }*/


    public boolean isEncoderLimitReached() {
        if(encoderOne.getDistance() >= Constants.ENCODER_ONE_LIMIT || encoderTwo.getDistance() <= Constants.ENCODER_TWO_LIMIT) {
            return true;
        } return false;
    }

    public double getLeftMotorSpeed() {
        return leftSpeed;
    }

    public double getRightMotorSpeed() {
        return rightSpeed;
    }
}
