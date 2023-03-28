import java.util.HashMap;

public class RuleStorage {
    private final HashMap<String, String> question = new HashMap<>();

    public RuleStorage() {
        // Add the questions and IDs
        question.put("1", "Pilihan 1");
        question.put("2", "Pilihan 2");
        question.put("3", "Pilihan 3");
    }

    public void addRuleSet(RuleSet ruleSet) {
        // Loop over questions and add them to the provided RuleSet
        for (String id : question.keySet()) {
            ruleSet.addRule(question.get(id), id);
        }
    }

    public String getDescription(String id) {
        // Deciding description based on ID
        // This is manual
        return switch (id) {
            case "123" -> "Anda memilih seluruh pilihan";
            case "1--" -> "Anda hanya memilih pilihan 1";
            case "-2-" -> "Anda hanya memilih pilihan 2";
            case "--3" -> "Anda hanya memilih pilihan 3";
            case "12-" -> "Anda memilih pilihan 1 dan 2";
            case "1-3" -> "Anda memilih pilihan 1 dan 3";
            case "-23" -> "Anda memilih pilihan 2 dan 3";
            default -> """
                    Tidak menemukan hasil
                    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
                    aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa""";
        };
    }
}