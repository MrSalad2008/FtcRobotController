package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TurboButton extends OpMode {
    @Override
    public void init() {

    }

    @Override
    public void loop() {
        double speed;

        if (gamepad1.a) {
            speed = gamepad1.left_stick_y * 2;
            telemetry.addData("Speed Setting:", speed);
        }
        else {
            speed = gamepad1.left_stick_y * 0.5;
            telemetry.addData("Speed Setting:", speed);
        }

    }
}
