// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final double ENCODER_ONE_LIMIT = 6259.75;
    public static final double ENCODER_TWO_LIMIT = -6264.0;

    //motor controller port
    public static final int ELEVATOR_LEFT = -1;
    public static final int ELEVATOR_RIGHT= -1;
    public static final int ELEVATOR_LIMIT_A = -1;
    public static final int ELEVATOR_LIMIT_B = -1;
    public static final int ELEVATOR_ENCODER1_1 = -1;
    public static final int ELEVATOR_ENCODER1_2 = -1;
    public static final int ELEVATOR_ENCODER2_1 = -1;
    public static final int ELEVATOR_ENCODER2_2 = -1;

    public static final int ARM_LEFT_LEFT = -1;
    public static final int ARM_LEFT_RIGHT = -1;
    public static final int ARM_LEFT_LIMIT_LEFT = -1;
    public static final int ARM_LEFT_LIMIT_RIGHT = -1;

    public static final double ARM_LEFT_SPEED_LEFT = 0;
    public static final double ARM_LEFT_SPEED_RIGHT = 0;

    public static final int ARM_RIGHT_LEFT = -1;
    public static final int ARM_RIGHT_RIGHT = -1;
    public static final int ARM_RIGHT_LIMIT_LEFT = -1;
    public static final int ARM_RIGHT_LIMIT_RIGHT = -1;

    public static final int ARM_RIGHT_SPEED_LEFT = 0;
    public static final int ARM_RIGHT_SPEED_RIGHT = 0;



    public static final double ELEVATOR_SPEED = 0;

    //button
    public static final int ELEVATOR_UP_BUTTON = -1;
    public static final int ELEVATOR_DOWN_BUTTON = -1;

    public static final int ARM_LEFT_LEFT_BUTTON = -1;
    public static final int ARM_LEFT_RIGHT_BUTTON = -1;
    public static final int ARM_RIGHT_LEFT_BUTTON = -1;
    public static final int ARM_RIGHT_RIGHT_BUTTON = -1;
    


}
