package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;


@TeleOp
public class TuchSensorPractice extends OpMode {

    TestBench bench = new TestBench();


    @Override
    public void init() {
        bench.init(hardwareMap);

    }


    @Override
    public void loop() {
      if (bench.isTouchSensorPressed()){
          telemetry.addData("Touch Sensor","Pressed!");
      }
      else telemetry.addData("Touch Sensor", "NOT Pressed!");

      if (gamepad1.a){
          bench.setMotorZeroBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
      }
      else if (gamepad1.b){
          bench.setMotorZeroBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
      }
      telemetry.addData("Motor Revs", bench.getMotorRevs());

    }
}

