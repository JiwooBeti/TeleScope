package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmRight extends SubsystemBase {

    private MotorController armLeft, armRight;
    private DigitalInput limitSwitchLeft, limitSwitchRight;

    public ArmRight(MotorController armLeft, MotorController armRight, DigitalInput limitSwitchLeft, DigitalInput limitSwitchRight) {
        this.armLeft = armLeft;
        this.armRight = armRight;
        this.limitSwitchLeft = limitSwitchLeft;
        this.limitSwitchRight = limitSwitchRight;
    }

    public void moveArm(double leftSpeed, double rightSpeed) {
        armLeft.set(leftSpeed);
        armRight.set(rightSpeed);
    }

    public boolean leftLimit() { return limitSwitchLeft.get();}

    public boolean rightLimit() { return limitSwitchRight.get();}

    public void stopArm() {
        armLeft.set(0);
        armRight.set(0);
    }
}
