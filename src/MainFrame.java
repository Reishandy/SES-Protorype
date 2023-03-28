import javax.swing.*;

/*
 * Disclaimer
 * This is a messy code
 * Do not do this
 * This is just a functional prototype
 * Without any planning and designing in mind
 */

public class MainFrame extends JFrame {
    private static final RuleSet rules = new RuleSet();
    private static final RuleStorage ruleStorage = new RuleStorage();
    private String fullId = "";
    private JPanel jpMain;
    private JButton jbYes;
    private JButton jbNo;
    private JLabel jlQuestion;
    private JLabel jlResult;
    private JButton jbReset;

    public MainFrame() {
        // Initialize the GUI
        setContentPane(jpMain);
        setTitle("PDD-ES");
        setSize(900, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setVisible(true);
        jlQuestion.setText(rules.getCurrentRules());
        jlResult.setVisible(false);
        jbReset.setVisible(false);

        // Listener for the two button
        jbYes.addActionListener(e -> logic(true));
        jbNo.addActionListener(e -> logic(false));
        jbReset.addActionListener(e -> {
            rules.reset();
            fullId = "";
            jlQuestion.setText(rules.getCurrentRules());
            jlQuestion.setVisible(true);
            jlResult.setVisible(false);
            jbYes.setVisible(true);
            jbNo.setVisible(true);
            jbReset.setVisible(false);
        });
    }

    public static void main(String[] args) {
        // Get the rules
        ruleStorage.addRuleSet(rules);

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignore) {
        }
        new MainFrame();
    }

    private void logic(boolean yesOrNo) {
        // ID assembly
        String id = rules.getCurrentId();
        if (yesOrNo) fullId += id; // If yes add ID of question to the pool
        else fullId += "-";        // If no then add '-' to the pool

        // Checking if all the question has been answered
        if (rules.getMaxRule() == fullId.length()) {
            showResult();
            return;
        }

        // Update the question and display
        String text = rules.getNextRules();
        rules.next();
        jlQuestion.setText(text);
    }

    private void showResult() {
        // Get the result ans set display
        String answer = ruleStorage.getDescription(fullId);
        jlResult.setText(multiLine(answer));

        jlResult.setVisible(true);
        jbReset.setVisible(true);
        jlQuestion.setVisible(false);
        jbNo.setVisible(false);
        jbYes.setVisible(false);
    }

    private static String multiLine(String text) {
        return "<html>" + text.replaceAll("\n", "<br>");
    }
}
