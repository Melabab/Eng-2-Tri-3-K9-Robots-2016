package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by lellis20 on 3/29/16.
 */
public class TeleOp1Cont extends OpMode {

    DcMotor leftMotor;
    DcMotor rightMotor;
    Servo hand;
    Servo arm;

    final double HAND_OPENED_POSITION = 0.0;
    final double HAND_CLOSED_POSITION = 0.8;
    final double ARM_UP_POSITION = 0.0;
    final double ARM_DOWN_POSITION = 0.5;

@Override
public void init(){
        //find hardware
    leftMotor = hardwareMap.dcMotor.get("leftDC");
    rightMotor = hardwareMap.dcMotor.get("rightDC");
    hand = hardwareMap.servo.get("hand");
    arm = hardwareMap.servo.get("arm");
        //set motor directions
    leftMotor.setDirection(DcMotor.Direction.REVERSE);
    }

@Override
public void loop(){
        //set floats to gamepad

    float leftStick = -gamepad1.left_stick_y;
    float rightStick = -gamepad1.right_stick_y;
        //Clip range here if necessary
    //leftStick = Range.clip(leftStick, -1, 1);
    //rightStick = Range.clip(rightStick, -1, 1);

        //Makes it easier to drive at slower speeds
    //leftStick = (float) scaleInput(leftStick);
    //rightStick = (float) scaleInput(rightStick);


        //set motor instructions
    leftMotor.setPower(leftStick);
    rightMotor.setPower(rightStick);

    if (gamepad1.left_bumper){
        hand.setPosition(HAND_OPENED_POSITION);
    }
    if (gamepad1.right_bumper){
        hand.setPosition(HAND_CLOSED_POSITION);
    }
    if (gamepad1.a){
        arm.setPosition(ARM_UP_POSITION);
    }
    if (gamepad1.b){
        arm.setPosition(ARM_DOWN_POSITION);
    }

    }
    /*double scaleInput(double dVal)  {
        double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };

        // get the corresponding index for the scaleInput array.
        int index = (int) (dVal * 16.0);

        // index should be positive.
        if (index < 0) {
            index = -index;
        }

        // index cannot exceed size of array minus 1.
        if (index > 16) {
            index = 16;
        }

        // get value from the array.
        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }

        // return scaled value.
        return dScale;
    }*/
}
