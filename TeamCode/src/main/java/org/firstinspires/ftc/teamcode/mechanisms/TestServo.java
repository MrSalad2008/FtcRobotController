package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class TestServo
{
    final Servo servo;
    private double conversionunit = 256;
    public TestServo(HardwareMap hwMap, String name)
    {
        servo = hwMap.get(Servo.class, name);
    }

    public void setServoPosition(double position) {
        servo.setPosition(position);
    }

    public void setServoDegress(double degress) {
        servo.setPosition(degress * conversionunit);
    }
}
