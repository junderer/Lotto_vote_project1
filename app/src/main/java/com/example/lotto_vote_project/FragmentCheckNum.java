package com.example.lotto_vote_project;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class FragmentCheckNum extends Fragment {
    final List<RoundList> roundListsArray = new ArrayList<RoundList>();
    View view;
    Button qrcheckButton;
    Button pastNum;
    FirebaseFirestore db;
    public static boolean isNull = false;
    static int recentRoundNum;
    static RequestQueue requestQueue;
    TextView drw1TextView;
    TextView drw2TextView;
    TextView drw3TextView;
    TextView drw4TextView;
    TextView drw5TextView;
    TextView drw6TextView;
    TextView drwNoTextView;
    TextView bnunsNoTextView;
    TextView tosellamntTextView;
    TextView firstWinamntTextView;
    TextView firstPrzwnerCoTextView;
    TextView dateTextView;
    ArrayList<String> arrayListString;

    @SuppressLint("ResourceType")
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        db = FirebaseFirestore.getInstance();
        view = inflater.inflate(R.layout.fragment_checknum, container, false);
        qrcheckButton = view.findViewById(R.id.qrcheckButton);
        pastNum = view.findViewById(R.id.pastNumButton);

        drw1TextView = view.findViewById(R.id.drwtNo1textView);
        drw2TextView = view.findViewById(R.id.drwtNo2textView);
        drw3TextView = view.findViewById(R.id.drwtNo3textView);
        drw4TextView = view.findViewById(R.id.drwtNo4textView);
        drw5TextView = view.findViewById(R.id.drwtNo5textView);
        drw6TextView = view.findViewById(R.id.drwtNo6textView);
        bnunsNoTextView = view.findViewById(R.id.bnusNotextView);
        drwNoTextView = view.findViewById(R.id.drwNoTextView);
        tosellamntTextView = view.findViewById(R.id.tosellamntTextView);
        firstWinamntTextView = view.findViewById(R.id.firstWinamntTextView);
        firstPrzwnerCoTextView = view.findViewById(R.id.firstPrzwnerCoTextView);
        dateTextView = view.findViewById(R.id.textViewDate);

        recentRoundNum = 0;
        getRecentNum();


        drwNoTextView.setText(String.valueOf(recentRoundNum));
        qrcheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QRScanActivity.class);
                startActivity(intent);
            }
        });

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getContext());
        }


        pastNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
        return view;
    }

    public void getRecentNum() {
        DocumentReference docRef = db.collection("recentRound").document("rcRound");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        recentRoundNum = Integer.parseInt(document.getString("recentRoundNum"));
                        drwNoTextView.setText(String.valueOf(recentRoundNum));
                        makeRequest(recentRoundNum);
                        makeDialogList(recentRoundNum);

                    } else {
                        Toast.makeText(getContext(), "당첨번호 조회 실패", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getContext(), "최신 당첨번호 조회 실패", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    void show() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        Collections.sort(roundListsArray, new Comparator<RoundList>() {
            @Override
            public int compare(RoundList o1, RoundList o2) {
                int left = Integer.parseInt(o1.drwNo);
                int right = Integer.parseInt(o2.drwNo);
                if (left > right) return 1;
                else return -1;
            }
        });

        builder.setTitle("회차 선택");
        arrayListString = new ArrayList<String>();
        for (int i = roundListsArray.size() - 1; i >= 0; i--) {
            arrayListString.add(roundListsArray.get(i).drwNo + "회차 " + roundListsArray.get(i).drwNoDate);
        }
        final CharSequence[] items = arrayListString.toArray(new String[arrayListString.size()]);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int pos) {
                String selectedText = items[pos].toString();
                int a1 = selectedText.indexOf("회차");
                makeRequest(Integer.parseInt(selectedText.substring(0, a1)));
            }
        });
        builder.show();
    }

    public void makeDialogList(int recentRoundNum) {
        for (int i = recentRoundNum; i > 0; i--) {
            String url = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=" + i;
            StringRequest request = new StringRequest(
                    Request.Method.GET,
                    url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Gson gson = new Gson();
                            Lotto lotto = gson.fromJson(response, Lotto.class);
                            RoundList roundList = new RoundList();
                            roundList.drwNo = lotto.drwNo;
                            roundList.drwNoDate = lotto.drwNoDate;
                            roundListsArray.add(roundList);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            error.printStackTrace();
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    return super.getParams();
                }
            };

            request.setShouldCache(true);
            requestQueue.add(request);
        }
    }

    public void makeRequest(int whatTime) {
        String url = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=" + whatTime;

        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        processResponse(response);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        error.printStackTrace();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };

        request.setShouldCache(false);
        requestQueue.add(request);
    }

    public void processResponse(String response) {
        Gson gson = new Gson();
        Lotto lotto = gson.fromJson(response, Lotto.class);

        drwNoTextView.setText(lotto.drwNo + "회차");
        drw1TextView.setText(lotto.drwtNo1);
        drw2TextView.setText(lotto.drwtNo2);
        drw3TextView.setText(lotto.drwtNo3);
        drw4TextView.setText(lotto.drwtNo4);
        drw5TextView.setText(lotto.drwtNo5);
        drw6TextView.setText(lotto.drwtNo6);
        bnunsNoTextView.setText(lotto.bnusNo);
        String str = lotto.drwNoDate;
        str = str.substring(0,4) + "." + str.substring(5,7) +"." +  str.substring(8,10);
        dateTextView.setText(str);
        tosellamntTextView.setText(lotto.totSellamnt.substring(0, lotto.totSellamnt.length() - 8) + "억");
        firstWinamntTextView.setText(lotto.firstWinamnt.substring(0, lotto.firstWinamnt.length() - 8) + "억");
        firstPrzwnerCoTextView.setText(lotto.firstPrzwnerCo + "명");

        setNum(lotto.drwtNo1, drw1TextView);
        setNum(lotto.drwtNo2, drw2TextView);
        setNum(lotto.drwtNo3, drw3TextView);
        setNum(lotto.drwtNo4, drw4TextView);
        setNum(lotto.drwtNo5, drw5TextView);
        setNum(lotto.drwtNo6, drw6TextView);
        setNum(lotto.bnusNo, bnunsNoTextView);
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
