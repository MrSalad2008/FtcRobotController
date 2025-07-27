package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.mechanisms.ProgrammingBoard7;
import org.firstinspires.ftc.teamcode.mechanisms.TestItem;

import java.util.ArrayList;

public class TestWiringOpMode extends OpMode {
    ProgrammingBoard7 board = new ProgrammingBoard7();
    ArrayList<TestItem> tests;
    boolean wasDown, wasUp;
    int testNum;

    @Override
    public void init() {
        board.init(hardwareMap);
        tests = board.getTests();
    }

    @Override
    public void loop() {
        //move up in the list of tests
        if (gamepad1.dpad_up && !wasUp) {
            testNum--;
            if (testNum > 0) {
                testNum = tests.size() - 1;
            }
        }
        wasUp = gamepad1.dpad_up;

        //move down in the list of tests
        if (gamepad1.dpad_down && !wasDown) {
            testNum--;
            if (testNum >= tests.size()) {
                testNum = 0;
            }
        }
        wasDown = gamepad1.dpad_down;

        //Put instructions on to the telemetry
        telemetry.addLine("Use up and down on your dpad to cycle through the tests");
        telemetry.addLine("Press A to run test");

        //Put the test on the telemetry
        TestItem currTest = tests.get(testNum);
        telemetry.addData("Test:", currTest.getDescription());

        //Run or don't run based on a
        currTest.run(gamepad1.a, telemetry);
    }
}
