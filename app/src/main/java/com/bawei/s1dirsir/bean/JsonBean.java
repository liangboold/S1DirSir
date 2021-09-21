package com.bawei.s1dirsir.bean;

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
     * status : 0
     * message : 分类列表获取成功
     * data : [{"id":1,"categoryName":"电脑办公","parentId":0},{"id":2,"categoryName":"手机数码","parentId":0},{"id":3,"categoryName":"男装","parentId":0},{"id":4,"categoryName":"女装","parentId":0},{"id":5,"categoryName":"家用电器","parentId":0},{"id":6,"categoryName":"食品生鲜","parentId":0},{"id":7,"categoryName":"酒水饮料","parentId":0},{"id":8,"categoryName":"玩具乐器","parentId":0},{"id":9,"categoryName":"汽车用品","parentId":0},{"id":10,"categoryName":"家具家装","parentId":0},{"id":11,"categoryName":"礼品鲜花","parentId":0},{"id":12,"categoryName":"生活旅行","parentId":0},{"id":13,"categoryName":"二手商品","parentId":0}]
     */

    private int status;
    private String message;
    /**
     * id : 1
     * categoryName : 电脑办公
     * parentId : 0
     */

    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonBean{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Parcelable {
        private int id;
        private String categoryName;
        private int parentId;

        protected DataBean(Parcel in) {
            id = in.readInt();
            categoryName = in.readString();
            parentId = in.readInt();
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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", categoryName='" + categoryName + '\'' +
                    ", parentId=" + parentId +
                    '}';
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeString(categoryName);
            dest.writeInt(parentId);
        }
    }
}
