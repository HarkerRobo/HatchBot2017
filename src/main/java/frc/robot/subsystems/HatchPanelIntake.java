package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap.CAN_IDS;

/**
 * Controls the Hatch Panel Intake
 * 
 * @author Austin Wang
 * @author Anirudh Kotamraju
 * @since January 14, 2019
 */
public class HatchPanelIntake extends Subsystem {
    public enum IntakeDirection {
        IN(DoubleSolenoid.Value.kForward), OUT(DoubleSolenoid.Value.kReverse);
        private DoubleSolenoid.Value value;
        private IntakeDirection(DoubleSolenoid.Value value) {
            this.value = value;
        }
        public DoubleSolenoid.Value getValue() {
            return value;
        }
    }

    private static HatchPanelIntake instance;
    private DoubleSolenoid doubleSolenoid;
    private Compressor compressor;
    private static boolean COMPRESSOR_INITAL_STATE = true;

    private HatchPanelIntake() {
        compressor = new Compressor(CAN_IDS.PCM);
        doubleSolenoid = new DoubleSolenoid(CAN_IDS.DOUBLE_SOLENOID_FORWARD,CAN_IDS.DOUBLE_SOLENOID_REVERSE);
        compressor.setClosedLoopControl(COMPRESSOR_INITAL_STATE);
    }

    @Override
    public void initDefaultCommand() {
        //setDefaultCommand(something);
    }

    public DoubleSolenoid.Value getSolenoidState() {
        return doubleSolenoid.get();        
    }

    public void setSolenoidState(DoubleSolenoid.Value state){
        doubleSolenoid.set(state);
    }

    public Compressor getCompressor() {
        return compressor;
    }
   
    public static HatchPanelIntake getInstance() {
        if(instance == null){
           new HatchPanelIntake();                                                                                        
        }
        return instance;
    }
    

}