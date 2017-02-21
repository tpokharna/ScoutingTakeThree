package com.example.trishlapokharna.scoutingtakethree;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;
//Cycle time is the time it takes when they first start shooting till they stop
/**
 * Created by TrishlaPokharna on 1/14/17.
 */
public class Teleop extends Fragment {
    RoboInfo myRobo = RoboInfo.getInstance();

    static ToggleButton offenseOrDefense;

    static TextView gearsView;

    Button one;
    Button zero;
    Button back;


    static TextView highGoalsView;
    Button five1;
    Button ten1;
    Button twenty1;
    Button delete1;
    Button sub1;
    int i = 0;
    String display = " ";
    List<Integer> instance1 = new ArrayList<Integer>();
    String dis;
    List <String> instanceString = new ArrayList <String> ();
   static  List <Integer> addNum1 = new ArrayList <Integer> ();
    static List <String> time1 = new ArrayList <String> ();



    Button interval1H;
    Button interval2H;
    Button interval3H;
    Button interval4H;
    Button interval5H;
    Button intervalDelH;
    static TextView intervalViewH;





    static TextView lowGoalView;
    Button five2;
    Button ten2;
    Button twenty2;
    Button delete2;
    Button sub2;
    int j;
    String display2 = " ";
    List<Integer> instance2 = new ArrayList<Integer>();
   static List <Integer> addNum2 = new ArrayList <Integer> ();
    static List <String> time2 = new ArrayList <String> ();


    Button interval1L;
    Button interval2L;
    Button interval3L;
    Button interval4L;
    Button interval5L;
    Button intervalDelL;
    static TextView intervalViewL;





    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        View in = inflater.inflate(R.layout.fragment_teleop, container, false); // FIX THIS -- adds Autonomous tab to input activity
        offenseOrDefense = (ToggleButton) in.findViewById(R.id.offenseToggleButton);
        gearsView = (TextView) in.findViewById(R.id.gearView1);

        one = (Button) in.findViewById(R.id.gearHitButton);
        zero = (Button) in.findViewById(R.id.gearMissButton);
        back = (Button) in.findViewById(R.id.gearDeleteButton);


        highGoalsView = (TextView) in.findViewById(R.id.highGoalView);
        five1 = (Button) in.findViewById(R.id.highGoalAddFive);
        ten1 = (Button) in.findViewById(R.id.highGoalAddTen);
        twenty1 = (Button) in.findViewById(R.id.highGoalAddTwenty);
        delete1 = (Button) in.findViewById(R.id.highGoalDeleteButton);
        sub1 = (Button) in.findViewById(R.id.highGoalSubButton);
        i = 0;

        interval1H = (Button) in.findViewById(R.id.firstIntevralH);
        interval2H = (Button) in.findViewById(R.id.secondIntervalH);
        interval3H = (Button) in.findViewById(R.id.thirdIntervalH);
        interval4H = (Button) in.findViewById(R.id.fourthIntervalH);
        interval5H = (Button) in.findViewById(R.id.fifthIntervalH);
        intervalDelH = (Button) in.findViewById(R.id.deleteH);
        intervalViewH = (TextView) in.findViewById(R.id.cycleTimeHView);


        lowGoalView = (TextView) in.findViewById(R.id.lowGoalView2);
        five2 = (Button) in.findViewById(R.id.lowGoalAddFiveButton);
        ten2 = (Button) in.findViewById(R.id.lowGoalAddTenButton);
        twenty2 = (Button) in.findViewById(R.id.lowGoalAddTwentyButton);
        delete2 = (Button) in.findViewById(R.id.lowGoalDeleteButton);
        sub2 = (Button) in.findViewById(R.id.lowGoalSubButton);
        j = 0;

        interval1L = (Button) in.findViewById(R.id.firstIntevralL);
        interval2L = (Button) in.findViewById(R.id.secondIntervalL);
        interval3L = (Button) in.findViewById(R.id.thirdIntervalL);
        interval4L = (Button) in.findViewById(R.id.fourthIntervalL);
        interval5L = (Button) in.findViewById(R.id.fifthIntervalL);
        intervalDelL = (Button) in.findViewById(R.id.deleteL);
        intervalViewL = (TextView) in.findViewById(R.id.cycleTimeLView);



        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gearsView.append("1 ");
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gearsView.append("0 ");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gearsView.getText().length() > 0) {
                    gearsView.setText(gearsView.getText().subSequence(0, gearsView.getText().length() - 2));
                }
            }
        });


        //my button clic

