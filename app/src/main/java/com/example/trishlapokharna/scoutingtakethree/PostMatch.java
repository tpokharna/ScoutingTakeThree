package com.example.trishlapokharna.scoutingtakethree;


/**
 * Results
 */

/**
 * Results
 */

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

//part 3 of input activity

public class PostMatch extends Fragment {
    static ToggleButton win;
    static ToggleButton lose;
    static ToggleButton tie;

    RoboInfo myRobo = RoboInfo.getInstance();

    Button submit;

    String match;
    View fromAuto;

    private RoboInfo postInfo = new RoboInfo();
    String matchT;
    String notesT;



    static EditText notesText;
    static ToggleButton reach;
    static EditText numPressure;
    static ToggleButton takeoff;
    static EditText totalPoints;
    static EditText rotors;
    static EditText rankingPoints;

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View in = inflater.inflate(R.layout.fragment_post_match, container, false); // adds PostMatch tab to input activity

        notesText = (EditText) in.findViewById(R.id.notesEdit);
        reach = (ToggleButton) in.findViewById(R.id.reachToggle);
        numPressure = (EditText) in.findViewById(R.id.pressurerEdit);
        takeoff = (ToggleButton) in.findViewById(R.id.takeoffToggle);
        rotors = (EditText) in.findViewById(R.id.editRotors);
        totalPoints = (EditText) in.findViewById(R.id.totalPointsEdit);
        rankingPoints = (EditText) in.findViewById(R.id.rankingPointsEdit);

        win = (ToggleButton) in.findViewById(R.id.winToggle);
        lose = (ToggleButton) in.findViewById(R.id.loseToggle);
        tie = (ToggleButton) in.findViewById(R.id.tieToggle);

        win.setOnCheckedChangeListener(changeChecker);
        lose.setOnCheckedChangeListener(changeChecker);
        tie.setOnCheckedChangeListener(changeChecker);



        submit = (Button) in.findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Autonomous.teamText.getText().toString().length() == 0) {
                    Toast.makeText(getActivity(), "Add Team Number!", Toast.LENGTH_SHORT).show();
                }
                else if (Autonomous.matchText.getText().toString().length() == 0) {
                    Toast.makeText(getActivity(), "Add Match Number!", Toast.LENGTH_SHORT).show();
                }
                else if ( Autonomous.scouterText.getText().toString().length() == 0) {
                    Toast.makeText(getActivity(), "Add Scouter Name!", Toast.LENGTH_SHORT).show();
                }
                else if (PostMatch.totalPoints.getText().toString().length() == 0) {
                    Toast.makeText(getActivity(), "Add Total Points!", Toast.LENGTH_SHORT).show();
                }

                else if (numSpaces(Teleop.highGoalsView.getText().toString()) != numSpaces(Teleop.intervalViewH.getText().toString())  ){
                    Toast.makeText(getActivity(), "Cycle Time and Number of High Goals Do Not Match", Toast.LENGTH_SHORT).show();

                }
                else if (numSpaces(Teleop.lowGoalView.getText().toString()) != numSpaces(Teleop.intervalViewL.getText().toString())  ){
                    Toast.makeText(getActivity(), "Cycle Time and Number of Low Goals Do Not Match", Toast.LENGTH_SHORT).show();

                }

                else if (PostMatch.numPressure.getText().toString().length() == 0){
                    Toast.makeText(getActivity(), "Add kPa!", Toast.LENGTH_SHORT).show();
                }

                else if (PostMatch.rankingPoints.getText().toString().length() == 0){
                    Toast.makeText(getActivity(), "Add Ranking Points!", Toast.LENGTH_SHORT).show();
                }

                else if (PostMatch.rotors.getText().toString().length() == 0){
                    Toast.makeText(getActivity(), "Add Rotor #!", Toast.LENGTH_SHORT).show();
                }

                else if(PostMatch.win.isChecked() == false && PostMatch.lose.isChecked() == false && PostMatch.tie.isChecked() == false){
                    Toast.makeText(getActivity(), "Select win, lose, or tie!", Toast.LENGTH_SHORT).show();
                }


                else {
                    Intent toConfirmation = new Intent(getActivity(), Confirmation.class);
                    startActivity(toConfirmation);
                }
            }
        });

        notesText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = notesText.getText().toString();
                postInfo.setNotesT(str);
            }
        });



        return in;
    }

    CompoundButton.OnCheckedChangeListener changeChecker = new CompoundButton.OnCheckedChangeListener() {

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                if (buttonView != win) {
                    win.setChecked(false);
                }
                if (buttonView != lose) {
                    lose.setChecked(false);
                }
                if (buttonView != tie) {
                    tie.setChecked(false);
                }
                if (buttonView == win) {
                    String str = "Win";
                    myRobo.setResult(str);
                }
                else if (buttonView == lose) {
                    String str = "Lose";
                    myRobo.setResult(str);
                }
                else if (buttonView == tie) {
                    String str = "Tie";
                    myRobo.setResult(str);
                }
            }
        }
    };



    public static int numSpaces(String str){
        int spaces = 0; //custom method to remove multiple space
        StringBuilder sb=new StringBuilder();
        for(String s: str.split(" ")){

            if(!s.equals("")) {       // ignore space
                sb.append(s + " ");
                // add word with 1 space
                spaces++;
            }

        }
        return spaces;
    }


}
