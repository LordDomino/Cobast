package projectfiles.structures;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class FieldGroup extends JPanel {
    private String groupLabel;
    private JPanel labelsPanel;
    private JPanel fieldsPanel;

    /**
     * Constructor for a {@code}FieldGroup{@code} instance, intended to be used
     * with a {@code}Row{@code} parent component. A {@code}FieldGroup{@code} is
     * an entire JPanel that contains multiple text fields.
     * 
     * @param fieldLabels is an arbitrary number of String arguments
     * representing a field label in a form.
     */
    public FieldGroup(String ... fieldLabels) {
        this.initialize();
    }

    /**
     * Constructor for a {@code}FieldGroup{@code} instance, intended to be used
     * with a {@code}Row{@code} parent component. A {@code}FieldGroup{@code} is
     * an entire JPanel that contains multiple text fields.
     * 
     * @param label is a label that does not contain a text field under it,
     * serving as the label for the group.
     * @param fieldLabels is an arbitrary number of String arguments
     * representing a field label in a form.
     */
    public FieldGroup(String groupLabel, String ... fieldLabels) {
        this.groupLabel = groupLabel;
        this.initialize();
    }

    /**
     * Initializes the instance with the given properties and actions inside
     * the method. Use this method to serve as a "common" constructor when using
     * multiple constructors.
     */
    private void initialize() {
        this.setLayout(new GridBagLayout());

        // A FieldGroup contains two child JPanels that acts as rows for the labels and for the fields.
        this.labelsPanel = new JPanel();
        this.fieldsPanel = new JPanel();

        // Both JPanels use the GridBagLayout layout manager.
        this.labelsPanel.setLayout(new GridBagLayout());
        this.fieldsPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridy = 0; this.add(this.labelsPanel);
        gbc.gridy = 1; this.add(this.fieldsPanel);
    }
}