//instnace1
    instance1.add(0);
    addNum1.add(i);


        five1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                i += 5;

                /*if (highGoalsView.getText().toString().length()-2 > 0) {
                    val = highGoalsView.getText().toString().substring(0, highGoalsView.getText().toString().length() - 2);
                    highGoalsView.setText(val);
                    highGoalsView.append(String.valueOf(i));


                }
                else
                highGoalsView.setText(String.valueOf(i)); */
                //adding instance to new

                instance1.add(i);
                dis +="a";
                addNum1.set(addNum1.size()-1, i);

                for (Integer s : addNum1) {
                    display += String.valueOf(s) + "        ";
                }

                highGoalsView.setText(display);
                display = "";


            }

        });
        ten1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                i += 10;
                instance1.add(i);
                dis+="b";
                addNum1.set(addNum1.size()-1, i);

                for (Integer s : addNum1) {
                    display += String.valueOf(s) + "        ";
                }

                highGoalsView.setText(display);
                display = "";





            }

        });
        twenty1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                i += 20;
               /* if (highGoalsView.getText().toString().length()-2 > 0){
                val=highGoalsView.getText().toString().substring(0, highGoalsView.getText().toString().length() - 2);
                highGoalsView.setText(val);
                highGoalsView.append(String.valueOf(i)); }
                else
                highGoalsView.setText(String.valueOf(i));

                number1.add(i);*/
                instance1.add(i);
                dis+="c";
                addNum1.set(addNum1.size()-1, i);

                for (Integer s : addNum1) {
                    display += String.valueOf(s) + "        ";
                }


                highGoalsView.setText(display);
                display = "";

            }

        });
