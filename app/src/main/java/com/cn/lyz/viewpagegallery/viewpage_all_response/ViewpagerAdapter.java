package com.cn.lyz.viewpagegallery.viewpage_all_response;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cn.lyz.viewpagegallery.R;

import java.util.ArrayList;

/**
 * Created by yunzhao.liu on 2017/12/6
 */

public class ViewpagerAdapter extends PagerAdapter {

    private Context mContext;
    private ViewPager mVp;
    private ArrayList<Page> mList;
    private LayoutInflater mInflater;

    public ViewpagerAdapter(Context context, ViewPager vp, ArrayList<Page> list) {
        this.mContext = context;
        this.mVp = vp;
        this.mList = list;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        Page page = mList.get(position);
        View view = mInflater.inflate(R.layout.vp_adapter_layout, null);
        RelativeLayout root = (RelativeLayout) view.findViewById(R.id.root);
        TextView mTv = (TextView) view.findViewById(R.id.position);

        mTv.setText(page.getPageNum() + "");
        view.setTag(position);//设置tag便于点击时获取点的View
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, position + "", Toast.LENGTH_SHORT).show();
            }
        });
        container.addView(view);
        return view;
    }
}
