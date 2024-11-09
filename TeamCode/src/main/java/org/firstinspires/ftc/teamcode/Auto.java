package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.GamepadStates;


@Autonomous(name = "Auto", group = "auto")
public class Auto extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        boolean finished = false;
        boolean red = false;
        int delay = 0;
        int laps = 0;
        boolean left = false;

        drivetrain Drive = new drivetrain();

        Drive.init(this);

        GamepadStates newGamePad2 = new GamepadStates(gamepad1);

        telemetry.addLine("press b if red alliance");
        telemetry.addLine("press left for left side of the field");
        telemetry.addLine("press up to increase delay, or down to decrease");
        telemetry.addData("delay", delay);
        telemetry.update();

        if (newGamePad2.b.released) {
            red = true;
        }
        if (newGamePad2.dpad_left.released) {
            left = true;
        }
        if (newGamePad2.dpad_up.released) {
            if (delay > 15) {
                delay = 15;
            } else {
                delay += 1;
            }
        } else if (newGamePad2.dpad_down.released) {
            if (delay < 0) {
                delay = 0;
            } else {
                delay -= 1;
            }
        }


        waitForStart();

        sleep((long) (delay * 1000));

        if (left) {
            // drove up to the submersible
            Drive.forwardDistance(.5, 24);
            Drive.strafeRDistance(.5, 27.5);
            // intake score
            // repeat
            {// intake collect
                // Drive to the human player station
                Drive.forwardDistance(.5, -24);
                Drive.turn(90, .5, false);
                Drive.forwardDistance(.5, 36);
                //intake deposit sample
                // collect sample
                Drive.forwardDistance(.5, -6);
                sleep(2500);
                Drive.forwardDistance(.5, 6);
                //intake grab specimen
                // drive to submersible to score sample
                Drive.forwardDistance(.5, 48);
                Drive.turn(90, .5, true);
                //intake score sample
            }
            // end repeat
        } else {
            // drive to submersible
            Drive.forwardDistance(.5, 24);
            //intake score
            //repeat
            {
                //intake collect
                // drive to the human player station
                Drive.forwardDistance(.5, -24);
                Drive.turn(90, .5, false);
                Drive.forwardDistance(.5, 12);
                //intake deposit sample
                // collect sample
                Drive.forwardDistance(.5, -6);
                sleep(2500);
                Drive.forwardDistance(.5, 6);
                //intake grab specimen
                // drive back to the submersible
                Drive.forwardDistance(.5, -30);
                Drive.turn(90, .5, true);
                Drive.forwardDistance(.5, 24);
                //intake score
            }
            //end repeat
        }
    }
}