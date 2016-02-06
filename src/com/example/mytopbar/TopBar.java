package com.example.mytopbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TopBar extends RelativeLayout{

	private Button leftButton;
	private Button rightButton;
	private TextView titleTextView;
	
	private int leftTextColor;
	private int rightTextColor;
	private Drawable leftBackground;
	private Drawable rightBackground;
	private String leftString;
	private String rightString;
	private float titleTextSize;
	private int titleTextColor;
	private String titleString;
	
	private LayoutParams leftParams;
	private LayoutParams rightParams;
	private LayoutParams titleParams;
	public TopBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray myArray = context.obtainStyledAttributes(attrs,R.styleable.TopBar);
		
		leftTextColor = myArray.getColor(R.styleable.TopBar_leftTextColor, 0);
		leftBackground = myArray.getDrawable(R.styleable.TopBar_leftBackground);
		leftString = myArray.getString(R.styleable.TopBar_leftText);
		
		rightTextColor = myArray.getColor(R.styleable.TopBar_rightTextColor, 0);
		rightBackground = myArray.getDrawable(R.styleable.TopBar_rightBackground);
		rightString = myArray.getString(R.styleable.TopBar_rightText);
		
		titleTextSize = myArray.getDimension(R.styleable.TopBar_titleTextSize,0);
		titleTextColor = myArray.getColor(R.styleable.TopBar_titleTextColor, 0);
		titleString = myArray.getString(R.styleable.TopBar_title);
		
		myArray.recycle();
		
		leftButton = new Button(context);
		rightButton = new Button(context);
		titleTextView = new TextView(context);
		
		leftButton.setTextColor(leftTextColor);
		leftButton.setBackground(leftBackground);
		leftButton.setText(leftString);
		
		rightButton.setTextColor(rightTextColor);
		rightButton.setBackground(rightBackground);
		rightButton.setText(rightString);
		
		titleTextView.setText(titleString);
		titleTextView.setTextSize(titleTextSize);
		titleTextView.setTextColor(titleTextColor);
		titleTextView.setGravity(Gravity.CENTER);
		
		setBackgroundColor(0xFFF59563);
		
		leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
		
		addView(leftButton,leftParams);
		
		rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
		
		addView(rightButton,rightParams);
		
		titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.MATCH_PARENT);
		titleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
		
		addView(titleTextView,titleParams);
		
	}
	
}
