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
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MoveElevator;
import frc.robot.commands.MoveTeleArmVert;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.TeleArm;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.Button;

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
  private static DigitalInput limitSwitch;
  private static Encoder encoderOne, encoderTwo;
  private static TeleArm teleArm;
  private static Button up, down, right, left;
  private static Joystick joy;

  private static Button elevatorUp, elevatorDown;

  //MotorController elevatorLeft, MotorController elevatorRight, 
 /* DigitalInput limitSwitchA, DigitalInput limitSwitchB, 
  Encoder encoderOne, Encoder encoderTwo)*/

  private static Elevator elevator;
  private static MotorController elevatorLeft, elevatorRight;
  private static DigitalInput elevatorLimitSwitchA, elevatorLimitSwitchB;
  private static Encoder elevatorEncoderOne, elevatorEncoderTwo;




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

   /* elevatorLeft = new WPI_VictorSPX(Constants.ELEVATOR_LEFT);
    elevatorRight = new WPI_VictorSPX(Constants.ELEVATOR_RIGHT);
    armController = new WPI_VictorSPX(Constants.ARM_CONTROLLER);
    limitSwitch = new DigitalInput(Constants.LIMIT);
    encoderOne = new Encoder(Constants.ENCODER_ONE_SOURCEA, Constants.ENCODER_ONE_SOURCEB);
    encoderTwo = new Encoder(Constants.ENCODER_TWO_SOURCEA, Constants.ENCODER_TWO_SOURCEB);
    //teleArm = new TeleArm(elevatorLeft, elevatorRight, armController, limitSwitch, encoderOne, encoderTwo);
    */
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
    up = new JoystickButton(joy, Constants.UP_BUTTON);
    down = new JoystickButton(joy, Constants.DOWN_BUTTON);
    right = new JoystickButton(joy, Constants.RIGHT_BUTTON);
    left = new JoystickButton(joy, Constants.LEFT_BUTTON);


    elevatorUp = new JoystickButton(joy, Constants.ELEVATOR_UP_BUTTON);
    elevatorDown = new JoystickButton(joy, Constants.ELEVATOR_DOWN_BUTTON);

    elevatorUp.whileHeld(new MoveElevator(Constants.ELEVATOR_SPEED, -Constants.ELEVATOR_SPEED));

    //up.whileHeld(new MoveTeleArmVert(Constants.ELEVATOR_SPEED, -Constants.ELEVATOR_SPEED));


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

  public static TeleArm getTeleArm() {
    return teleArm;
  }
  public static Joystick getJoyStick() {
    return joy;
  }

public static Elevator getElevator() {
    return null;
}
}
