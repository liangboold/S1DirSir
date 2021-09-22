package com.bawei.s1dirsir.contract;

import com.bawei.s1dirsir.bean.BaseBean;
import com.bawei.s1dirsir.bean.JsonBean;
import com.bw.mvp.view.IView;

/*
 * @ClassName HomeContract
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/21 19:51
 * @Version 1.0
 */
public interface HomeContract extends IView {
    void foodSuccess(BaseBean baseBean);
    void foodFailed(Throwable throwable);
}
