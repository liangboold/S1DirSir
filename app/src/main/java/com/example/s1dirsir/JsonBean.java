package com.example.s1dirsir;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/*
 * @ClassName JsonBean
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/3 15:12
 * @Version 1.0
 */
public class JsonBean {
    /**
     * ret : 1
     * data : [{"id":"8289","title":"油焖大虾","pic":"http://www.qubaobei.com/ios/cf/uploadfile/132/9/8289.jpg","collect_num":"1670","food_str":"大虾 葱 生姜 植物油 料酒","num":1670},{"id":"2127","title":"四川回锅肉","pic":"http://www.qubaobei.com/ios/cf/uploadfile/132/3/2127.jpg","collect_num":"1591","food_str":"猪肉 青蒜 青椒 红椒 姜片","num":1591},{"id":"30630","title":"超简单芒果布丁","pic":"http://www.qubaobei.com/ios/cf/uploadfile/132/31/30630.jpg","collect_num":"1549","food_str":"QQ糖 牛奶 芒果","num":1549},{"id":"9073","title":"家常红烧鱼","pic":"http://www.qubaobei.com/ios/cf/uploadfile/132/10/9073.jpg","collect_num":"1426","food_str":"鲜鱼 姜 葱 蒜 花椒","num":1426},{"id":"10097","title":"家常煎豆腐","pic":"http://www.qubaobei.com/ios/cf/uploadfile/132/11/10097.jpg","collect_num":"1419","food_str":"豆腐 新鲜红椒 青椒 葱花 油","num":1419},{"id":"10509","title":"水煮肉片","pic":"http://www.qubaobei.com/ios/cf/uploadfile/132/11/10509.jpg","collect_num":"1342","food_str":"瘦猪肉 生菜 豆瓣酱 干辣椒 花椒","num":1342},{"id":"46968","title":"红糖苹果银耳汤","pic":"http://www.qubaobei.com/ios/cf/uploadfile/132/47/46968.jpg","collect_num":"1253","food_str":"银耳 苹果 红糖","num":1253},{"id":"10191","title":"麻婆豆腐","pic":"http://www.qubaobei.com/ios/cf/uploadfile/132/11/10191.jpg","collect_num":"1224","food_str":"豆腐 肉末 生抽 白糖 芝麻油","num":1224},{"id":"2372","title":"皮蛋瘦肉粥","pic":"http://www.qubaobei.com/ios/cf/uploadfile/132/3/2372.jpg","collect_num":"1151","food_str":"大米 皮蛋 猪肉 油条 香葱","num":1151},{"id":"2166","title":"蚂蚁上树","pic":"http://www.qubaobei.com/ios/cf/uploadfile/132/3/2166.jpg","collect_num":"1145","food_str":"红薯粉 肉 姜 蒜 花椒","num":1145}]
     */

    private int ret;
    /**
     * id : 8289
     * title : 油焖大虾
     * pic : http://www.qubaobei.com/ios/cf/uploadfile/132/9/8289.jpg
     * collect_num : 1670
     * food_str : 大虾 葱 生姜 植物油 料酒
     * num : 1670
     */

    private List<DataBean> data;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {
        private String id;
        private String title;
        private String pic;
        private String collect_num;
        private String food_str;
        private int num;

        protected DataBean(Parcel in) {
            id = in.readString();
            title = in.readString();
            pic = in.readString();
            collect_num = in.readString();
            food_str = in.readString();
            num = in.readInt();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getCollect_num() {
            return collect_num;
        }

        public void setCollect_num(String collect_num) {
            this.collect_num = collect_num;
        }

        public String getFood_str() {
            return food_str;
        }

        public void setFood_str(String food_str) {
            this.food_str = food_str;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(title);
            dest.writeString(pic);
            dest.writeString(collect_num);
            dest.writeString(food_str);
            dest.writeInt(num);
        }
    }
}
