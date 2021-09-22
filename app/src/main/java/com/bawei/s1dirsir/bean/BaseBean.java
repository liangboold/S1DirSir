package com.bawei.s1dirsir.bean;

import java.util.List;

/*
 * @ClassName BaseBean
 * @Description TODO
 * @Author 康泽林
 * @Date 2021/9/21 19:42
 * @Version 1.0
 */
public class BaseBean {

    /**
     * status : 0
     * message : 列表获取成功
     * data : [{"id":1,"categoryId":14,"goodsDesc":"Apple MacBook Air 13.3英寸笔记本电脑 银色(Core i5 处理器/8GB内存/128GB SSD闪存 MMGF2CH/A)","goodsDefaultIcon":"https://img11.360buyimg.com/n7/jfs/t2968/143/2485546147/238650/70df281e/57b12a31N8f4f75a3.jpg","goodsDefaultPrice":"100","goodsDetailOne":"https://img20.360buyimg.com/vc/jfs/t3034/151/748569500/226790/d6cd86a2/57b15612N81dc489d.jpg","goodsDetailTwo":"https://img20.360buyimg.com/vc/jfs/t2683/60/4222930118/169462/233c7678/57b15616N1e285f09.jpg","goodsSalesCount":5000,"goodsStockCount":10000,"goodsCode":"10000000001","goodsDefaultSku":"1.6GHz i5处理器,GB内存/128GB SSD,1件","maxPage":2},{"id":2,"categoryId":14,"goodsDesc":"Apple MacBook Pro 13.3英寸笔记本电脑 银色(Core i5 处理器/8GB内存/128GB SSD闪存/Retina屏 MF839CH/A)","goodsDefaultIcon":"https://img13.360buyimg.com/n7/jfs/t2590/338/4222589387/237425/25e40fb/57b12ac6N61374a75.jpg","goodsDefaultPrice":"200","goodsDetailOne":"https://img20.360buyimg.com/vc/jfs/t2218/160/1600609450/672652/12ef3837/56600724N28581935.jpg","goodsDetailTwo":"https://img20.360buyimg.com/vc/jfs/t2305/205/1525153851/648458/79706530/56600727N1022ecd8.jpg","goodsSalesCount":13530,"goodsStockCount":800,"goodsCode":"10000000002","goodsDefaultSku":"13.3英寸/双核 i5/8G/128G闪存,1件","maxPage":2},{"id":3,"categoryId":14,"goodsDesc":"Apple MacBook Pro 15.4英寸笔记本电脑 深空灰色（Multi-Touch Bar/Core i7/16GB/256GB MLH32CH/A）","goodsDefaultIcon":"https://img10.360buyimg.com/n7/jfs/t3499/165/739574790/179345/251c51d4/58126465Na27a9bf0.jpg","goodsDefaultPrice":"100","goodsDetailOne":"https://img12.360buyimg.com/cms/jfs/t3760/42/740411238/146541/be42da9e/581266b4N7360a7e4.jpg","goodsDetailTwo":"https://img13.360buyimg.com/cms/jfs/t3367/226/740508746/107595/414c65e6/581266b7Nea97b88f.jpg","goodsSalesCount":1350,"goodsStockCount":8200,"goodsCode":"10000000003","goodsDefaultSku":"银色,Core i5/8G内存/256G闪存,1件","maxPage":2},{"id":4,"categoryId":14,"goodsDesc":"Apple 苹果 MacBook Air 13.3英寸笔记本电脑 MMGF2CH/A银色 Core i5/8G内存/128G闪存","goodsDefaultIcon":"https://img13.360buyimg.com/n1/jfs/t5821/151/4295371754/246251/29179c11/594a3eabNbf7fceec.jpg","goodsDefaultPrice":"300","goodsDetailOne":"https://img30.360buyimg.com/popWaterMark/jfs/t5746/329/4801800135/218275/4a67f0ef/5954a40fNf471b55d.jpg","goodsDetailTwo":"https://img30.360buyimg.com/popWareDetail/jfs/t6532/96/2593310/189936/1c5b2d94/5937a66aN594f4851.jpg","goodsSalesCount":2350,"goodsStockCount":3400,"goodsCode":"10000000005","goodsDefaultSku":"MMGF2CH/A银色,Core i5/8G内存/128G闪存,1件","maxPage":2},{"id":5,"categoryId":14,"goodsDesc":"Apple 苹果 MacBook Pro 笔记本电脑 16年新款 15英寸 Multi-Touch Bar 256G 深空灰色","goodsDefaultIcon":"https://img14.360buyimg.com/n5/s450x450_jfs/t3397/55/762020838/184157/7e507d32/58131c17Nb108ca54.jpg","goodsDefaultPrice":"800","goodsDetailOne":"https://img10.360buyimg.com/imgzone/jfs/t3082/24/2402653567/223529/1a6b04b/57e0d2f8N10eb5602.jpg","goodsDetailTwo":"https://img30.360buyimg.com/popWaterMark/jfs/t6241/302/1026912919/130228/685bcc83/5949c952N88858337.jpg","goodsSalesCount":150,"goodsStockCount":900,"goodsCode":"10000000006","goodsDefaultSku":"13英寸 Core i5 8G内存 256G闪存,深空灰色,1件","maxPage":2},{"id":6,"categoryId":14,"goodsDesc":"Apple MacBook Air 13.3英寸笔记本电脑 银色(Core i5 处理器/8GB内存/128GB SSD闪存 MMGF2CH/A)","goodsDefaultIcon":"https://img11.360buyimg.com/n7/jfs/t2968/143/2485546147/238650/70df281e/57b12a31N8f4f75a3.jpg","goodsDefaultPrice":"100","goodsDetailOne":"https://img20.360buyimg.com/vc/jfs/t3034/151/748569500/226790/d6cd86a2/57b15612N81dc489d.jpg","goodsDetailTwo":"https://img20.360buyimg.com/vc/jfs/t2683/60/4222930118/169462/233c7678/57b15616N1e285f09.jpg","goodsSalesCount":5000,"goodsStockCount":10000,"goodsCode":"10000000001","goodsDefaultSku":"1.6GHz i5处理器,GB内存/128GB SSD,1件","maxPage":2}]
     */

