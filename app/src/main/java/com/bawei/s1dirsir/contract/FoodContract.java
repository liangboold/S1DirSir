package com.bawei.s1dirsir.contract;





import com.bawei.s1dirsir.bean.BaseBean;
import com.bawei.s1dirsir.bean.JsonBean;
import com.bw.mvp.view.IView;

import io.reactivex.Observable;

/**
 * @ClassName FoodContract
 * @Author 李坤衡
 * @Date 2021/9/9 9:16
 * User: msi
 */
public interface FoodContract extends IView {

    void foodSuccess(JsonBean jsonBean);
    void classSuccess(JsonBean jsonBean);
    void thereSuccess(JsonBean jsonBean);
    void paitrcularsSuccess(BaseBean baseBean);
    void foodFailed(Throwable throwable);




}
