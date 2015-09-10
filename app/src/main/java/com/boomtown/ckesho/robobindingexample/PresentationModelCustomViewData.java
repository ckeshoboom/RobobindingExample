package com.boomtown.ckesho.robobindingexample;

/**
 * Created by ckesho on 9/9/2015.
 */

import android.content.Context;
import android.util.Log;
import android.view.View;

import org.robobinding.itempresentationmodel.*;
import org.robobinding.itempresentationmodel.ItemPresentationModel;
import org.robobinding.presentationmodel.HasPresentationModelChangeSupport;
import org.robobinding.presentationmodel.PresentationModelChangeSupport;
import org.robobinding.annotation.*;
import org.robobinding.widget.adapterview.ItemClickEvent;
import org.robobinding.widget.view.ClickEvent;

@PresentationModel
public class PresentationModelCustomViewData implements ItemPresentationModel<CustomViewData> ,HasPresentationModelChangeSupport{

    //this is needed to create and update changes in your presentation
    private PresentationModelChangeSupport changeSupport;

    @Override
    public PresentationModelChangeSupport getPresentationModelChangeSupport() {
        //return new PresentationModelChangeSupport(this);//use to be null
        //return null;
        return changeSupport;
    }


    //constructor
    public PresentationModelCustomViewData() {
        //this.view = view;
        changeSupport = new PresentationModelChangeSupport(this);

        customViewData.setTvemail("robotext");

    }





    static final String TAG="tiger";
    //required implementation
    @Override
    public void updateData(CustomViewData data, ItemContext itemContext) {
        //this.customViewData.setTvemail(data.getTvemail());
        this.customViewData.setTvemail("setting email");
        Log.i(TAG, "settting CVD email");
        itemContext.getPosition();
    }

    private CustomViewData customViewData;

    public CustomViewData getCustomViewData() {
        return customViewData;
    }

    public void setCustomViewData(CustomViewData customViewData) {
        customViewData.setTvemail("email@email.com");
        this.customViewData = customViewData;
        Log.i(TAG, "settting CVD email2");
    }
}
