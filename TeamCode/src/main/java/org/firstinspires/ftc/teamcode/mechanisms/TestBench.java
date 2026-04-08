package org.firstinspires.ftc.teamcode.mechanisms;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestBench {
    private DcMotor motor;// in prictica numele e mai clar
    private double ticksPerRev;//revolution


    private DigitalChannel touchSensor;//tochSensorIntake sau la ce e folosit ca sa fie mai clar

    public  void init(HardwareMap hwMap) {
        //touch sensor
        touchSensor = hwMap.get(DigitalChannel.class, "touch_sensor");
        touchSensor.setMode(DigitalChannel.Mode.INPUT);

        // motor
        motor = hwMap.get(DcMotor.class, "motor");//in ghilimele exact ce lai denumitin private
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ticksPerRev = motor.getMotorType().getTicksPerRev();
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    //touch sensor
    public boolean isTouchSensorPressed () {
        return !touchSensor.getState();
    }
    public boolean isTouchSensorRealesed () {
        return touchSensor.getState();
    }

    // DC motor
    public  void setMotorSpeed (double speed){
        //accepts value -1 to 1
        motor.setPower((speed));
    }

    public double getMotorRevs() {
        return motor.getCurrentPosition() / ticksPerRev; //normalizing ticks per revolution
    }
    public void  setMotorZeroBehavior(DcMotor.ZeroPowerBehavior zeroBeavior){
        motor.setZeroPowerBehavior(zeroBeavior);
    }

}
