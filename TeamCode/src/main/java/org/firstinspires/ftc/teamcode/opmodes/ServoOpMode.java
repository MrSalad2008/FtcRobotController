package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard4;

public class ServoOpMode extends OpMode {
    ProgrammingBoard4 board = new ProgrammingBoard4();

    @Override
    public void init() {
        board.init(hardwareMap);
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            board.setServoPosition(1);
        }
        else if (gamepad1.b) {
            board.setServoPosition(0.0);
        }
        else {
            board.setServoPosition(0.5);
        }
    }
}
