package com.boomtown.ckesho.robobindingexample;

import android.content.Context;
import android.util.Log;
import android.view.View;

import org.robobinding.annotation.ItemPresentationModel;
import org.robobinding.itempresentationmodel.*;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;
import org.robobinding.annotation.*;
import org.robobinding.widget.adapterview.ItemClickEvent;
import org.robobinding.widget.view.ClickEvent;

/**
 * Created by ckesho on 9/9/2015.
 */
@PresentationModel
//public class PresentationModel1 {
    public class PresentationModel1 implements HasPresentationModelChangeSupport, org.robobinding.itempresentationmodel.ItemPresentationModel<CustomViewData> {

    static final String TAG="tiger";

    private PresentationModelChangeSupport changeSupport;
    private View view;
    private String robotext;
    private String btnset;
    private CustomViewData customViewData;
    private String email;


        @Override
        public PresentationModelChangeSupport getPresentationModelChangeSupport() {
            //return new PresentationModelChangeSupport(this);//use to be null
            //return null;
            return changeSupport;
        }


        //constructor
        public PresentationModel1() {
            //this.view = view;
            changeSupport = new PresentationModelChangeSupport(this);

            robotext="robotext";
            btnset="mysetbutton";
        }


    public String getRobotext()
    {
        return robotext;
    }

    public void setRobotext (String robotext)
    {
        this.robotext=robotext;
    }

    public String getBtnset()
    {
        return btnset;
    }

    public void setBtnset(String text)
    {
        this.btnset=text;

    }

    public void roboclickgetmethod(){

        //Call fireproperty change when you are ready to
        // update the view with any changes
        changeSupport.firePropertyChange("btnset");
        changeSupport.firePropertyChange("robotext");

        Log.i(TAG, "roboclickGETmethod");
    }
    public void roboclicksetmethod(){
        /*
        make your necessary changes but note
        they will not show until you call
        firepropertychange()
        */
        setRobotext("chris");
        setBtnset("tryharder");

        //changeSupport.firePropertyChange("btnset");
        //changeSupport.firePropertyChange("robotext");

        Log.i(TAG, "roboclickSETmethod");
    }
    public void listcontact(ItemClickEvent event){// or you can use public void listcontact(ItemClickEvent event){ if you need the click event info
        String position="position is #"+event.getPosition();
        setRobotext(position);
        changeSupport.firePropertyChange("robotext");

        Log.i(TAG, "listcontact");
    }

    @ItemPresentationModel(PresentationModel1.class)
    public String getEmail() {
        Log.i(TAG, "cvd.class");
       return email;
    }

    public void setEmail (String email){
        this.email="email";
    }

    //required implementation for adapters
    @Override
    public void updateData(CustomViewData data, ItemContext itemContext) {
        //this.customViewData.setTvemail(data.getTvemail());
        this.customViewData.setTvemail("setting email");
        Log.i(TAG, "settting CVD email");
        itemContext.getPosition();
    }





    public void setCustomViewData(CustomViewData customViewData) {
        customViewData.setTvemail("email@email.com");
        this.customViewData = customViewData;
        Log.i(TAG, "settting CVD email2");
    }

}
