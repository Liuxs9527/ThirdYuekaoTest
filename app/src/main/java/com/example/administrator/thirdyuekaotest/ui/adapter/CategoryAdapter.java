package com.example.administrator.thirdyuekaotest.ui.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.thirdyuekaotest.R;
import com.example.administrator.thirdyuekaotest.data.bean.CategoryBean;

import java.util.List;

public class CategoryAdapter extends BaseQuickAdapter<CategoryBean.DataBean, BaseViewHolder> {
    public CategoryAdapter(int layoutResId, @Nullable List<CategoryBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CategoryBean.DataBean item) {
        helper.setText(R.id.tv_category, item.getName());
    }
}