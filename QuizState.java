import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizState {
    
    private Map<String, List<Question>> questionsByCategory;
    private Map<String, List<Question>> incorrectQuestions;
    private Map<String, Integer> scores;
    private Map<String, Integer> totalAttempts;
    private String currentCategory;
    private boolean isRetryMode;
    
    public QuizState() {
        questionsByCategory = new HashMap<>();
        incorrectQuestions = new HashMap<>();
        scores = new HashMap<>();
        totalAttempts = new HashMap<>();
        currentCategory = "Easy";
        isRetryMode = false;
        
        // Initialize categories
        questionsByCategory.put("Easy", new ArrayList<>());
        questionsByCategory.put("Medium", new ArrayList<>());
        questionsByCategory.put("Hard", new ArrayList<>());
        
        incorrectQuestions.put("Easy", new ArrayList<>());
        incorrectQuestions.put("Medium", new ArrayList<>());
        incorrectQuestions.put("Hard", new ArrayList<>());
        
        scores.put("Easy", 0);
        scores.put("Medium", 0);
        scores.put("Hard", 0);
        
        totalAttempts.put("Easy", 0);
        totalAttempts.put("Medium", 0);
        totalAttempts.put("Hard", 0);
    }
    
    public void loadQuestions(List<Question> allQuestions) {
        for (Question q : allQuestions) {
            String category = q.getQuestionCategory();
            if (questionsByCategory.containsKey(category)) {
                questionsByCategory.get(category).add(q);
            }
        }
    }
    
    public List<Question> getCurrentQuestions() {
        if (isRetryMode) {
            return incorrectQuestions.get(currentCategory);
        }
        return questionsByCategory.get(currentCategory);
    }
    
    public void recordAnswer(Question question, boolean isCorrect) {
        if (isCorrect) {
            scores.put(currentCategory, scores.get(currentCategory) + 1);
        } else {
            // Add to incorrect list if not already there
            if (!incorrectQuestions.get(currentCategory).contains(question)) {
                incorrectQuestions.get(currentCategory).add(question);
            }
        }
        totalAttempts.put(currentCategory, totalAttempts.get(currentCategory) + 1);
    }
    
    public double getCurrentPercentage() {
        int total = getCurrentQuestions().size();
        if (total == 0) return 0;
        return (scores.get(currentCategory) * 100.0) / total;
    }
    
    public boolean hasPassedCurrentCategory() {
        return getCurrentPercentage() >= 75.0;
    }
    
    public void moveToNextCategory() {
        if (currentCategory.equals("Easy")) {
            currentCategory = "Medium";
        } else if (currentCategory.equals("Medium")) {
            currentCategory = "Hard";
        }
        resetCurrentCategoryScore();
    }
    
    public void enterRetryMode() {
        isRetryMode = true;
        resetCurrentCategoryScore();
    }
    
    public void exitRetryMode() {
        isRetryMode = false;
        incorrectQuestions.get(currentCategory).clear();
    }
    
    private void resetCurrentCategoryScore() {
        scores.put(currentCategory, 0);
        totalAttempts.put(currentCategory, 0);
    }
    
    public String getCurrentCategory() {
        return currentCategory;
    }
    
    public boolean isRetryMode() {
        return isRetryMode;
    }
    
    public int getCurrentScore() {
        return scores.get(currentCategory);
    }
    
    public int getCurrentTotal() {
        return getCurrentQuestions().size();
    }
    
    public boolean isQuizComplete() {
        return currentCategory.equals("Hard") && hasPassedCurrentCategory() && !isRetryMode;
    }
    
    public Map<String, Double> getAllScores() {
        Map<String, Double> allScores = new HashMap<>();
        for (String category : questionsByCategory.keySet()) {
            int total = questionsByCategory.get(category).size();
            if (total > 0) {
                allScores.put(category, (scores.get(category) * 100.0) / total);
            }
        }
        return allScores;
    }
}
