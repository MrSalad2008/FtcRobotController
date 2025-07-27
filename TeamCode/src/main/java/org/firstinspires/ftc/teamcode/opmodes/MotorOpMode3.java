package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard3;

@TeleOp
public class MotorOpMode3 extends OpMode {

    ProgrammingBoard3 board = new ProgrammingBoard3();
    @Override
    public void init() {
        board.init(hardwareMap);
    }

    @Override
    public void loop() {
        double motorSpeed = gamepad1.left_stick_y;

        board.setMotorSpeed(motorSpeed);

        if (gamepad1.a) {
            board.setMotorZeroBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            telemetry.addData("Zero", "Brake");
        }
        else if (gamepad1.b) {
            board.setMotorZeroBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
            telemetry.addData("Zero", "Brake");
        }
    }
}
