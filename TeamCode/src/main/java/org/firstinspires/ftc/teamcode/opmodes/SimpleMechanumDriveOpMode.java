package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.util.Range;

//import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.teamcode.mechanisms.MecanumDrive;

import java.util.List;

@TeleOp
public class SimpleMechanumDriveOpMode extends OpMode {
    MecanumDrive drive = new MecanumDrive();
    double maxSpeed = 0.3;
    double maxStrafe = 0.5;
    double maxTurn = 0.5;
    double speedGain = 0.05;
    double strafeGain = 0.07;
    double turnGain = 0.05;
    double xDegrees;
    double strafeDistance;
    double forwardDistance;
    double distance = 0.3;


    private Limelight3A limelight;

    private LLResultTypes.FiducialResult detection;

    //private Pose3D pose;

    @Override
    public void init() {
        drive.init(hardwareMap);
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.setPollRateHz(100);
        limelight.start();
        limelight.pipelineSwitch(0); //0 is the one I configured the limelight for
    }

    @Override
    public void loop() {
        LLResult result = limelight.getLatestResult();


        if (result != null && result.isValid()) {
            List<LLResultTypes.FiducialResult> fiducials = result.getFiducialResults();
            if (fiducials != null && !fiducials.isEmpty()) {
                for (LLResultTypes.FiducialResult fiducial : fiducials) {
                    //int id = fiducial.getFiducialId(); // The ID number of the fiducial
                    xDegrees = fiducial.getTargetXDegrees();
                            //detection.getTargetXDegrees(); // Where it is (left-right)
                    strafeDistance = fiducial.getCameraPoseTargetSpace().getPosition().x;
                    forwardDistance = fiducial.getCameraPoseTargetSpace().getPosition().z;


                }
            }

        }
        else {
            xDegrees = 0;
            strafeDistance = 0;
            forwardDistance = 0;
        }

        telemetry.addData("xDegrees: ", xDegrees);
        telemetry.addData("strafeDistance: ", strafeDistance);
        telemetry.addData("forwardDistance:  ", forwardDistance);

        if (gamepad1.a) {
            double forward  = Range.clip((0.6-forwardDistance) * speedGain, -maxSpeed, maxSpeed);
            double rotate   = Range.clip(xDegrees * turnGain, -maxTurn, maxTurn) ;
            double strafe = Range.clip(-strafeDistance * strafeGain, -maxStrafe, maxStrafe);
            telemetry.addData("forward: ", forward);
            telemetry.addData("rotate: ", rotate);
            telemetry.addData("strafe: ", strafe);
            drive.drive(forward, strafe, rotate);
        } else {
            double forward1 = -gamepad1.left_stick_y;
            double strafe1 = gamepad1.left_stick_x;
            double rotate1 = gamepad1.right_stick_x;

            drive.drive(forward1, strafe1, rotate1);
        }

    }

}
