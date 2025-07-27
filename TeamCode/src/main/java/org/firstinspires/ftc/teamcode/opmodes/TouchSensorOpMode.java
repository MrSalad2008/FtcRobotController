package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.IfElseIfOpMode;
import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard;


@TeleOp
public class TouchSensorOpMode extends OpMode{
    ProgrammingBoard board = new ProgrammingBoard();

    @Override
    public void init() {
        board.init(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("Touch sensor Released", board.getTouchSensorState());
        if (board.getTouchSensorState()) {
            telemetry.addData("Touch Sensor", "Pressed");
        }
        else  {
            telemetry.addData("Touch Sensor", "Not Pressed");
        }
    }
}
