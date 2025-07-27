package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class HelloWorld extends OpMode {
    /**
     * This is called when the driver press INIT on the Driver Station
     */

    @Override
    public void init() {
        // this sends to the driver station
        telemetry.addData("Hello","World");
    }

    /**
     * This is called repeatedly while the op mode is playing
     */

    public void loop(){
        //Intentionally left blank
    }
}
