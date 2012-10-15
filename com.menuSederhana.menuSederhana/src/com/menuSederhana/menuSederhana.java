package com.menuSederhana;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class menuSederhana extends Activity {
	Menu mymenu=null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    }
    public boolean onCreateOptionsMenu(Menu menu){
    	super.onCreateOptionsMenu(menu);
    	
    	this.mymenu=menu;
    	addRegularMenuItems(menu);
    	addMenukedua(menu);
    	
    	return true;
    }
    private void addRegularMenuItems(Menu menu){
    	int base=Menu.FIRST;
    	menu.add(base,base,base,"append");
    	menu.add(base,base+1,base+1,"item 1");
    	menu.add(base,base+2,base+2,"clear");
    	menu.add(base,base+3,base+3,"hide menuke2");
    	menu.add(base,base+4,base+4,"show menuke2");
    	menu.add(base,base+5,base+5,"enable menuke2");
    	menu.add(base,base+6,base+6,"disable menuke2");
    	menu.add(base,base+7,base+7,"check menuke2");
    	menu.add(base,base+8,base+8,"uncheck menuke2");
    	
    }
    private void addMenukedua(Menu menu){
    	int base=Menu.CATEGORY_SECONDARY;//nilai 2
    	menu.add(base,base+1,base+1,"Mn2-items1");
    	menu.add(base,base+2,base+2,"Mn2-items2");
    	menu.add(base,base+3,base+3,"Mn2-items3");
    	menu.add(base,base+4,base+4,"Mn2-items4");
    }
    public boolean onOptionsMenuSelected(MenuItem item){
    	if(item.getItemId()==1){
    		appendText("assalamualaikum");
    	}
    	else if(item.getItemId()==2){
    		appendText("\n_item2");
    	}
    	else if(item.getItemId()==3){
    		emptyText();
    	}
    	else if(item.getItemId()==4){
    		//hide menu2
    		this.appendMenuItemText(item);
    		this.mymenu.setGroupVisible(Menu.CATEGORY_SECONDARY, false);
    	}else if(item.getItemId()==5){
    		//show menu2
    		this.appendMenuItemText(item);
    		this.mymenu.setGroupVisible(Menu.CATEGORY_SECONDARY, true);
    	}
    	else if(item.getItemId()==6){
    		//enable menu2
    		this.appendMenuItemText(item);
    		this.mymenu.setGroupEnabled(Menu.CATEGORY_SECONDARY, true);
    	}
    	else if(item.getItemId()==7){
    		//disable menu2
    		this.appendMenuItemText(item);
    		this.mymenu.setGroupEnabled(Menu.CATEGORY_SECONDARY, false);
    	}
    	else if(item.getItemId()==8){
    		//check menu2
    		this.appendMenuItemText(item);
    		mymenu.setGroupCheckable(Menu.CATEGORY_SECONDARY, true,false);
    	}
    	else if(item.getItemId()==9){
    		//uncheck menu2
    		this.appendMenuItemText(item);
    		mymenu.setGroupCheckable(Menu.CATEGORY_SECONDARY, false,false);
    	}
    	else{
    		this.appendMenuItemText(item);
    	}
    	
    	return true;
    }
    private void appendMenuItemText(MenuItem menuItem) {
    	String title=menuItem.getTitle().toString();
    	TextView tv=(TextView)findViewById(R.id.ket);
    	tv.setText(tv.getText()+"\n"+title);
		// TODO Auto-generated method stub
		
	}
	private void emptyText() {
    	TextView tv=(TextView)findViewById(R.id.ket);
    	tv.setText(" ");
		// TODO Auto-generated method stub
		
	}
	private void appendText(String text){
    	TextView tv=(TextView)findViewById(R.id.ket);
    	tv.setText(tv.getText()+text);
    }
}