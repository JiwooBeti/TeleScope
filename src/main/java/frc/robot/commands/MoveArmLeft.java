package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class MoveArmLeft extends CommandBase {
    private double leftSpeed, rightSpeed;

    public MoveArmLeft(double leftSpeed, double rightSpeed) {
        addRequirements(RobotContainer.getArmLeft());
        this.leftSpeed= leftSpeed;
        this.rightSpeed=rightSpeed;
    }

    @Override
    public void initialize() {
        RobotContainer.getArmLeft().moveArm(leftSpeed, rightSpeed);
    }

    @Override
    public void execute() {
        RobotContainer.getArmLeft().moveArm(leftSpeed, rightSpeed);
    }

    @Override
    public boolean isFinished() {
        if(RobotContainer.getJoyStick().getRawButton(Constants.ARM_LEFT_LEFT_BUTTON) && RobotContainer.getArmLeft().leftLimit()) {
            return true;
        }
        if(RobotContainer.getJoyStick().getRawButton(Constants.ARM_LEFT_RIGHT_BUTTON) && RobotContainer.getArmLeft().rightLimit()) {
            return true;
        }

        return !(RobotContainer.getJoyStick().getRawButton(Constants.ARM_LEFT_LEFT_BUTTON) || RobotContainer.getJoyStick().getRawButton(Constants.ARM_LEFT_RIGHT_BUTTON));

    }


    @Override
    public void end(boolean interrupted) {
        RobotContainer.getArmLeft().stopArm();
    }
    
}
