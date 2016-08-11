package edu.feicui.app.phone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.feicui.app.phone.R;
import edu.feicui.app.phone.entity.TelnumberInfo;

public class TellistAdapter
        extends BaseDataAdapter
{
    private ArrayList<TelnumberInfo> adapterDatas = new ArrayList();
    private LayoutInflater layoutInflater;

    @SuppressWarnings("WrongConstant")
    public TellistAdapter(Context paramContext)
    {
        super(paramContext);
        this.layoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    }

    public void addDataToAdapter(TelnumberInfo paramTelnumberInfo)
    {
        if (paramTelnumberInfo != null) {
            this.adapterDatas.add(paramTelnumberInfo);
        }
    }

    public void addDataToAdapter(List paramList)
    {
        if (paramList != null) {
            this.adapterDatas.addAll(paramList);
        }
    }

    public int getCount()
    {
        return this.adapterDatas.size();
    }

    public ArrayList<TelnumberInfo> getDataFromAdapter()
    {
        return this.adapterDatas;
    }

    public TelnumberInfo getItem(int paramInt)
    {
        return (TelnumberInfo)this.adapterDatas.get(paramInt);
    }

    public long getItemId(int paramInt)
    {
        return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
        if (paramView == null) {
            paramView = this.layoutInflater.inflate(R.layout.inflate_tellist_listitem, null);
        }
        TextView localTextView1 = (TextView)paramView.findViewById(R.id.tv_name);
        TextView localTextView2 = (TextView)paramView.findViewById(R.id.tv_number);
        localTextView1.setText(getItem(paramInt).name);
        localTextView2.setText(getItem(paramInt).number);
        System.out.println(getItem(paramInt).name + getItem(paramInt).number);
        return paramView;
    }

    public void replaceDataToAdapter(List<TelnumberInfo> paramList)
    {
        if (paramList != null)
        {
            this.adapterDatas.clear();
            this.adapterDatas.addAll(paramList);
        }
    }
}
