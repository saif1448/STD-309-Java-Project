import java.nio.file.Paths;
import java.util.List;
public class Main {

    private static final String QUESTION_FILE_NAME =
            Paths.get(System.getProperty("user.dir"), "Questions.csv").toString();

    public static void main(String[] args) {

        List<Question> questions = QuestionLoader.loadQuestions(QUESTION_FILE_NAME);

        for(Question question : questions){
            System.out.println(question);
        }

    }
}