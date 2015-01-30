package com.example.bmicalculator7;



import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	private RadioGroup units;
	private RadioButton eng,met;
	private Button 	calculateButton;
	private EditText heightText;
	private EditText weightText;
	private TextView result;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		result = (TextView)findViewById(R.id.resultLabel);
		heightText = (EditText)findViewById(R.id.heightText);
		weightText = (EditText)findViewById(R.id.weightText);
		calculateButton = (Button)findViewById(R.id.cal);
		units=(RadioGroup)findViewById(R.id.radioGroup1);
		eng=(RadioButton)findViewById(R.id.english);
		met=(RadioButton)findViewById(R.id.metric);
		
		
		calculateButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				double weight = Double.parseDouble(weightText.getText().toString());
				double height = Double.parseDouble(heightText.getText().toString());
				double ans=0;
				if(eng.isChecked()){
				ans = (weight*703)/(height*height);
				}
				else if(met.isChecked()){
				ans=(weight)/(height*height);
				}
			
				if(ans<18.5){
					result.setText("Your Bmi is:"+String.valueOf(ans)+" . You are Underweight");	
				}
				else if(ans<24.9){
					result.setText("Your Bmi is:"+String.valueOf(ans)+" . You are Normalweight");	
				}
				else if(ans<29.9){
					result.setText(result+". You are Overweight");	
				}
				else if(ans>30){
					result.setText(result+". You are Obese");	
				}
				
				
				
				
				
				
			}});
		
		units.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if(checkedId == R.id.english){
					heightText.setHint("inches");
					weightText.setHint("lbs");
				}
				else if(checkedId == R.id.metric){
					heightText.setHint("meters");
					weightText.setHint("kilograms");
				}
			}
		});
	
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
