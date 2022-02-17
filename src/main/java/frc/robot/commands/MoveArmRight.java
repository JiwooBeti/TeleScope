package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class MoveArmRight extends CommandBase {
    private double leftSpeed, rightSpeed;

    public MoveArmRight(double leftSpeed, double rightSpeed) {
        addRequirements(RobotContainer.getArmRight());
        this.leftSpeed= leftSpeed;
        this.rightSpeed=rightSpeed;
    }

    @Override
    public void initialize() {
        RobotContainer.getArmRight().moveArm(leftSpeed, rightSpeed);
    }

    @Override
    public void execute() {
        RobotContainer.getArmRight().moveArm(leftSpeed, rightSpeed);
    }

    @Override
    public boolean isFinished() {
        if(RobotContainer.getJoyStick().getRawButton(Constants.ARM_RIGHT_LEFT_BUTTON) && RobotContainer.getArmRight().leftLimit()) {
            return true;
        }
        if(RobotContainer.getJoyStick().getRawButton(Constants.ARM_RIGHT_RIGHT_BUTTON) && RobotContainer.getArmRight().rightLimit()) {
            return true;
        }

        return !(RobotContainer.getJoyStick().getRawButton(Constants.ARM_RIGHT_LEFT_BUTTON) || RobotContainer.getJoyStick().getRawButton(Constants.ARM_RIGHT_RIGHT_BUTTON));

    }


    @Override
    public void end(boolean interrupted) {
        RobotContainer.getArmRight().stopArm();
    }
    
}