    private int status;
    private String message;
    /**
     * id : 1
     * categoryId : 14
     * goodsDesc : Apple MacBook Air 13.3英寸笔记本电脑 银色(Core i5 处理器/8GB内存/128GB SSD闪存 MMGF2CH/A)
     * goodsDefaultIcon : https://img11.360buyimg.com/n7/jfs/t2968/143/2485546147/238650/70df281e/57b12a31N8f4f75a3.jpg
     * goodsDefaultPrice : 100
     * goodsDetailOne : https://img20.360buyimg.com/vc/jfs/t3034/151/748569500/226790/d6cd86a2/57b15612N81dc489d.jpg
     * goodsDetailTwo : https://img20.360buyimg.com/vc/jfs/t2683/60/4222930118/169462/233c7678/57b15616N1e285f09.jpg
     * goodsSalesCount : 5000
     * goodsStockCount : 10000
     * goodsCode : 10000000001
     * goodsDefaultSku : 1.6GHz i5处理器,GB内存/128GB SSD,1件
     * maxPage : 2
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
        return "BaseBean{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean {
        private int id;
        private int categoryId;
        private String goodsDesc;
        private String goodsDefaultIcon;
        private String goodsDefaultPrice;
        private String goodsDetailOne;
        private String goodsDetailTwo;
        private int goodsSalesCount;
        private int goodsStockCount;
        private String goodsCode;
        private String goodsDefaultSku;
        private int maxPage;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getGoodsDesc() {
            return goodsDesc;
        }

        public void setGoodsDesc(String goodsDesc) {
            this.goodsDesc = goodsDesc;
        }

        public String getGoodsDefaultIcon() {
            return goodsDefaultIcon;
        }

        public void setGoodsDefaultIcon(String goodsDefaultIcon) {
            this.goodsDefaultIcon = goodsDefaultIcon;
        }

        public String getGoodsDefaultPrice() {
            return goodsDefaultPrice;
        }

        public void setGoodsDefaultPrice(String goodsDefaultPrice) {
            this.goodsDefaultPrice = goodsDefaultPrice;
        }

        public String getGoodsDetailOne() {
            return goodsDetailOne;
        }

        public void setGoodsDetailOne(String goodsDetailOne) {
            this.goodsDetailOne = goodsDetailOne;
        }

        public String getGoodsDetailTwo() {
            return goodsDetailTwo;
        }

        public void setGoodsDetailTwo(String goodsDetailTwo) {
            this.goodsDetailTwo = goodsDetailTwo;
        }

        public int getGoodsSalesCount() {
            return goodsSalesCount;
        }

        public void setGoodsSalesCount(int goodsSalesCount) {
            this.goodsSalesCount = goodsSalesCount;
        }

        public int getGoodsStockCount() {
            return goodsStockCount;
        }

        public void setGoodsStockCount(int goodsStockCount) {
            this.goodsStockCount = goodsStockCount;
        }

        public String getGoodsCode() {
            return goodsCode;
        }

        public void setGoodsCode(String goodsCode) {
            this.goodsCode = goodsCode;
        }

        public String getGoodsDefaultSku() {
            return goodsDefaultSku;
        }

        public void setGoodsDefaultSku(String goodsDefaultSku) {
            this.goodsDefaultSku = goodsDefaultSku;
        }

        public int getMaxPage() {
            return maxPage;
        }

        public void setMaxPage(int maxPage) {
            this.maxPage = maxPage;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", categoryId=" + categoryId +
                    ", goodsDesc='" + goodsDesc + '\'' +
                    ", goodsDefaultIcon='" + goodsDefaultIcon + '\'' +
                    ", goodsDefaultPrice='" + goodsDefaultPrice + '\'' +
                    ", goodsDetailOne='" + goodsDetailOne + '\'' +
                    ", goodsDetailTwo='" + goodsDetailTwo + '\'' +
                    ", goodsSalesCount=" + goodsSalesCount +
                    ", goodsStockCount=" + goodsStockCount +
                    ", goodsCode='" + goodsCode + '\'' +
                    ", goodsDefaultSku='" + goodsDefaultSku + '\'' +
                    ", maxPage=" + maxPage +
                    '}';
        }
    }

}
