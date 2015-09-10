package com.boomtown.ckesho.robobindingexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ckesho on 9/8/2015.
 */
public class CustomViewAdapter extends ArrayAdapter<CustomViewData> {
//Purpose of the custom ArrayAdapter<>
// 1) is so that you can set multiple objects withing the view by your data
// 2) is you can add a class ViewHolder that can recycle your views for each item ie row

    public CustomViewAdapter(Context context, int resource, ArrayList<CustomViewData> dataArrayList) {
        super(context,resource, dataArrayList);
    }

    static class ViewHolder{
        TextView tvname;
        TextView tvphonenumber;
        TextView tvemail;
    }

    //getView is called to get next view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        /*convertView - The old view to reuse, if possible. Note: You should
        check that this view is non-null and of an appropriate type before using.
        If it is not possible to convert this view to display the correct data,
        this method can create a new view
         */
        if(convertView==null){
            //
            LayoutInflater inflater=
                    LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.itemlayout, null);//was null

            viewHolder=new ViewHolder();

            viewHolder.tvname=(TextView) convertView.findViewById(R.id.tvName);
            viewHolder.tvphonenumber=(TextView) convertView.findViewById(R.id.tvNumber);
            viewHolder.tvemail=(TextView) convertView.findViewById(R.id.tvEmail);

            convertView.setTag(viewHolder);
        }
        else {
            //
            viewHolder=(ViewHolder)convertView.getTag();

        }

        CustomViewData customViewData = getItem(position);

        viewHolder.tvname.setText(customViewData.getTvname());
        viewHolder.tvphonenumber.setText(customViewData.getTvnumber());
        viewHolder.tvemail.setText(customViewData.getTvemail());


              return convertView;
    }
}
