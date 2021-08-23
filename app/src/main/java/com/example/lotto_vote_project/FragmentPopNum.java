package com.example.lotto_vote_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FragmentPopNum extends Fragment {
    private Button qrcheckButton;
    View view;
    FirebaseFirestore db;

    Map<String, String> map = new HashMap<String, String>();
    ArrayList<Pair<String,String>> pairList = new ArrayList<>();
    List<TextView> textViewList = new ArrayList<>();
    List<ImageView> imageViewList = new ArrayList<>();
    TextView num1Textview;TextView num2Textview;TextView num3Textview;TextView num4Textview;TextView num5Textview;TextView num6Textview;TextView num7Textview;TextView num8Textview;TextView num9Textview;
    TextView num10Textview;TextView num11Textview;TextView num12Textview;TextView num13Textview;TextView num14Textview;TextView num15Textview;TextView num16Textview;TextView num17Textview;TextView num18Textview;
    TextView num19Textview;TextView num20Textview;TextView num21Textview;TextView num22Textview;TextView num23Textview;TextView num24Textview;TextView num25Textview;TextView num26Textview;TextView num27Textview;
    TextView num28Textview;TextView num29Textview;TextView num30Textview;TextView num31Textview;TextView num32Textview;TextView num33Textview;TextView num34Textview;TextView num35Textview;TextView num36Textview;
    TextView num37Textview;TextView num38Textview;TextView num39Textview;TextView num40Textview;TextView num41Textview;TextView num42Textview;TextView num43Textview;TextView num44Textview;TextView num45Textview;


    ImageView num1ImageView;ImageView num2ImageView;ImageView num3ImageView;ImageView num4ImageView;ImageView num5ImageView;ImageView num6ImageView;ImageView num7ImageView;ImageView num8ImageView;ImageView num9ImageView;
    ImageView num10ImageView;ImageView num11ImageView;ImageView num12ImageView;ImageView num13ImageView;ImageView num14ImageView;ImageView num15ImageView;ImageView num16ImageView;ImageView num17ImageView;ImageView num18ImageView;
    ImageView num19ImageView;ImageView num20ImageView;ImageView num21ImageView;ImageView num22ImageView;ImageView num23ImageView;ImageView num24ImageView;ImageView num25ImageView;ImageView num26ImageView;ImageView num27ImageView;
    ImageView num28ImageView;ImageView num29ImageView;ImageView num30ImageView;ImageView num31ImageView;ImageView num32ImageView;ImageView num33ImageView;ImageView num34ImageView;ImageView num35ImageView;ImageView num36ImageView;
    ImageView num37ImageView;ImageView num38ImageView;ImageView num39ImageView;ImageView num40ImageView;ImageView num4
        1ImageView;ImageView num42ImageView;ImageView num43ImageView;ImageView num44ImageView;ImageView num45ImageView;
    Button refreshButton;
    

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_popnum, container, false);
        db = FirebaseFirestore.getInstance();



        num1Textview = view.findViewById(R.id.rankTextview1);num10Textview = view.findViewById(R.id.rankTextview10);num20Textview = view.findViewById(R.id.rankTextview20);num30Textview = view.findViewById(R.id.rankTextview30);
        num2Textview = view.findViewById(R.id.rankTextview2);num11Textview = view.findViewById(R.id.rankTextview11);num21Textview = view.findViewById(R.id.rankTextview21);num31Textview = view.findViewById(R.id.rankTextview31);
        num3Textview = view.findViewById(R.id.rankTextview3);num12Textview = view.findViewById(R.id.rankTextview12);num22Textview = view.findViewById(R.id.rankTextview22);num32Textview = view.findViewById(R.id.rankTextview32);
        num4Textview = view.findViewById(R.id.rankTextview4);num13Textview = view.findViewById(R.id.rankTextview13);num23Textview = view.findViewById(R.id.rankTextview23);num33Textview = view.findViewById(R.id.rankTextview33);
        num5Textview = view.findViewById(R.id.rankTextview5);num14Textview = view.findViewById(R.id.rankTextview14);num24Textview = view.findViewById(R.id.rankTextview24);num34Textview = view.findViewById(R.id.rankTextview34);
        num6Textview = view.findViewById(R.id.rankTextview6);num15Textview = view.findViewById(R.id.rankTextview15);num25Textview = view.findViewById(R.id.rankTextview25);num35Textview = view.findViewById(R.id.rankTextview35);
        num7Textview = view.findViewById(R.id.rankTextview7);num16Textview = view.findViewById(R.id.rankTextview16);num26Textview = view.findViewById(R.id.rankTextview26);num36Textview = view.findViewById(R.id.rankTextview36);
        num8Textview = view.findViewById(R.id.rankTextview8);num17Textview = view.findViewById(R.id.rankTextview17);num27Textview = view.findViewById(R.id.rankTextview27);num37Textview = view.findViewById(R.id.rankTextview37);
        num9Textview = view.findViewById(R.id.rankTextview9);num18Textview = view.findViewById(R.id.rankTextview18);num28Textview = view.findViewById(R.id.rankTextview28);num38Textview = view.findViewById(R.id.rankTextview38);
        num10Textview = view.findViewById(R.id.rankTextview10);num19Textview = view.findViewById(R.id.rankTextview19);num29Textview = view.findViewById(R.id.rankTextview29);num39Textview = view.findViewById(R.id.rankTextview39);
        num40Textview = view.findViewById(R.id.rankTextview40);num41Textview = view.findViewById(R.id.rankTextview41);num42Textview = view.findViewById(R.id.rankTextview42);num43Textview = view.findViewById(R.id.rankTextview43);
        num44Textview = view.findViewById(R.id.rankTextview44);num45Textview = view.findViewById(R.id.rankTextview45);

        num1ImageView = view.findViewById(R.id.imageView1);num10ImageView = view.findViewById(R.id.imageView10);num20ImageView = view.findViewById(R.id.imageView20);num30ImageView = view.findViewById(R.id.imageView30);
        num2ImageView = view.findViewById(R.id.imageView2);num11ImageView = view.findViewById(R.id.imageView11);num21ImageView = view.findViewById(R.id.imageView21);num31ImageView = view.findViewById(R.id.imageView31);
        num3ImageView = view.findViewById(R.id.imageView3);num12ImageView = view.findViewById(R.id.imageView12);num22ImageView = view.findViewById(R.id.imageView22);num32ImageView = view.findViewById(R.id.imageView32);
        num4ImageView = view.findViewById(R.id.imageView4);num13ImageView = view.findViewById(R.id.imageView13);num23ImageView = view.findViewById(R.id.imageView23);num33ImageView = view.findViewById(R.id.imageView33);
        num5ImageView = view.findViewById(R.id.imageView5);num14ImageView = view.findViewById(R.id.imageView14);num24ImageView = view.findViewById(R.id.imageView24);num34ImageView = view.findViewById(R.id.imageView34);
        num6ImageView = view.findViewById(R.id.imageView6);num15ImageView = view.findViewById(R.id.imageView15);num25ImageView = view.findViewById(R.id.imageView25);num35ImageView = view.findViewById(R.id.imageView35);
        num7ImageView = view.findViewById(R.id.imageView7);num16ImageView = view.findViewById(R.id.imageView16);num26ImageView = view.findViewById(R.id.imageView26);num36ImageView = view.findViewById(R.id.imageView36);
        num8ImageView = view.findViewById(R.id.imageView8);num17ImageView = view.findViewById(R.id.imageView17);num27ImageView = view.findViewById(R.id.imageView27);num37ImageView = view.findViewById(R.id.imageView37);
        num9ImageView = view.findViewById(R.id.imageView9);num18ImageView = view.findViewById(R.id.imageView18);num28ImageView = view.findViewById(R.id.imageView28);num38ImageView = view.findViewById(R.id.imageView38);
        num10ImageView = view.findViewById(R.id.imageView10);num19ImageView = view.findViewById(R.id.imageView19);num29ImageView = view.findViewById(R.id.imageView29);num39ImageView = view.findViewById(R.id.imageView39);
        num40ImageView = view.findViewById(R.id.imageView40);num41ImageView = view.findViewById(R.id.imageView41);num42ImageView = view.findViewById(R.id.imageView42);num43ImageView = view.findViewById(R.id.imageView43);
        num44ImageView = view.findViewById(R.id.imageView44);num45ImageView = view.findViewById(R.id.imageView45);
        refreshButton = view.findViewById(R.id.refreshButton);


        imageViewList.add(num1ImageView); imageViewList.add(num2ImageView); imageViewList.add(num3ImageView); imageViewList.add(num4ImageView); imageViewList.add(num5ImageView); imageViewList.add(num6ImageView);imageViewList.add(num7ImageView);
        imageViewList.add(num8ImageView); imageViewList.add(num9ImageView); imageViewList.add(num10ImageView); imageViewList.add(num11ImageView); imageViewList.add(num12ImageView); imageViewList.add(num13ImageView);imageViewList.add(num14ImageView);
        imageViewList.add(num15ImageView); imageViewList.add(num16ImageView); imageViewList.add(num17ImageView); imageViewList.add(num18ImageView); imageViewList.add(num19ImageView); imageViewList.add(num20ImageView);imageViewList.add(num21ImageView);
        imageViewList.add(num22ImageView); imageViewList.add(num23ImageView); imageViewList.add(num24ImageView); imageViewList.add(num25ImageView); imageViewList.add(num26ImageView); imageViewList.add(num27ImageView);imageViewList.add(num28ImageView);
        imageViewList.add(num29ImageView); imageViewList.add(num30ImageView); imageViewList.add(num31ImageView); imageViewList.add(num32ImageView); imageViewList.add(num33ImageView); imageViewList.add(num34ImageView);imageViewList.add(num35ImageView);
        imageViewList.add(num36ImageView); imageViewList.add(num37ImageView); imageViewList.add(num38ImageView); imageViewList.add(num39ImageView); imageViewList.add(num40ImageView); imageViewList.add(num41ImageView);imageViewList.add(num42ImageView);
        imageViewList.add(num43ImageView); imageViewList.add(num44ImageView); imageViewList.add(num45ImageView);

        textViewList.add(num1Textview); textViewList.add(num2Textview); textViewList.add(num3Textview); textViewList.add(num4Textview); textViewList.add(num5Textview); textViewList.add(num6Textview);textViewList.add(num7Textview);
        textViewList.add(num8Textview); textViewList.add(num9Textview); textViewList.add(num10Textview); textViewList.add(num11Textview); textViewList.add(num12Textview); textViewList.add(num13Textview);textViewList.add(num14Textview);
        textViewList.add(num15Textview); textViewList.add(num16Textview); textViewList.add(num17Textview); textViewList.add(num18Textview); textViewList.add(num19Textview); textViewList.add(num20Textview);textViewList.add(num21Textview);
        textViewList.add(num22Textview); textViewList.add(num23Textview); textViewList.add(num24Textview); textViewList.add(num25Textview); textViewList.add(num26Textview); textViewList.add(num27Textview);textViewList.add(num28Textview);
        textViewList.add(num29Textview); textViewList.add(num30Textview); textViewList.add(num31Textview); textViewList.add(num32Textview); textViewList.add(num33Textview); textViewList.add(num34Textview);textViewList.add(num35Textview);
        textViewList.add(num36Textview); textViewList.add(num37Textview); textViewList.add(num38Textview); textViewList.add(num39Textview); textViewList.add(num40Textview); textViewList.add(num41Textview);textViewList.add(num42Textview);
        textViewList.add(num43Textview); textViewList.add(num44Textview); textViewList.add(num45Textview);
        makeRank();

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRankRefresh();

            }
        });

        return view;

    }

    public void makeRankRefresh(){
        DocumentReference docRef = db.collection("rank").document("numRank");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {

                        pairList.clear();
                        for (int i = 1; i <= 45; i++) {
                            String strkey = "num" + Integer.toString(i);
                            String strvalue = document.getString(strkey);
                            pairList.add(new Pair<>(strkey,strvalue));
                        }


                        Collections.sort(pairList, new Comparator<Pair<String, String>>() {
                            @Override
                            public int compare(Pair<String, String> o1, Pair<String, String> o2) {
                                return Integer.parseInt(o2.second)-Integer.parseInt(o1.second);
                            }
                        });


                        setRankList(pairList);
                        Toast.makeText(getContext(), "새로고침 완료", Toast.LENGTH_SHORT).show();

//                        recentRoundNum = Integer.parseInt(document.getString("recentRoundNum"));
//                        drwNoTextView.setText(String.valueOf(recentRoundNum));
//                        makeRequest(recentRoundNum);
//                        makeDialogList(recentRoundNum);

                    } else {
                        Toast.makeText(getContext(), "새로고침 실패", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getContext(), "새로고침 실패", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void makeRank() {
        DocumentReference docRef = db.collection("rank").document("numRank");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {


                        for (int i = 1; i <= 45; i++) {
                            String strkey = "num" + Integer.toString(i);
                            String strvalue = document.getString(strkey);
                            pairList.add(new Pair<>(strkey,strvalue));
                        }


                        Collections.sort(pairList, new Comparator<Pair<String, String>>() {
                            @Override
                            public int compare(Pair<String, String> o1, Pair<String, String> o2) {
                                return Integer.parseInt(o2.second)-Integer.parseInt(o1.second);
                            }
                        });


                        setRankList(pairList);


//                        recentRoundNum = Integer.parseInt(document.getString("recentRoundNum"));
//                        drwNoTextView.setText(String.valueOf(recentRoundNum));
//                        makeRequest(recentRoundNum);
//                        makeDialogList(recentRoundNum);

                    } else {
                        Toast.makeText(getContext(), "번호 순위를 불러오는데 실패하였습니다.", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getContext(), "번호 순위를 불러오는데 실패하였습니다.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void setRankList(ArrayList<Pair<String,String>> pairList2){
        int standvote = Integer.parseInt(pairList2.get(0).second);
        for(int i=0; i<45; i++){
            int vote = Integer.parseInt(pairList2.get(i).second);
            String str = pairList2.get(i).first;
            int percent = 10 + 500*vote/standvote;
            setNum(str.substring(3), textViewList.get(i));
            imageViewList.get(i).getLayoutParams().height = 30;
            imageViewList.get(i).getLayoutParams().width = percent;
            imageViewList.get(i).requestLayout();
            textViewList.get(i).setText(str.substring(3));
        }

    }
    //당첨번호 숫자별로 색깔 다르게 해서 넣기
    public void setNum(String nums, TextView textView) {
        int num = Integer.parseInt(nums);
        if (num > 0 && num < 10) {
            textView.setBackground(getResources().getDrawable(R.drawable.onetoten));
        } else if (num >= 10 && num < 20) {
            textView.setBackground(getResources().getDrawable(R.drawable.tentonineteen));
        } else if (num >= 20 && num < 30) {
            textView.setBackground(getResources().getDrawable(R.drawable.twentytothirty));
        } else if (num >= 30 && num < 40) {
            textView.setBackground(getResources().getDrawable(R.drawable.thirtytofirty));
        } else if (num >= 40) {
            textView.setBackground(getResources().getDrawable(R.drawable.firtytofirtyfive));
        }
    }


}
