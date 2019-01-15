package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import frc.robot.RobotMap.CAN_IDS;
import frc.robot.commands.DriveWithVelocityManual;
import harkerrobolib.subsystems.HSDrivetrain;
import harkerrobolib.wrappers.HSTalon;


/**
 * Represents the Drivetrain subsystem 
 * @author Anirudh Kotamraju
 * @since January 14 2019
 */
public class Drivetrain extends HSDrivetrain {
    private static Drivetrain dt;
    private static Drivetrain instance; 

    private static final boolean LEFT_MASTER_INVERTED = false;
    private static final boolean RIGHT_MASTER_INVERTED = false;
    private static final boolean LEFT_FOLLOWER_INVERTED = false;
    private static final boolean RIGHT_FOLLOWER_INVERTED = false;

    private static final int PEAK_LIMIT = 20;
    private static final int PEAK_TIME = 1000;
    private static final int CONTINUOUS_LIMIT= 15;

    private static final NeutralMode NEUTRAL_MODE = NeutralMode.Brake;        

    private Drivetrain(){
        super(new HSTalon(CAN_IDS.DT_LEFT_MASTER), new HSTalon(CAN_IDS.DT_RIGHT_MASTER), new HSTalon(CAN_IDS.DT_LEFT_FOLLOWER), new HSTalon(CAN_IDS.DT_RIGHT_FOLLOWER));
    }

    public void robotInit(){
        resetMasters();
        invertTalons(LEFT_MASTER_INVERTED, RIGHT_MASTER_INVERTED, LEFT_FOLLOWER_INVERTED, RIGHT_FOLLOWER_INVERTED);
        followMasters();
        setNeutralMode(NEUTRAL_MODE);
        setCurrentLimit(PEAK_LIMIT, PEAK_TIME, CONTINUOUS_LIMIT);
    }

    
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DriveWithVelocityManual());
    }
    
    public void arcadeDrivePercentOutput(double output, double turn) {
        getLeftMaster().set(ControlMode.PercentOutput, output + turn);
        getRightMaster().set(ControlMode.PercentOutput, output - turn);
    }
    
    public static Drivetrain getInstance() {
        if(instance == null) {
            dt = new Drivetrain();
        }
        return instance;
    }
}