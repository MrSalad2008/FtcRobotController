package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard6;

@TeleOp
public class GyroOpMode extends OpMode {
    ProgrammingBoard6 board = new ProgrammingBoard6();

    @Override
    public void init() {
        board.init(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("Our Heading", board.getHeading(AngleUnit.DEGREES));
    }
}
