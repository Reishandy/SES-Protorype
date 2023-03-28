import java.util.ArrayList;
import java.util.List;


/*
 * Disclaimer
 * This shit is messy.
 * So I'm just gonna use it as a prototype
 * Do not use / reference this code at all.
 */

public class RuleSet {
    private int currentRule;
    private final List<Rule> rules;

    public RuleSet() {
        this.currentRule = 0;
        rules = new ArrayList<>();
    }

    public int getMaxRule() {
        return rules.size();
    }

    public void addRule(String ruleIn, String idIn) {
        Rule rule = new Rule(ruleIn, idIn);
        rules.add(rule);
    }

    public String getNextRules() {
        getMaxRule();
        int nextRule = currentRule + 1;
        if (nextRule == getMaxRule() + 1) {
            return "done";
        }
        return rules.get(nextRule).rule();
    }

    public String getCurrentRules() {
        return rules.get(currentRule).rule();
    }

    public String getCurrentId() {
        return rules.get(currentRule).id();
    }

    public void next() {
        currentRule++;
    }

    public void reset() {
        currentRule = 0;
    }
}
