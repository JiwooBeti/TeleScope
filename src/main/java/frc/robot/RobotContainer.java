// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj2.*;
// import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MoveArmLeft;
import frc.robot.commands.MoveArmRight;
import frc.robot.commands.MoveElevator;
import frc.robot.subsystems.ArmLeft;
import frc.robot.subsystems.ArmRight;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  //private static MotorController elevatorLeft, elevatorRight, armController;
  private static Joystick joy;

  private static Button elevatorUp, elevatorDown;

  //MotorController elevatorLeft, MotorController elevatorRight, 
 /* DigitalInput limitSwitchA, DigitalInput limitSwitchB, 
  Encoder encoderOne, Encoder encoderTwo)*/

  private static Elevator elevator;
  private static MotorController elevatorLeft, elevatorRight;
  private static DigitalInput elevatorLimitSwitchA, elevatorLimitSwitchB;
  private static Encoder elevatorEncoderOne, elevatorEncoderTwo;

  private static ArmLeft armLeft;
  private static MotorController armLeftLeft, armLeftRight;
  private static DigitalInput armLeftLimitLeft, armLeftLimitRight;
  private static Button armLeftLeftButton, armLeftRightButton;

  private static ArmRight armRight;
  private static MotorController armRightLeft, armRightRight;
  private static DigitalInput armRightLimitLeft, armRightLimitRight;
  private static Button armRightLeftButton, armRightRightButton;




  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings

    elevatorLeft = new WPI_VictorSPX(Constants.ELEVATOR_LEFT);
    elevatorRight = new WPI_VictorSPX(Constants.ELEVATOR_RIGHT);
    elevatorLimitSwitchA = new DigitalInput(Constants.ELEVATOR_LIMIT_A);
    elevatorLimitSwitchB = new DigitalInput(Constants.ELEVATOR_LIMIT_B);
    elevatorEncoderOne = new Encoder(Constants.ELEVATOR_ENCODER1_1, Constants.ELEVATOR_ENCODER1_2);
    elevatorEncoderTwo = new Encoder(Constants.ELEVATOR_ENCODER2_1, Constants.ELEVATOR_ENCODER2_2);

    elevator = new Elevator(elevatorLeft, elevatorRight, elevatorLimitSwitchA, elevatorLimitSwitchB, elevatorEncoderOne, elevatorEncoderTwo);


    armLeftLeft = new WPI_VictorSPX(Constants.ARM_LEFT_LEFT);
    armLeftRight = new WPI_VictorSPX(Constants.ARM_LEFT_RIGHT);
    armLeftLimitLeft = new DigitalInput(Constants.ARM_LEFT_LIMIT_LEFT);
    armLeftLimitRight = new DigitalInput(Constants.ARM_LEFT_LIMIT_RIGHT);
    armLeft = new ArmLeft(armLeftLeft, armLeftRight, armLeftLimitLeft, armLeftLimitRight);

    armRightLeft = new WPI_VictorSPX(Constants.ARM_RIGHT_LEFT);
    armRightRight = new WPI_VictorSPX(Constants.ARM_RIGHT_RIGHT);
    armRightLimitLeft = new DigitalInput(Constants.ARM_RIGHT_LIMIT_LEFT);
    armRightLimitRight = new DigitalInput(Constants.ARM_RIGHT_LIMIT_RIGHT);
    armRight = new ArmRight(armRightLeft, armRightRight, armRightLimitLeft, armRightLimitRight);
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    joy = new Joystick(-1);

    armLeftLeftButton = new JoystickButton(joy, Constants.ARM_LEFT_LEFT_BUTTON);
    armLeftRightButton = new JoystickButton(joy, Constants.ARM_LEFT_RIGHT_BUTTON);
    armRightLeftButton = new JoystickButton(joy, Constants.ARM_RIGHT_LEFT_BUTTON);
    armRightRightButton = new JoystickButton(joy, Constants.ARM_RIGHT_RIGHT_BUTTON);

    elevatorUp = new JoystickButton(joy, Constants.ELEVATOR_UP_BUTTON);
    elevatorDown = new JoystickButton(joy, Constants.ELEVATOR_DOWN_BUTTON);

    elevatorUp.whileHeld(new MoveElevator(Constants.ELEVATOR_SPEED, -Constants.ELEVATOR_SPEED));
    elevatorDown.whileHeld(new MoveElevator(-Constants.ELEVATOR_SPEED, Constants.ELEVATOR_SPEED));

    //up.whileHeld(new MoveTeleArmVert(Constants.ELEVATOR_SPEED, -Constants.ELEVATOR_SPEED));
    armLeftLeftButton.whileHeld(new MoveArmLeft(Constants.ARM_LEFT_SPEED_LEFT, Constants.ARM_LEFT_SPEED_RIGHT));
    armLeftRightButton.whileHeld(new MoveArmLeft(-Constants.ARM_LEFT_SPEED_LEFT, -Constants.ARM_LEFT_SPEED_RIGHT));


    armRightLeftButton.whileHeld(new MoveArmRight(Constants.ARM_RIGHT_SPEED_LEFT, Constants.ARM_RIGHT_SPEED_RIGHT));
    armRightRightButton.whileHeld(new MoveArmRight(-Constants.ARM_RIGHT_SPEED_LEFT, -Constants.ARM_RIGHT_SPEED_RIGHT));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
  
  public static Joystick getJoyStick() {
    return joy;
  }

  public static Elevator getElevator() {
    return null;
  }

  public static ArmLeft getArmLeft() {
    return armLeft;
  }

  public static ArmRight getArmRight() {
    return armRight;
  }
}