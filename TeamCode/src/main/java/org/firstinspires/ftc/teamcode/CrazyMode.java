package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class CrazyMode extends OpMode {

    @Override
    public void init() {

    }
    @Override
    public void loop() {
        if (gamepad1.a) {
            float y = gamepad1.left_stick_y;
            float x = gamepad1.left_stick_x;
            gamepad1.left_stick_y = x;
            gamepad1.left_stick_x = y;
            telemetry.addData("Y", gamepad1.left_stick_y);
            telemetry.addData("X", gamepad1.left_stick_x);

        }

        telemetry.addData("Y", gamepad1.left_stick_y);
        telemetry.addData("X", gamepad1.left_stick_x);

    }
}
