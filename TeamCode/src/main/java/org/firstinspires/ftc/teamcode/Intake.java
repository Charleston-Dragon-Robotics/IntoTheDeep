package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class Intake {

    // Intake servo and motor set up
    private DcMotor IExtension = null;
    private Servo IClaw = null;
    private Servo IRotation = null;
    private Servo IWrist = null;

    //Outtake servo set up
    private Servo OClaw = null;
    private Servo OWrist = null;

    private LinearOpMode opmode = null;


    public Intake() {
    }

    public void init(LinearOpMode opMode) {
        HardwareMap hwMap;
        opmode = opMode;
        hwMap = opMode.hardwareMap;

        IExtension = hwMap.dcMotor.get("IExtension");
        IClaw = hwMap.servo.get("IClaw");
        IWrist = hwMap.servo.get("IWrist");
    }

    public void intakeExtention (){
        IExtension.setPower(-.85);
    }
    public void intakeStop (){
        IExtension.setPower(0);
}
    public void intakeRetract (){
        IExtension.setPower(.85);
    }
    public void intakeGrasp() {
        IClaw.setPosition(0.5);
    }

    public void intakeRelease() {
        IClaw.setPosition(-0.5);
    }

    public void intakeWristDown (){
        IWrist.setPosition(0.5);
    }
    public void intakeWristUp (){
        IWrist.setPosition(-0.5);
    }
}
