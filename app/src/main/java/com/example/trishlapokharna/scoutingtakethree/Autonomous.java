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
//IN XML FOR SPINNER, REMOVED THE CONTNET
//FOR MAIN THINGS, CHANGED THE APP THEMES
//IDK IF THIS IS HOW TO CORRECTLY ADD FRAGMENT
//SOMETHING WRONG WITH ARRAY FOR SPINER
public class Autonomous extends Fragment  {

    RoboInfo myRobo = RoboInfo.getInstance();
    // String matchT;
    // String teamT;

   // TextView gearTextView;

    Button gearHit;
    Button gearMiss;
    Button gearDelete;

    Button addFive1;
    Button addTen1;
    Button addTwenty1;
    Button addOne1;
    Button del1;

    Button addOne2;
    Button addFive2;
    Button addTen2;
    Button addTwenty2;
    Button del2;

    int i;
    int j;

    List<Integer> instance1 = new ArrayList<Integer>();
    List<Integer> instance2 = new ArrayList<Integer>();



    static TextView highGoalView;
    static TextView gearsView;
    static TextView lowGoalView;
   // Button submit;

    static EditText matchText;
    static EditText teamText;
    static EditText scouterText;
    static ToggleButton baseLineButton;
  //  TextView highGoal;
  //  TextView lowGoal;
    static TextView baselineText;



    private RoboInfo autoInfo = new RoboInfo();

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View in = inflater.inflate(R.layout.fragment_autonomous, container, false); // adds Autonomous tab to input activity



        matchText = (EditText)in.findViewById(R.id.matchNumberEdit);
        teamText = (EditText)in.findViewById(R.id.teamNumberEdit);
        scouterText = (EditText)in.findViewById(R.id.scouterNameEdit);
        baseLineButton = (ToggleButton) in.findViewById(R.id.baselineToggleButton);
        gearsView = (TextView) in.findViewById(R.id.gearView);
       // highGoal = (TextView) in.findViewById(R.id.highGoalTextView1);
       // lowGoal = (TextView) in.findViewById(R.id.lowGoalTextView);
        baselineText = (TextView) in.findViewById(R.id.baselineTextView);
        //gearTextView = (TextView) in.findViewById(R.id.gearTextView);
        highGoalView = (TextView) in.findViewById (R.id.highGoalView);
        lowGoalView = (TextView) in.findViewById (R.id.lowGoalView2);

        i = 0;
        j = 0;





        //set up radiogroup-like behaviors for toggle buttons

        gearHit = (Button) in.findViewById(R.id.gearHitButton);
        gearMiss = (Button) in.findViewById(R.id.gearMissButton);
        gearDelete = (Button) in.findViewById(R.id.gearBackButton);

        addOne1 = (Button) in.findViewById(R.id.highGoalAddOne);
        addFive1 = (Button) in.findViewById(R.id.highGoalAddFive);
        addTen1 = (Button) in.findViewById(R.id.highGoalAddTen);
        addTwenty1 = (Button) in.findViewById(R.id.highGoalAddTwenty);
        del1 = (Button) in.findViewById(R.id.highGoalDel);
        addOne2 = (Button) in.findViewById(R.id.lowGoalAddOne);
        addFive2 = (Button) in.findViewById(R.id.lowGoalAddFive);
        addTen2 = (Button) in.findViewById(R.id.lowGoalAddTen);
        addTwenty2 = (Button) in.findViewById(R.id.lowGoalAddTwenty);
        del2 = (Button) in.findViewById(R.id.lowGoalDel);



        //addItemsOnSpinnerB();
        //addItemsOnSpinnerD();

        gearHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gearsView.append("1 ");
            }
        });

        gearMiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gearsView.append("0 ");
            }
        });

        gearDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gearsView.getText().length() > 0) {
                    gearsView.setText(gearsView.getText().subSequence(0, gearsView.getText().length() - 2));
                }
            }
        });






        addOne1.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                i +=1;
                highGoalView.setText(String.valueOf(i));
                instance1.add(i);

            }

        });
        addFive1.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                i +=5;
                highGoalView.setText(String.valueOf(i));
                instance1.add(i);

            }

        });
        addTen1.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                i +=10;
                highGoalView.setText(String.valueOf(i));
                instance1.add(i);

            }

        });
        addTwenty1.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                i +=20;
                highGoalView.setText(String.valueOf(i));
                instance1.add(i);

            }

        });

        del1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               if (instance1.size() > 1 ) {
                   instance1.remove(instance1.size() - 1);
                   i = instance1.get(instance1.size() - 1);
                   highGoalView.setText(String.valueOf(i));
               }

                if (instance1.size() == 1){
                    instance1.clear();
                    i = 0;
                    highGoalView.setText(String.valueOf(i));
                }
            }
        });



        addOne2.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                j +=1;
                lowGoalView.setText(String.valueOf(j));
                instance2.add(j);

            }

        });
        addFive2.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                j +=5;

                lowGoalView.setText(String.valueOf(j));
                instance2.add(j);

            }

        });
        addTen2.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                j+=10;
                lowGoalView.setText(String.valueOf(j));
                instance2.add(j);

            }

        });
        addTwenty2.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                j+=20;
                lowGoalView.setText(String.valueOf(j));
                instance2.add(j);

            }

        });

        del2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (instance2.size()> 1) {
                    instance2.remove(instance2.size() - 1);
                    j = instance2.get(instance2.size() - 1);
                    lowGoalView.setText(String.valueOf(j));
                }
                if (instance2.size() == 1){
                    instance2.clear();
                    j = 0;
                    lowGoalView.setText(String.valueOf(j));
                }
            }
        });










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

        return in;
    }



      /*  @Override
        public RoboInfo getData() {
            this.autoInfo.matchT = this.matchT; // Assuming subcon has been updated.. else use txt1.getText();
            return this.autoInfo;
        }

        @Override
        public void setData(RoboInfo workData) {
            this.autoInfo = workData;
            // Update this page's views with the workData...
            // This assumes the fragment has already been created and txt1 is set to a view
            this.matchT = workData.matchT; // Actually could just use subCon in workData, but be aware that workData actually points to the Activity's copy (kinda makes getdata redundant.. but I like symmetry and couldn't be bothered making lots of copies of the object).
        }

        public static Autonomous newInstance(String a)
        {
            Autonomous fragment=new Autonomous();
            Bundle bundle=new Bundle();
            bundle.putString("a", "matchText");
            fragment.setArguments(bundle);
            return fragment;
        } */

}
