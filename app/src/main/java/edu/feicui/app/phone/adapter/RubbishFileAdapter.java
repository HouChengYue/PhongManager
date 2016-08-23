package edu.feicui.app.phone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import edu.feicui.app.phone.R;
import edu.feicui.app.phone.base.adapter.BaseBaseAdapter;
import edu.feicui.app.phone.entity.RubbishFileInfo;
import edu.feicui.app.phone.util.CommonUtil;


public class RubbishFileAdapter extends BaseBaseAdapter<RubbishFileInfo> {

    private LayoutInflater layoutInflater;

    private CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int position = (Integer) buttonView.getTag();
            getItem(position).setClear(isChecked); // 更新当前CheckBox是否选中的实体数据
        }
    };

    public RubbishFileAdapter(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.layout_rubbishfile_listitem, null);
        }
        TextView tv_lable = (TextView) convertView.findViewById(R.id.tv_app_lable);
        TextView tv_size = (TextView) convertView.findViewById(R.id.tv_size);
        ImageView iv_icon = (ImageView) convertView.findViewById(R.id.iv_app_icon);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.cb_del);
        checkBox.setTag(position);
        checkBox.setOnCheckedChangeListener(checkedChangeListener);//ChekBox设置监听
        checkBox.setChecked(getItem(position).isClear());//图标是否被勾选
        tv_lable.setText(getItem(position).getSoftChinesename());
        tv_size.setText(CommonUtil.getFileSize(getItem(position).getSize()));
        iv_icon.setImageDrawable(getItem(position).getIcon());
        return convertView;
    }
@Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.layout_rubbishfile_listitem, null);
        }
        TextView tv_lable = (TextView) convertView.findViewById(R.id.tv_app_lable);
        TextView tv_size = (TextView) convertView.findViewById(R.id.tv_size);
        ImageView iv_icon = (ImageView) convertView.findViewById(R.id.iv_app_icon);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.cb_del);
        checkBox.setTag(position);
        checkBox.setOnCheckedChangeListener(checkedChangeListener);//ChekBox设置监听
        checkBox.setChecked(getItem(position).isClear());//图标是否被勾选
        tv_lable.setText(getItem(position).getSoftChinesename());
        tv_size.setText(CommonUtil.getFileSize(getItem(position).getSize()));
        iv_icon.setImageDrawable(getItem(position).getIcon());
        return convertView;
    }
@Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.layout_rubbishfile_listitem, null);
        }
        TextView tv_lable = (TextView) convertView.findViewById(R.id.tv_app_lable);
        TextView tv_size = (TextView) convertView.findViewById(R.id.tv_size);
        ImageView iv_icon = (ImageView) convertView.findViewById(R.id.iv_app_icon);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.cb_del);
        checkBox.setTag(position);
        checkBox.setOnCheckedChangeListener(checkedChangeListener);//ChekBox设置监听
        checkBox.setChecked(getItem(position).isClear());//图标是否被勾选
        tv_lable.setText(getItem(position).getSoftChinesename());
        tv_size.setText(CommonUtil.getFileSize(getItem(position).getSize()));
        iv_icon.setImageDrawable(getItem(position).getIcon());
        return convertView;
    }
@Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.layout_rubbishfile_listitem, null);
        }
        TextView tv_lable = (TextView) convertView.findViewById(R.id.tv_app_lable);
        TextView tv_size = (TextView) convertView.findViewById(R.id.tv_size);
        ImageView iv_icon = (ImageView) convertView.findViewById(R.id.iv_app_icon);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.cb_del);
        checkBox.setTag(position);
        checkBox.setOnCheckedChangeListener(checkedChangeListener);//ChekBox设置监听
        checkBox.setChecked(getItem(position).isClear());//图标是否被勾选
        tv_lable.setText(getItem(position).getSoftChinesename());
        tv_size.setText(CommonUtil.getFileSize(getItem(position).getSize()));
        iv_icon.setImageDrawable(getItem(position).getIcon());
        return convertView;
    }
@Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.layout_rubbishfile_listitem, null);
        }
        TextView tv_lable = (TextView) convertView.findViewById(R.id.tv_app_lable);
        TextView tv_size = (TextView) convertView.findViewById(R.id.tv_size);
        ImageView iv_icon = (ImageView) convertView.findViewById(R.id.iv_app_icon);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.cb_del);
        checkBox.setTag(position);
        checkBox.setOnCheckedChangeListener(checkedChangeListener);//ChekBox设置监听
        checkBox.setChecked(getItem(position).isClear());//图标是否被勾选
        tv_lable.setText(getItem(position).getSoftChinesename());
        tv_size.setText(CommonUtil.getFileSize(getItem(position).getSize()));
        iv_icon.setImageDrawable(getItem(position).getIcon());
        return convertView;
    }
@Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.layout_rubbishfile_listitem, null);
        }
        TextView tv_lable = (TextView) convertView.findViewById(R.id.tv_app_lable);
        TextView tv_size = (TextView) convertView.findViewById(R.id.tv_size);
        ImageView iv_icon = (ImageView) convertView.findViewById(R.id.iv_app_icon);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.cb_del);
        checkBox.setTag(position);
        checkBox.setOnCheckedChangeListener(checkedChangeListener);//ChekBox设置监听
        checkBox.setChecked(getItem(position).isClear());//图标是否被勾选
        tv_lable.setText(getItem(position).getSoftChinesename());
        tv_size.setText(CommonUtil.getFileSize(getItem(position).getSize()));
        iv_icon.setImageDrawable(getItem(position).getIcon());
        return convertView;
    }@Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.layout_rubbishfile_listitem, null);
        }
        TextView tv_lable = (TextView) convertView.findViewById(R.id.tv_app_lable);
        TextView tv_size = (TextView) convertView.findViewById(R.id.tv_size);
        ImageView iv_icon = (ImageView) convertView.findViewById(R.id.iv_app_icon);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.cb_del);
        checkBox.setTag(position);
        checkBox.setOnCheckedChangeListener(checkedChangeListener);//ChekBox设置监听
        checkBox.setChecked(getItem(position).isClear());//图标是否被勾选
        tv_lable.setText(getItem(position).getSoftChinesename());
        tv_size.setText(CommonUtil.getFileSize(getItem(position).getSize()));
        iv_icon.setImageDrawable(getItem(position).getIcon());
        return convertView;
    }private CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int position = (Integer) buttonView.getTag();
            getItem(position).setClear(isChecked); // 更新当前CheckBox是否选中的实体数据
        }
    };
}