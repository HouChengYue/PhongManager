package edu.feicui.app.phone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.feicui.app.phone.R;
import edu.feicui.app.phone.entity.TelclassInfo;


public class TelclassAdapter
        extends BaseDataAdapter
{
    private ArrayList<TelclassInfo> adapterDatas;
    private LayoutInflater layoutInflater;

    public TelclassAdapter(Context paramContext, ArrayList<TelclassInfo> adapterDatas)
    {
        super(paramContext);
        this.layoutInflater = layoutInflater.from(paramContext);
        this.adapterDatas=adapterDatas;
    }


    public void addDataToAdapter(TelclassInfo paramTelclassInfo)
    {
        if (paramTelclassInfo != null) {
            this.adapterDatas.add(paramTelclassInfo);
        }
    }

    public void addDataToAdapter(List paramList)
{
    if (paramList != null) {
        this.adapterDatas.addAll(paramList);
    }
}


    public void clearDataTOAdapter()
    {
        this.adapterDatas.clear();
    }

 @Override
    public int getCount()
    {
        return this.adapterDatas.size();
    }

    public ArrayList<TelclassInfo> getDataFromAdapter()
    {
        return this.adapterDatas;
    }

    public TelclassInfo getItem(int paramInt)
    {
        return this.adapterDatas.get(paramInt);
    }
    @Override
    public long getItemId(int paramInt)
    {
        return paramInt;
    }
    @Override
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {   View view;
        if (paramView != null) {
            view=paramView;
        }else{
            view=layoutInflater.inflate(R.layout.inflate_telmgr_listitem, null);
        }
        TextView tv=(TextView) view.findViewById(R.id.textview);
        tv.setText(adapterDatas.get(paramInt).name);
        System.out.println(adapterDatas.get(paramInt).name);
        return view;
    }
}
