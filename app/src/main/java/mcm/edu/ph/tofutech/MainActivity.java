package mcm.edu.ph.tofutech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCal = findViewById(R.id.btnCalculate);

        btnCal.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){

        EditText inputHrs = findViewById(R.id.inputHrs);
        TextView totalHrs = findViewById(R.id.totalHrs);
        TextView totalWage = findViewById(R.id.totalWage);
        TextView totalHrsOvt = findViewById(R.id.totalHrsOvt);
        TextView totalWageOvt = findViewById(R.id.totalWageOvt);

        double input = 0.0;
        double hours = 0.0;
        double wage = 0.0;
        double hours2 = 0.0;
        double wage2 = 0.0;

        input = Double.parseDouble(inputHrs.getText().toString());


        switch (view.getId()) {
            case R.id.btnCalculate:
                hours = input;
                totalHrs.setText(Double.toString(hours) + " hours");
                if(input > 8) {
                    wage = ((input - 8) * 130) + 800;
                    totalWage.setText("₱ " + Double.toString(wage));
                }
                else{
                    wage = input * 100;
                    totalWage.setText("₱ " + Double.toString(wage));
                }
                if(input > 8) {
                    hours2 = input - 8;
                    totalHrsOvt.setText(Double.toString(hours2) + " hours");
                }
                else{
                    totalHrsOvt.setText(Double.toString(0) + " hours");
                }
                if(input > 8){
                    wage2 = (input - 8) * 130;
                    totalWageOvt.setText("₱ " + Double.toString(wage2));
                }
                else {
                    totalWageOvt.setText("₱ " + Double.toString(0));
                }
                break;
        }
    }
}