package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard6;

@Autonomous
public class AutoMotor extends OpMode {

    enum State {
        START,
        TOUCH
    }

    ProgrammingBoard6 board = new ProgrammingBoard6();
    State state = State.START;
    double lastTime;

    @Override
    public void init() {
        board.init(hardwareMap);
    }

    @Override
    public void start() {
        state = State.START;
        resetRuntime();
        lastTime = getRuntime();
    }

    @Override
    public void loop() {
        telemetry.addData("State", state);
        telemetry.addData("Runtime", getRuntime());
        telemetry.addData("Time in State", getRuntime() - lastTime);
        switch (state) {
            case START:
                if (getRuntime() < 0.25) {
                    board.setMotorSpeed(0.25);
                } 
                else if ((getRuntime() > 0.25) && (getRuntime() < 0.50)) {
                    board.setMotorSpeed(0.5);
                } else if (getRuntime() > 0.75) {
                    board.setMotorSpeed(0.75);
                }
                if (board.isTouchSensorPressed()) {
                    state = State.TOUCH;
                }
            case TOUCH:
                board.setMotorSpeed(0);
                break;
            default:
                break;

        }
    }
}
