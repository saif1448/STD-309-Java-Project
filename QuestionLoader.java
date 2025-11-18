import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class QuestionLoader {

    public static List<Question> loadQuestions(String filename) {
        List<Question> questions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 5);
                String question = parts[0].replace("\"", "");
                String[] options = parts[1].split(";");
                int correct = Integer.parseInt(parts[2]);
                String category = parts[3];
                String explanation = parts[4];
                questions.add(new Question(question, options, correct, category, explanation));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }

}
