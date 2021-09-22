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
     * data : [{"id":14,"categoryName":"Apple","categoryIcon":"https://img13.360buyimg.com/n7/jfs/t2590/338/4222589387/237425/25e40fb/57b12ac6N61374a75.jpg","parentId":1},{"id":15,"categoryName":"ThinkPad","categoryIcon":"https://img14.360buyimg.com/n7/jfs/t3556/223/2158676156/110226/59267230/584b5678Nbc9f1e70.jpg","parentId":1},{"id":16,"categoryName":"惠普","categoryIcon":"https://img10.360buyimg.com/n7/jfs/t3157/231/5756125504/98807/97ab361d/588084a1N06efb01d.jpg","parentId":1},{"id":17,"categoryName":"戴尔","categoryIcon":"https://img14.360buyimg.com/n7/jfs/t5971/255/1793524379/148460/f42e1432/59362fc2Nf55191b9.jpg","parentId":1},{"id":18,"categoryName":"华硕","categoryIcon":"https://img12.360buyimg.com/n7/jfs/t5878/352/2479795637/201591/d23a1872/5931182fN31cfa389.jpg","parentId":1},{"id":19,"categoryName":"神舟","categoryIcon":"https://img13.360buyimg.com/n7/jfs/t3052/126/5163722736/217313/f05d9003/5864c7dfNcfbc5e94.jpg","parentId":1},{"id":20,"categoryName":"外星人","categoryIcon":"https://img11.360buyimg.com/n7/jfs/t4687/130/1245474410/58260/f12a15bd/58db17dbNf5371a02.jpg","parentId":1},{"id":21,"categoryName":"微星","categoryIcon":"https://img12.360buyimg.com/n7/jfs/t6709/106/1129266372/226149/ab5f4641/594b8094Nb07793ab.jpg","parentId":1},{"id":22,"categoryName":"宏基","categoryIcon":"https://img11.360buyimg.com/n7/jfs/t5737/312/4822081047/162369/70bbd1b2/5954b785N1787db72.jpg","parentId":1},{"id":23,"categoryName":"雷神","categoryIcon":"https://img11.360buyimg.com/n7/jfs/t5671/2/2653805329/277901/cf0384f7/5932281fNeb08da02.jpg","parentId":1}]
     */

    private int status;
    private String message;
    /**
     * id : 14
     * categoryName : Apple
     * categoryIcon : https://img13.360buyimg.com/n7/jfs/t2590/338/4222589387/237425/25e40fb/57b12ac6N61374a75.jpg
     * parentId : 1
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
        private String categoryIcon;
        private int parentId;
        private boolean isCheck=false;

        protected DataBean(Parcel in) {
            id = in.readInt();
            categoryName = in.readString();
            categoryIcon = in.readString();
            parentId = in.readInt();
            isCheck = in.readByte() != 0;
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

        public String getCategoryIcon() {
            return categoryIcon;
        }

        public void setCategoryIcon(String categoryIcon) {
            this.categoryIcon = categoryIcon;
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
                    ", categoryIcon='" + categoryIcon + '\'' +
                    ", parentId=" + parentId +
                    '}';
        }

        public boolean isCheck() {
            return isCheck;
        }

        public void setCheck(boolean check) {
            isCheck = check;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeString(categoryName);
            dest.writeString(categoryIcon);
            dest.writeInt(parentId);
            dest.writeByte((byte) (isCheck ? 1 : 0));
        }
    }
}
