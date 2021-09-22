package com.bawei.s1dirsir

/**
 *@package:com.bawei.s1dirsir
 *@fileName:GetGoodsListReq
 *@date on:2021/9/21 20:48
 *@another:HG
 *@email:1572651596@qq.com
 */
data class GetGoodsListReq(val categoryId: Int,val pageNo: Int) {

    override fun toString(): String {
        return "GetGoodsListReq(categoryId=$categoryId,pageNo=$pageNo)"
    }
}