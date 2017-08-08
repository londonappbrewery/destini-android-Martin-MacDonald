package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryView;
    private Button mAnswerOne;
    private Button mAnswerTwo;

    int mStoryIndex;

    private int[] mStoryArray = new int[]{
            R.string.T1_Story,
            R.string.T2_Story,
            R.string.T3_Story,
            R.string.T4_End,
            R.string.T5_End,
            R.string.T6_End
    };

    private int[] mAnswerOneArray = new int[]{
            R.string.T1_Ans1,
            R.string.T2_Ans1,
            R.string.T3_Ans1
    };

    private int[] mAnswerTwoArray = new int[]{
            R.string.T1_Ans2,
            R.string.T2_Ans2,
            R.string.T3_Ans2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryView = (TextView) findViewById(R.id.storyTextView);
        mAnswerOne = (Button) findViewById(R.id.buttonTop);
        mAnswerTwo = (Button) findViewById(R.id.buttonBottom);

        mStoryIndex = 0;


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mAnswerOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 0 || mStoryIndex == 1){
                    mStoryIndex = 2;
                } else{
                    mStoryIndex = 5;
                }
                updateView();
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mAnswerTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 0){
                    mStoryIndex = 1;
                } else if (mStoryIndex == 1){
                    mStoryIndex = 3;
                } else {
                    mStoryIndex = 4;
                }
                updateView();
            }
        });
    }

    private void updateView(){
        if (mStoryIndex == 3 || mStoryIndex == 4 || mStoryIndex == 5){
            mStoryView.setText(mStoryArray[mStoryIndex]);
            mAnswerOne.setVisibility(View.GONE);
            mAnswerTwo.setVisibility(View.GONE);
        } else{
            mStoryView.setText(mStoryArray[mStoryIndex]);
            mAnswerOne.setText(mAnswerOneArray[mStoryIndex]);
            mAnswerTwo.setText(mAnswerTwoArray[mStoryIndex]);
        }

    }
}
