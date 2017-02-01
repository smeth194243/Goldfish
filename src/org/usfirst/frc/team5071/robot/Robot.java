package org.usfirst.frc.team5071.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot 
{
	//final String defaultAuto = "Default";
	//final String customAuto = "My Auto";
	//String autoSelected;
	//SendableChooser<String> chooser = new SendableChooser<>();
	private RobotDrive robut;
	private Talon talon;
	private Joystick xbox;
	private DriverStation station;
	private Boolean AButton, BButton, XButton, YButton, rightBumper, leftBumper, startButton, stopButton;
	private double axisXLeft, axisYLeft, axisXRight, axisYRight, leftTrigger, rightTrigger;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() 
	{
		//chooser.addDefault("Default Auto", defaultAuto);
		//chooser.addObject("My Auto", customAuto);
		//SmartDashboard.putData("Auto choices", chooser);
		xbox = new Joystick(0);
		robut = new RobotDrive(0,1);
		talon = new Talon(2);
		AButton = false;
		BButton = false;
		XButton = false;
		YButton = false;
		rightBumper = false;
		leftBumper = false;
		startButton = false;
		stopButton = false;
		
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	//@Override
	//public void autonomousInit() {
		//autoSelected = chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		//System.out.println("Auto selected: " + autoSelected);
	//}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	//public void autonomousPeriodic() {
		//switch (autoSelected) {
		//case customAuto:
			// Put custom auto code here
			//break;
		// defaultAuto:
		//default:
			// Put default auto code here
			//break;
		//}
	//}

	/**
	 * This function is called periodically during operator control
	 */
	//@Override
	public void teleopPeriodic() 
	{
			Scheduler.getInstance().run();
			AButton = xbox.getRawButton(1);
			BButton = xbox.getRawButton(2);
			XButton = xbox.getRawButton(3);
			YButton = xbox.getRawButton(4);
			rightBumper = xbox.getRawButton(5);
			leftBumper = xbox.getRawButton(6);
			stopButton = xbox.getRawButton(7);
			startButton = xbox.getRawButton(8);

			axisXLeft = xbox.getRawAxis(0);
			axisYLeft = xbox.getRawAxis(1);
			leftTrigger = xbox.getRawAxis(2);
			rightTrigger = xbox.getRawAxis(3);
			axisXRight = xbox.getRawAxis(4);
			axisYRight = xbox.getRawAxis(5);
			talon.enableDeadbandElimination(true);
			talon.set(0);
			
			robut.tankDrive(-axisYLeft, -axisYRight, true);

			if (leftTrigger == 1) {
				robut.drive(.7, axisXLeft - axisYLeft);
			} else if (rightTrigger == 1) {
				robut.drive(-.7, axisXLeft - axisYLeft);
			} else {
				robut.stopMotor();
			}
			if (AButton == true) {
				talon.set(.8);
			} else if (BButton == true) {
				talon.set(-.2);
			} else {
				talon.set(0);
			}

			if (startButton == true) {
				station.release();
			}
		}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() 
	{
		LiveWindow.run();
	}
	
	public RobotDrive getRobut()
	{
		return robut;
	}
	
	public void setRobit(RobotDrive robut) {
		this.robut = robut;
	}

	public Joystick getXbox() {
		return xbox;
	}

	public void setXbox(Joystick xbox) {
		this.xbox = xbox;
	}

	public boolean isAButton() {
		return AButton;
	}

	public void setAButton(boolean aButton) {
		AButton = aButton;
	}

	public boolean isBButton() {
		return BButton;
	}

	public void setBButton(boolean bButton) {
		BButton = bButton;
	}

	public boolean isXButton() {
		return XButton;
	}

	public void setXButton(boolean xButton) {
		XButton = xButton;
	}

	public boolean isYButton() {
		return YButton;
	}

	public void setYButton(boolean yButton) {
		YButton = yButton;
	}

	public boolean isrightBumper() {
		return rightBumper;
	}

	public void setrightBumper(boolean rightBumper) {
		this.rightBumper = rightBumper;
	}

	public boolean isleftBumper() {
		return leftBumper;
	}

	public void setleftBumper(boolean leftBumper) {
		this.leftBumper = leftBumper;
	}

	public double getAxisXleft() {
		return axisXLeft;
	}

	public void setAxisXleft(double axisXleft) {
		this.axisXLeft = axisXleft;
	}

	public double getAxisYleft() {
		return axisYLeft;
	}

	public void setAxisYleft(double axisYleft) {
		this.axisYLeft = axisYleft;
	}

	public double getAxisXright() {
		return axisXRight;
	}

	public void setAxisXright(double axisXright) {
		this.axisXRight = axisXright;
	}

	public double getAxisYright() {
		return axisYRight;
	}

	public void setAxisYright(double axisYright) {
		this.axisYRight = axisYright;
	}

	public double getleftTrigger() {
		return leftTrigger;
	}

	public void setleftTrigger(double leftTrigger) {
		this.leftTrigger = leftTrigger;
	}

	public double getrightTrigger() {
		return rightTrigger;
	}

	public void setrightTrigger(double rightTrigger) {
		this.rightTrigger = rightTrigger;
	}

	public boolean isStopButton() {
		return stopButton;
	}

	public void setStopButton(boolean stopButton) {
		this.stopButton = stopButton;
	}

}

