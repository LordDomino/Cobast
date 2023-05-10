package projectfiles.components;

import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;

public class CMultipleChoice extends CFieldGroup {

	/**
	 * The text string indicating the header of the multiple choices.
	 */
	String header;

	/**
	 * The integer indicating the placement orientation of the choices.
	 */
	int choicesOrientation;

	/** 
	 * The array of multiple choices.
	 */
	String[] choices;

	int headerOrientation;

	/**
	 * The component serving as the header of this multiple choice group.
	 */
	JLabel headerComponent;

	/**
	 * The component serving as the container of the radio buttons.
	 */
	CFieldGroup choicesGroupComponent;

	/**
	 * The button group containing the arbitrary number of radio buttons of this
	 * multiple choice group.
	 */
	ButtonGroup choicesGroup;

	/**
	 * Creates a {@code}CMultipleChoiceGroup{@code} object with the specified
	 * prompt header text and the multiple choices.
	 * 
	 * @param header - the text string indicating the header of the multiple
	 * choices
	 * @param headerPlacement - the value indicating the placement behavior of
	 * the header
	 * @param choices - the array of multiple choices
	 */
	public CMultipleChoice(String header, int headerPlacement,
	int choicesOrientation, String ... choices) throws Exception {
			super();
			this.header = header;
			this.choices = choices;
			
			try {
				this.headerOrientation = (int) matchValue(
					headerPlacement, CFieldGroup.LEFT, CFieldGroup.RIGHT,
					CFieldGroup.TOP, CFieldGroup.BOTTOM, CFieldGroup.HORIZONTAL,
					CFieldGroup.VERTICAL);
				if (this.headerOrientation == CFieldGroup.LEFT || this.headerOrientation == CFieldGroup.RIGHT || this.headerOrientation == CFieldGroup.HORIZONTAL) {
					this.orientation = CFieldGroup.HORIZONTAL;
				} else if (this.headerOrientation == CFieldGroup.TOP || this.headerOrientation == CFieldGroup.BOTTOM || this.headerOrientation == CFieldGroup.VERTICAL) {
					this.orientation = CFieldGroup.VERTICAL;
				}
			} catch (Exception e) {
				throw new IllegalArgumentException("Invalid headerOrientation value!");
			}
			
			try {
				this.choicesOrientation = (int) matchValue(choicesOrientation,
				CFieldGroup.HORIZONTAL, CFieldGroup.VERTICAL);
			} catch (Exception e) {
				throw new IllegalArgumentException("Invalid choicesOrientation value!");
			}
			
			this.setGridBagConstraintValues();
			this.constructComponents();
	}

	@Override
	public void constructComponents() throws Exception {
		this.headerComponent = new JLabel(this.header);
		this.choicesGroupComponent = new CFieldGroup(this.choicesOrientation);
		this.choicesGroup = new ButtonGroup();

		for (String choice : this.choices) {
			CRadioButton choiceComponent = new CRadioButton(choice);
			this.choicesGroupComponent.add(choiceComponent);
			this.choicesGroup.add(choiceComponent);
		}

		if (this.headerOrientation == CFieldGroup.LEFT || this.headerOrientation == CFieldGroup.TOP || this.headerOrientation == CFieldGroup.HORIZONTAL || this.headerOrientation == CFieldGroup.VERTICAL) {
			this.gbc.weightx = 0; this.gbc.weighty = 1;
			this.add(this.headerComponent);
			this.add(this.choicesGroupComponent);
			this.gbc.weightx = 1; this.gbc.weighty = 1;
		} else if (this.headerOrientation == CFieldGroup.RIGHT || this.headerOrientation == CFieldGroup.BOTTOM) {
			this.gbc.weightx = 0; this.gbc.weighty = 1;
			this.add(this.choicesGroupComponent);
			this.add(this.headerComponent);
			this.gbc.weightx = 1; this.gbc.weighty = 1;
		}
	}

	void setGridBagConstraintValues() {
		this.gbc.insets = new Insets(5, 5, 5, 5);
		// this.gbc.weightx = 1;
		// this.gbc.weighty = 1;
		// this.gbc.fill = GridBagConstraints.BOTH;
	}
}
