package com.example.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

// Activity is the controller
public class TipCalc extends Activity implements OnClickListener{
	
	EditText totalAmtTextField;
	TextView tipTextField;
	
	Button tenButton;
	Button fifteenButton;
	Button twentyButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calc);
		
		tenButton = (Button)findViewById(R.id.tenPercentButton);
		fifteenButton = (Button)findViewById(R.id.fifteenPercentButton);
		twentyButton = (Button)findViewById(R.id.twentyPercentButton);
		
		// current instance of this class listens to each of these buttons
		tenButton.setOnClickListener(this);
		fifteenButton.setOnClickListener(this);
		twentyButton.setOnClickListener(this);
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calc, menu);
		return true;
	}

	@Override
	/* when one of the buttons that registered the onclick listener is clicked, that button is
	 * represented by v
	 */
	public void onClick(View v) {
		// TODO Auto-generated method stub
		totalAmtTextField = (EditText)findViewById(R.id.totalAmt);
		tipTextField = (TextView)findViewById(R.id.tipAmt);
		
		double tip = Double.parseDouble(totalAmtTextField.getText().toString());
		String tipStr;
		// if the 10% button was clicked
		if(v.getId() == tenButton.getId())
		{
			Log.i("clicks", "10% button was clicked");
			tip*=.10;
		}
		else if(v.getId() == fifteenButton.getId())
		{
			Log.i("clicks", "15% button was clicked");
			tip*=.15;
		}
		else
		{
			Log.i("clicks", "20% button was clicked");
			tip*=.20;
		}
		// round to 2 decimal places
		double roundedTip = Math.round(tip*100.0)/100.0;
		tipStr = Double.toString(roundedTip);
		
		tipTextField.setText(tipStr);
	}
	
}
