package com.zeezaglobal.dicerollingapp;

import static com.zeezaglobal.dicerollingapp.Constants.EIGHT_SIDE;
import static com.zeezaglobal.dicerollingapp.Constants.FOUR_SIDE;
import static com.zeezaglobal.dicerollingapp.Constants.SIX_SIDE;
import static com.zeezaglobal.dicerollingapp.Constants.TENS_TEN_SIDED;
import static com.zeezaglobal.dicerollingapp.Constants.TEN_SIDE;
import static com.zeezaglobal.dicerollingapp.Constants.TRUE_TEN;
import static com.zeezaglobal.dicerollingapp.Constants.TWELVE_SIDE;
import static com.zeezaglobal.dicerollingapp.Constants.TWENTY_SIDE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private Spinner diceSpinner;
    private Button rollBtn;
    private TextView resultTv;
    private EditText customEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_home);
        initComponents();

        List<String> diceList = new ArrayList<>();
        diceList.add("4 side dice");
        diceList.add("6 side dice");
        diceList.add("8 side dice");
        diceList.add("10 side dice");
        diceList.add("12 side dice");
        diceList.add("20 side dice");
        diceList.add("true 10 sided die");
        diceList.add("multiple of 10");
        ArrayAdapter<String> diceAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, diceList);
        diceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diceSpinner.setAdapter(diceAdapter);
diceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        customEditText.setText("");
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
});
        rollBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (customEditText.getText().toString().equals("")) {
                    switch (diceSpinner.getSelectedItemPosition()) {
                        case FOUR_SIDE:
                            Dice d4 = new Dice(4);
                            resultTv.setText(d4.rollDie() + "");
                            break;
                        case SIX_SIDE:
                            Dice d6 = new Dice(6);
                            resultTv.setText(d6.rollDie() + "");
                            break;
                        case EIGHT_SIDE:
                            Dice d8 = new Dice(8);
                            resultTv.setText(d8.rollDie() + "");
                            break;
                        case TEN_SIDE:
                            Dice d10 = new Dice(10);
                            resultTv.setText(d10.rollDie() + "");
                            break;
                        case TWELVE_SIDE:
                            Dice d12 = new Dice(12);
                            resultTv.setText(d12.rollDie() + "");
                            break;
                        case TWENTY_SIDE:
                            Dice d20 = new Dice(20);
                            resultTv.setText(d20.rollDie() + "");
                            break;
                        case TRUE_TEN:
                            Dice trueDice = new Dice(10);
                            resultTv.setText(trueDice.rollTrueTen() + "");
                            break;
                        case TENS_TEN_SIDED:
                            Dice tenthDice = new Dice(10);
                            resultTv.setText(tenthDice.rollTenthTen() + "");
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + diceSpinner.getSelectedItemPosition());
                    }
                }else{
                    Dice dCustom = new Dice(Integer.parseInt(customEditText.getText().toString()));
                    sharedPref.storeMyVal(HomeActivity.this, sharedPref.getMyVal(HomeActivity.this)+","+customEditText.getText().toString());

                    Log.d("shared_value",   sharedPref.getMyVal(HomeActivity.this) );
                    resultTv.setText(dCustom.rollDie() + "");
                }
            }
        });

    }

    private void initComponents() {
        diceSpinner = findViewById(R.id.select_dice_spinner);
        rollBtn = findViewById(R.id.roll_dice_btn);
        resultTv = findViewById(R.id.result_tv);
        customEditText = findViewById(R.id.custom_side_et);

    }
}