//DELETE DOES NOT WORK
        delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (instance1.size() > 1 ) {
                    instance1.remove(instance1.size() - 1);
                    i = instance1.get(instance1.size()-1);
                    addNum1.remove(addNum1.size()-1);
                    addNum1.add(instance1.get(instance1.size()-1));


                    for (Integer s : addNum1) {
                        display += String.valueOf(s) + "        ";
                    }


                    highGoalsView.setText(display);
                    display = "";

                }

                if (instance1.size() == 1){
                    instance1.clear();
                    i = 0;
                    addNum1.set(addNum1.size() - 1, 0);
                    for (Integer s : addNum1) {
                        display += String.valueOf(s) + "         ";
                    }


                    highGoalsView.setText(display);
                    display = "";

                }
               /* if (instance1.size() == 1 ){
                        if (instanceString.get(instanceString.size()-1).substring(instanceString.get(instanceString.size()-1).length()-2, instanceString.get(instanceString.size()-1).length()-1)=="a" ) {
                            addNum1.set(addNum1.size() - 1, addNum1.get(addNum1.size() - 1) - 5);
                            for (Integer s : addNum1) {
                                display += String.valueOf(s) + "         ";
                            }
                            //instanceString.get(instanceString.size()-1)
                            highGoalsView.setText(display);
                        }
                    if (instanceString.get(instanceString.size()-1).substring(instanceString.get(instanceString.size()-1).length()-2, instanceString.get(instanceString.size()-1).length()-1)=="b" ) {
                        addNum1.set(addNum1.size() - 1, addNum1.get(addNum1.size() - 1) - 10);
                        for (Integer s : addNum1) {
                            display += String.valueOf(s) + "         ";


                        }
                        highGoalsView.setText(display);
                    }
                    if (instanceString.get(instanceString.size()-1).substring(instanceString.get(instanceString.size()-1).length()-2, instanceString.get(instanceString.size()-1).length()-1)=="c" ) {
                        addNum1.set(addNum1.size() - 1, addNum1.get(addNum1.size() - 1) - 20);
                        for (Integer s : addNum1) {
                            display += String.valueOf(s) + "         ";


                        }
                        highGoalsView.setText(display);
                    }
                }*/
            }
        });
        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                instanceString.add(dis);
                i = 0;
                instance1.clear();

                addNum1.add(i);
                for (Integer s : addNum1) {
                    display += String.valueOf(s) + "         ";
                }

                highGoalsView.setText(display);
                display = "";

            }
        });






        interval1H.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intervalViewH.append("00-05    ");
                time1.add("00-05    ");
            }
        });

        interval2H.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intervalViewH.append("06-10    ");
                time1.add("00-05    ");

            }
        });

        interval3H.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intervalViewH.append("11-15    ");
                time1.add("00-05    ");

            }
        });

        interval4H.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intervalViewH.append("16-20    ");
                time1.add("00-05    ");

            }
        });

        interval5H.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intervalViewH.append("21-25    ");
                time1.add("00-05    ");

            }
        });

        intervalDelH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time1.size() > 1) {
                    intervalViewH.setText(intervalViewH.getText().subSequence(0, intervalViewH.getText().length() - 9));
                    time1.remove(time1.size()-1);

                }
                if (time1.size() == 1 || time1.size() == 0 )
                    intervalViewH.setText("");
            }
        });





        instance2.add(0);
        addNum2.add(j);


       five2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                j += 5;
                instance1.add(j);
                addNum2.set(addNum2.size()-1, j);

                for (Integer s : addNum2) {
                    display2 += String.valueOf(s) + " ";
                }

                lowGoalView.setText(display2);
                display2 = " ";


            }

        });
        ten2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                j += 10;
                instance2.add(j);


                addNum2.set(addNum2.size()-1, j);

                for (Integer s : addNum2) {
                    display2 += String.valueOf(s) + "        ";
                }

                lowGoalView.setText(display2);
                display2 = " ";





            }

        });
        twenty2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                j += 20;
                instance2.add(j);
                addNum2.set(addNum2.size()-1, j);

                for (Integer s : addNum2) {
                    display2 += String.valueOf(s) + "        ";
                }


                lowGoalView.setText(display2);
                display2 = "";

            }

        });
//DELETE DOES NOT WORK
        delete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (instance2.size() > 1) {
                    instance2.remove(instance2.size() - 1);
                    j = instance2.get(instance2.size() - 1);
                    addNum2.remove(addNum2.size() - 1);
                    addNum2.add(instance2.get(instance2.size() - 1));


                    for (Integer s : addNum2) {
                        display2 += String.valueOf(s) + "        ";
                    }


                    lowGoalView.setText(display2);
                    display2 = "";

                }


                if (instance2.size() == 1) {
                    instance2.clear();
                    j = 0;
                    addNum2.set(addNum2.size() - 1, 0);

                    for (Integer s : addNum2) {
                        display2 += String.valueOf(s) + "        ";
                    }


                    lowGoalView.setText(display2);
                    display2 = "";

                }
            }

        });
        sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                j = 0;
                for (int k = instance2.size() - 1; k > 0; k--){
                    instance2.remove(k);
                }

                addNum2.add(j);
                for (Integer s : addNum2) {
                    display2 += String.valueOf(s) + "        ";
                }

                lowGoalView.setText(display2);
                display2 = "";

            }
        });

        interval1L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intervalViewL.append("00-05    ");
                time2.add("00-05    ");
            }
        });

        interval2L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intervalViewL.append("06-10    ");
                time2.add("06-10    ");

            }
        });

        interval3L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intervalViewL.append("11-15    ");
                time2.add("11-15    ");
            }
        });

        interval4L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intervalViewL.append("16-20    ");
                time2.add("16-20    ");

            }
        });

        interval5L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intervalViewL.append("21-25    ");
                time2.add("21-25    ");

            }
        });

        intervalDelL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time2.size() > 1) {
                    intervalViewL.setText(intervalViewL.getText().subSequence(0, intervalViewL.getText().length() - 9));
                    time2.remove(time2.size()-1);
                }
                if (time2.size()==0 ||(time2.size()==1 )) {
                    intervalViewL.setText("");
            }
            }
        });



        return in;



    }

}


