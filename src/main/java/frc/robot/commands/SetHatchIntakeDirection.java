package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.subsystems.HatchPanelIntake;

/**
 * Sets Hatch Intake Direction
 * 
 * @author Anirudh Kotamraju
 * @since January 14 2019
 */
public class SetHatchIntakeDirection extends InstantCommand {
    private HatchPanelIntake.IntakeDirection direction;

    public SetHatchIntakeDirection(HatchPanelIntake.IntakeDirection direction) {
        requires(HatchPanelIntake.getInstance());
        this.direction = direction;
    }

    @Override
    public void initialize() {
        HatchPanelIntake.getInstance().setSolenoidState(direction.getValue());        
    }
}               
