package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class MoveTeleArmVert extends CommandBase {
    private double leftSpeed;
    private double rightSpeed;

    public MoveTeleArmVert(double leftSpeed, double rightSpeed) {
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
    }

    //hello


    @Override
    public void initialize() {
        RobotContainer.getTeleArm().moveElevator(leftSpeed, rightSpeed);
       //RobotContainer.getElevator().moveElevator(leftSpeed, rightSpeed);
    }

    @Override
    public void execute() {
        RobotContainer.getTeleArm().moveElevator(leftSpeed, rightSpeed);
        //System.out.println("hello there");

        if(leftSpeed < 0 && rightSpeed < 0) {
            if(RobotContainer.getTeleArm().isLimitSwitchAPressed()) {
                RobotContainer.getTeleArm().stopElevator();
            } 
        }

        if(leftSpeed > 0 && rightSpeed > 0) {
                        

            if(RobotContainer.getTeleArm().isEncoderLimitReached()) {
                //this checks both encoder limits
    
                RobotContainer.getTeleArm().stopElevator();
            }
        }


    }

    @Override
    public boolean isFinished() {
        if(RobotContainer.getJoyStick().getRawButton(Constants.UP_BUTTON) || RobotContainer.getJoyStick().getRawButton(Constants.DOWN_BUTTON)) {
           return false;
        } else {
            return true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        RobotContainer.getTeleArm().stopElevator();
    }

}
