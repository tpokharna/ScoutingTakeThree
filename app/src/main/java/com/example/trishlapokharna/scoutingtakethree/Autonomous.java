package com.example.trishlapokharna.scoutingtakethree;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;
import java.util.ArrayList;
import java.util.List;

//part 1 of input activity
public class Autonomous extends Fragment{

    RoboInfo myRobo = RoboInfo.getInstance();

    static EditText matchText;
    static EditText teamText;
    static EditText scouterText;

    static ToggleButton baselineButton;

    static TextView gearView;
    Button gearHitButton;
    Button gearMissButton;
    Button gearBackButton;

    static TextView highGoalView;
    Button highGoalOneButton;
    Button highGoalFiveButton;
    Button highGoalTenButton;
    Button highGoalTwentyButton;
    Button highGoalDelButton;

    static TextView lowGoalView;
    Button lowGoalOneButton;
    Button lowGoalFiveButton;
    Button lowGoalTenButton;
    Button lowGoalTwentyButton;
    Button lowGoalDelButton;

    int i;
    int j;
    List<Integer> instanceHigh = new ArrayList<Integer>();
    List<Integer> instanceLow = new ArrayList<Integer>();

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View in = inflater.inflate(R.layout.fragment_autonomous, container, false); // adds Autonomous tab to input activity

        matchText = (EditText)in.findViewById(R.id.matchText);
        teamText = (EditText)in.findViewById(R.id.teamText);
        scouterText = (EditText)in.findViewById(R.id.scouterText);

        baselineButton = (ToggleButton) in.findViewById(R.id.baselineToggleButton);

        gearView = (TextView) in.findViewById(R.id.gearView);
        gearHitButton = (Button) in.findViewById(R.id.gearHitButton);
        gearMissButton = (Button) in.findViewById(R.id.gearMissButton);
        gearBackButton = (Button) in.findViewById(R.id.gearBackButton);

        highGoalView = (TextView) in.findViewById (R.id.highGoalView);
        highGoalOneButton = (Button) in.findViewById(R.id.highGoalOneButton);
        highGoalFiveButton = (Button) in.findViewById(R.id.highGoalFiveButton);
        highGoalTenButton = (Button) in.findViewById(R.id.highGoalTenButton);
        highGoalTwentyButton = (Button) in.findViewById(R.id.highGoalTwentyButton);
        highGoalDelButton = (Button) in.findViewById(R.id.highGoalDelButton);

        lowGoalView = (TextView) in.findViewById (R.id.lowGoalView);
        lowGoalOneButton = (Button) in.findViewById(R.id.lowGoalOneButton);
        lowGoalFiveButton = (Button) in.findViewById(R.id.lowGoalFiveButton);
        lowGoalTenButton = (Button) in.findViewById(R.id.lowGoalTenButton);
        lowGoalTwentyButton = (Button) in.findViewById(R.id.lowGoalTwentyButton);
        lowGoalDelButton = (Button) in.findViewById(R.id.lowGoalDelButton);

        matchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {
                String  str = matchText.getText().toString();
                myRobo.setMatchT(str);
            }
        });

        teamText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {
                String  str = teamText.getText().toString();
                myRobo.setTeamT(str);
            }
        });

        scouterText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {
                String  str = scouterText.getText().toString();
                myRobo.setScouterT(str);
            }
        });

        //gear buttons
        gearHitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gearView.append("1 ");
            }
        });

        gearMissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gearView.append("0 ");
            }
        });

        gearBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gearView.getText().length() > 0) {
                    gearView.setText(gearView.getText().subSequence(0, gearView.getText().length() - 2));
                }
            }
        });

        //high goal buttons
        highGoalOneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                i = Integer.parseInt(highGoalView.getText().toString()) + 1;
                highGoalView.setText(String.valueOf(i));
                instanceHigh.add(i);
            }
        });

        highGoalFiveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                i = Integer.parseInt(highGoalView.getText().toString()) + 5;
                highGoalView.setText(String.valueOf(i));
                instanceHigh.add(i);
            }
        });

        highGoalTenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                i = Integer.parseInt(highGoalView.getText().toString()) + 10;
                highGoalView.setText(String.valueOf(i));
                instanceHigh.add(i);
            }
        });

        highGoalTwentyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                i = Integer.parseInt(highGoalView.getText().toString()) + 20;
                highGoalView.setText(String.valueOf(i));
                instanceHigh.add(i);
            }
        });

        highGoalDelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (instanceHigh.size() > 1 ) {
                    instanceHigh.remove(instanceHigh.size() - 1);
                    i = instanceHigh.get(instanceHigh.size() - 1);
                    highGoalView.setText(String.valueOf(i));
                }

                if (instanceHigh.size() == 1){
                    instanceHigh.clear();
                    i = 0;
                    highGoalView.setText(String.valueOf(i));
                }
            }
        });

        //low goal buttons
        lowGoalOneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                j = Integer.parseInt(highGoalView.getText().toString()) + 1;
                lowGoalView.setText(String.valueOf(j));
                instanceLow.add(j);
            }
        });

        lowGoalFiveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                j = Integer.parseInt(highGoalView.getText().toString()) + 5;
                lowGoalView.setText(String.valueOf(j));
                instanceLow.add(j);
            }
        });

        lowGoalTenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                j = Integer.parseInt(highGoalView.getText().toString()) + 10;
                lowGoalView.setText(String.valueOf(j));
                instanceLow.add(j);
            }
        });

        lowGoalTwentyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                j = Integer.parseInt(highGoalView.getText().toString()) + 20;
                lowGoalView.setText(String.valueOf(j));
                instanceLow.add(j);
            }
        });

        lowGoalDelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (instanceLow.size()> 1) {
                    instanceLow.remove(instanceLow.size() - 1);
                    j = instanceLow.get(instanceLow.size() - 1);
                    lowGoalView.setText(String.valueOf(j));
                }
                if (instanceLow.size() == 1){
                    instanceLow.clear();
                    j = 0;
                    lowGoalView.setText(String.valueOf(j));
                }
            }
        });
        return in;
    }
}
