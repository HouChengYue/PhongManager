package edu.feicui.app.phone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @param <E>
 */
public abstract class BaseDataAdapter<E> extends BaseAdapter {
	private ArrayList<E> adapterDatas = new ArrayList<E>();
	protected LayoutInflater layoutInflater;//
	protected Context context;

	public BaseDataAdapter(Context context) {
		this.context = context;
		layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	public ArrayList<E> getDataFromAdapter() {
		return adapterDatas;
	}

	public void clearAdapter() {
		adapterDatas.clear();
	}

	public void addDataToAdapter(E e) {
		if (e != null) {
			adapterDatas.add(e);
		}
	}

	public void addDataToAdapter(List<E> e) {
		if (e != null) {
			adapterDatas.addAll(e);
		}
	}

	public void setDataToAdapter(List<E> e) {
		adapterDatas.clear();
		if (e != null) {
			adapterDatas.addAll(e);
		}
	}

	public void removeDataFromAdapter(E e) {
		adapterDatas.remove(e);
	}

	public void removeDataFromAdapter(int index) { // ɾ����ǰ����������������
		adapterDatas.remove(index);
	}

	@Override
	public int getCount() {
		return adapterDatas.size();
	}

	@Override
	public E getItem(int position) {
		// TODO Auto-generated method stub
		return adapterDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
}