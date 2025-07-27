package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class GamepadRumbleEndGameOpMode extends OpMode {
    boolean inEndGame;
    double endGameTime;

    @Override
    public void init() {
        inEndGame = false;
    }

    @Override
    public void start() {
        endGameTime = getRuntime() + 90;
    }

    @Override
    public void loop() {
        if ((getRuntime() > endGameTime) && !inEndGame) {
            gamepad1.rumbleBlips(3);
            inEndGame = true;
        }
    }
}
