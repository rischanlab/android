package com.datepicker;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class datePicker extends Activity {
	protected static final int DATE_DIALOG_ID = 0;
	private TextView mDateDisplay;
	private Button mPickDate;
	private int mYear;
	private int mMonth;
	private int mDate;
	
	//static final int DATE_DIALOG_ID=0;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mDateDisplay=(TextView)findViewById(R.id.dateDisplay);
        mPickDate=(Button)findViewById(R.id.pickDate);
        
        mPickDate.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showDialog(DATE_DIALOG_ID);
			}
		});
        
        final Calendar c=Calendar.getInstance();
        mYear=c.get(Calendar.YEAR);
        mMonth=c.get(Calendar.MONTH);
        mDate=c.get(Calendar.DAY_OF_MONTH);
       //        mDateDisplay.setText(mDate);
        updateDisplay();
    }

	private void updateDisplay() {
		// TODO Auto-generated method stub
		mDateDisplay.setText(
			new StringBuilder()
			.append(mMonth+1).append("-")
			.append(mDate).append("-")
			.append(mYear).append(" "));
	}
	private DatePickerDialog.OnDateSetListener mDateListener=
		new DatePickerDialog.OnDateSetListener() {
			
			public void onDateSet(DatePicker view, int year, int month, int day) {
				// TODO Auto-generated method stub
				mYear=year;
			mMonth=month;
			mDate=day;
			}
		};
		protected Dialog onCreateDialog(int id){
			switch(id){
			case DATE_DIALOG_ID:
				return new DatePickerDialog(this,
						mDateListener,mYear,mMonth,mDate);
			}
			return null;
		}
}