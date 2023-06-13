package com.example.teszt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class scienceTestQuestioningPage2 extends AppCompatActivity implements View.OnClickListener{

    ///////////////// a proper explanation of this page is located in the "testQuestioningPage.java" file
    TextView displayedQuestion;

    public static String questionsWrong = "#: ";
    Button ans1, ans2, ans3;
    Button proceedButton;
    int numberOfQuestions = scienceQuestion.length;

    public static int score = 0;
    int ongoingQuestion = 0;
    String choosenAnswer = "";

    //question1
    static String questionDisplayed = "What is the purpose of the vacuole in animals?";
    static String rightAnswer = "Vacuoles isolate waste products.";
    static String incorrect1Answer = "Vacuoles are the walls of the cell.";
    static String incorrect2Answer = "Vacuoles aren't in animals.";

    //question2
    static String questionDisplayed2 = "What is the purpose of the cytoplasm?";
    static String rightAnswer2 = "It's a gel-like fluid that provides a space for organelles to reside.";
    static String incorrect1Answer2 = "Cytoplasm doesn't exist inside the cell.";
    static String incorrect2Answer2 = "Cytoplasm creates the energy for the cell.";

    //question3
    static String questionDisplayed3 = "What is the purpose of the ribosome?";
    static String rightAnswer3 = "Site for protein synthesis.";
    static String incorrect1Answer3 = "Provides the defense mechanism for the cell.";
    static String incorrect2Answer3 = "Responsible for letting in/out fluids.";

    //question4
    static String questionDisplayed4 = "Which kingdom does the cell wall exist in?";
    static String rightAnswer4 = "Plantae.";
    static String incorrect1Answer4 = "Animalia.";
    static String incorrect2Answer4 = "Eukaryote.";

    //question5
    static String questionDisplayed5 = "How many vacuoles are in a plant cell?";
    static String rightAnswer5 = "One large vacuole.";
    static String incorrect1Answer5 = "Two vacuoles, each located at opposite sides of the cell.";
    static String incorrect2Answer5 = "None. They only exist in animal cells.";

    //question6
    static String questionDisplayed6 = "What is the powerhouse of the cell?";
    static String rightAnswer6 = "Mitochondria.";
    static String incorrect1Answer6 = "Nucleus.";
    static String incorrect2Answer6 = "DNA.";

    //question7
    static String questionDisplayed7 = "What is diffusion?";
    static String rightAnswer7 = "Diffusion refers to the movement of molecules between areas of differing concentration.";
    static String incorrect1Answer7 = "Diffusion is the movement of water molecules through a semi-permeable membrane.";
    static String incorrect2Answer7 = "The process by which two cells replicate.";

    //question8
    static String questionDisplayed8 = "Which one of the following reasons below is correct for why cells replicate?";
    static String rightAnswer8 = "The replication of cells allows for growth, repair and reproduction.";
    static String incorrect1Answer8 = "Cells replicate to prevent the formation of cancer cells from taking over DNA.";
    static String incorrect2Answer8 = "Question doesn't make sense.";

    //question9
    static String questionDisplayed9 = "What is the first stage of mitosis?";
    static String rightAnswer9 = "Prophase.";
    static String incorrect1Answer9 = "Metaphase.";
    static String incorrect2Answer9 = "Michondria.";

    //question10
    static String questionDisplayed10 = "What is the purpose of cell specialization?";
    static String rightAnswer10 = "Different organs require different types of cells because a different type of job has to be done.";
    static String incorrect1Answer10 = "Solely to defend the body against viruses.";
    static String incorrect2Answer10 = "Cells do not specialize under certain circumstances.";

    //question11
    static String questionDisplayed11 = "What type of tissue provides sensory sensations?";
    static String rightAnswer11 = "Nervous tissue.";
    static String incorrect1Answer11 = "Sensoring tissue.";
    static String incorrect2Answer11 = "Tissue does not perform such a task.";

    //question12
    static String questionDisplayed12 = "What happens to the chest cavity when we take a breath?";
    static String rightAnswer12 = "Your diaphragm contracts and moves downward, increasing the space of the cavity.";
    static String incorrect1Answer12 = "Your diaphragm expands into the back.";
    static String incorrect2Answer12 = "The chest cavity does not play a role in breathing.";

    //question13
    static String questionDisplayed13 = "What is the purpose of connective tissue?";
    static String rightAnswer13 = "Protects and provides structure for other organs in the body.";
    static String incorrect1Answer13 = "Contains robust defense cells that fend off viruses.";
    static String incorrect2Answer13 = "Leftover remnant of evolution.";

    //question14
    static String questionDisplayed14 = "Which one of the following functions is completed by the circulatory system?";
    static String rightAnswer14 = "Circulates oxygen to all of the body's organs.";
    static String incorrect1Answer14 = "Circulates ATP after it has been produced to the digestive area.";
    static String incorrect2Answer14 = "The circulatory system is absolutely crucial in circulating nitrogen throughout the body.";

    //question15
    static String questionDisplayed15 = "What purpose do veins serve in the human body?";
    static String rightAnswer15 = "Veins direct oxygen-poor blood towards the heart.";
    static String incorrect1Answer15 = "Collect oxygen-rich blood and flow it throughout the digestive system.";
    static String incorrect2Answer15 = "Veins provide transportation for white blood cells to navigate during a sickness.";


    public static String scienceQuestion[] ={
            questionDisplayed,
            questionDisplayed2,
            questionDisplayed3,
            questionDisplayed4,
            questionDisplayed5,
            questionDisplayed6,
            questionDisplayed7,
            questionDisplayed8,
            questionDisplayed9,
            questionDisplayed10,
            questionDisplayed11,
            questionDisplayed12,
            questionDisplayed13,
            questionDisplayed14,
            questionDisplayed15

    };

    public static String selectChoices[][] = {
            {rightAnswer, incorrect1Answer, incorrect2Answer},
            {rightAnswer2, incorrect2Answer2, incorrect1Answer2},
            {rightAnswer3, incorrect2Answer3, incorrect1Answer3},
            {rightAnswer4, incorrect2Answer4, incorrect1Answer4},
            {incorrect1Answer5, incorrect2Answer5, rightAnswer5},
            {incorrect2Answer6, incorrect1Answer6, rightAnswer6},
            {incorrect1Answer7, rightAnswer7, incorrect2Answer7},
            {incorrect2Answer8, rightAnswer8, incorrect1Answer8},
            {rightAnswer9, incorrect2Answer9, incorrect1Answer9},
            {rightAnswer10, incorrect1Answer10, incorrect2Answer10},
            {rightAnswer11, incorrect2Answer11, incorrect1Answer11},
            {incorrect2Answer12, rightAnswer12, incorrect1Answer12},
            {incorrect2Answer13, rightAnswer13, incorrect1Answer13},
            {incorrect1Answer14, rightAnswer14, incorrect2Answer14},
            {incorrect1Answer15, incorrect2Answer15, rightAnswer15}
    };

    public static String correctAnswer[] = {
            rightAnswer,
            rightAnswer2,
            rightAnswer3,
            rightAnswer4,
            rightAnswer5,
            rightAnswer6,
            rightAnswer7,
            rightAnswer8,
            rightAnswer9,
            rightAnswer10,
            rightAnswer11,
            rightAnswer12,
            rightAnswer13,
            rightAnswer14,
            rightAnswer15

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_test_questioning_page2);

        score = 0;
        questionsWrong = "#: ";

        displayedQuestion = findViewById(R.id.displayedQuestion);
        ans1 = findViewById(R.id.ans1);
        ans2 = findViewById(R.id.ans2);
        ans3 = findViewById(R.id.ans3);
        proceedButton = findViewById(R.id.button2);

        ans1.setOnClickListener(this);
        ans2.setOnClickListener(this);
        ans3.setOnClickListener(this);
        proceedButton.setOnClickListener(this);

        loadNextQuestion();
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View view) {

        ans1.setBackground(MainActivity.button.getBackground());
        ans2.setBackground(MainActivity.button.getBackground());
        ans3.setBackground(MainActivity.button.getBackground());

        Button pressedButton = (Button) view;
        if(pressedButton.getId()==R.id.button2){
            if(choosenAnswer.equals(correctAnswer[ongoingQuestion])){
                score++;
            }
            else if (!choosenAnswer.equals(correctAnswer[ongoingQuestion])){
                if(questionsWrong.equals("#: ")){
                    questionsWrong += String.valueOf(ongoingQuestion +1);
                }
                else{
                    questionsWrong += ", ";
                    questionsWrong += String.valueOf(ongoingQuestion +1);
                }
            }

            ongoingQuestion++;
            loadNextQuestion();

        }else{
            choosenAnswer = pressedButton.getText().toString();
            pressedButton.setBackgroundColor(Color.parseColor("#ADD8E6"));
        }
    }

    void loadNextQuestion(){
        if (ongoingQuestion == numberOfQuestions){
            Intent intent = new Intent(this, scienceTestRecap2.class);
            startActivity(intent);
            return;
        }

        displayedQuestion.setText(scienceQuestion[ongoingQuestion]);
        ans1.setText(selectChoices[ongoingQuestion][0]);
        ans2.setText(selectChoices[ongoingQuestion][1]);
        ans3.setText(selectChoices[ongoingQuestion][2]);
    }

    @Override
    public void onBackPressed(){
        return;
    }
}