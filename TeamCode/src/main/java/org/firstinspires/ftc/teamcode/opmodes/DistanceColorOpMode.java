package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard5;

@TeleOp
public class DistanceColorOpMode extends OpMode {
    ProgrammingBoard5 board = new ProgrammingBoard5();
    double distance = board.getDistance(DistanceUnit.CM);
    double speed;
    @Override
    public void init() {
        board.init(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("Amount red", board.getAmountRed());
        telemetry.addData("Amount blue", board.getAmountBlue());
        telemetry.addData("Distance (CM)", board.getDistance(DistanceUnit.CM));
        telemetry.addData("Distance (IN)", board.getDistance(DistanceUnit.INCH));
        if (distance < 10) {
            speed = 0.5;
        }
    }
}
