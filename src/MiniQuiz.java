import java.util.Scanner;

public class MiniQuiz
{
    //-----------------------------------------------------------------
    //  Presents a short quiz.
    //-----------------------------------------------------------------

    private final static Scanner SCAN = new Scanner(System.in);

    public static void main (String[] args)
    {
        Question q1, q2;

        q1 = new Question ("What is the capital of Jamaica?", "Kingston");
        q1.setComplexity (4);

        q2 = new Question ("Which is worse, ignorance or apathy?", "I don't know and I don't care");
        q2.setComplexity (10);

        askQuestion(q1);
        askQuestion(q2);
    }

    public static void askQuestion(Question q)
    {
        System.out.println(String.format("%s (Level: %d)", q.getQuestion(), q.getComplexity()));

        String sAnswer = PromptString("Enter answer: ");

        if (q.answerCorrect(sAnswer))
            System.out.println("Correct");
        else
            System.out.println(String.format("No, the answer is %s\r\n", q.getAnswer()));
    }

    protected static String PromptString(String question)
    {
        System.out.print(question);

        while (!SCAN.hasNextLine())
        {
            System.out.flush();

            System.out.print("Enter a string: ");

            SCAN.next();
        }

        return SCAN.nextLine();
    }
}
