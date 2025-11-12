public class Question {

    private String question;
    private String[] options;
    private int correctAnswerIndex;
    private String questionCategory;

    public Question(String question, String[] options, int correctAnswerIndex, String questionCategory) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
        this.questionCategory = questionCategory;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public String getQuestionCategory() {
        return questionCategory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Category: ").append(questionCategory).append("\n");
        sb.append("Question: ").append(question).append("\n");
        sb.append("Options:\n");
        for (int i = 0; i < options.length; i++) {
            sb.append("  ").append((char) ('a' + i)).append(") ").append(options[i]).append("\n");
        }
        sb.append("Correct Answer: ").append((char) ('a' + correctAnswerIndex)).append(") ").append(options[correctAnswerIndex]);
        return sb.toString();
    }
}
