package com.bw.mvp.v;

import android.view.View;

import androidx.annotation.IdRes;

public interface IFragment {
    public <T extends View> T findViewById(@IdRes int id);
}
