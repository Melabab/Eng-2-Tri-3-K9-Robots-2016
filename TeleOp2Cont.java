package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by lellis20 on 3/29/16.
 */
public class TeleOp2Cont extends OpMode {

    DcMotor leftMotor;
    DcMotor rightMotor;
    Servo hand;
    Servo arm;

    final double HAND_OPENED_POSITION = 0.0;
    final double HAND_CLOSED_POSITION = 0.8;
    final double ARM_UP_POSITION = 0.0;
    final double ARM_DOWN_POSITION = 0.5;

    public void init() {

        leftMotor = hardwareMap.dcMotor.get("leftDC");
        rightMotor = hardwareMap.dcMotor.get("rightDC");
        hand = hardwareMap.servo.get("hand");
        arm = hardwareMap.servo.get("arm");
        //set motor directions
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

    }

    public void loop() {

        float leftStick = -gamepad1.left_stick_y;
        float rightStick = -gamepad1.right_stick_y;

        //Clip range here if necessary

        //set motor instructions
        leftMotor.setPower(leftStick);
        rightMotor.setPower(rightStick);

        if (gamepad2.left_bumper) {
            hand.setPosition(HAND_OPENED_POSITION);
        }
        if (gamepad2.right_bumper) {
            hand.setPosition(HAND_CLOSED_POSITION);
        }
        if (gamepad2.a) {
            arm.setPosition(ARM_UP_POSITION);
        }
        if (gamepad2.b) {
            arm.setPosition(ARM_DOWN_POSITION);
        }
    }


}
