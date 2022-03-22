package com.example.pets.model.domain;

import java.util.List;

public class demoGoods {

    public Databean data;
    public String message;
    public Integer status_code;

    public Databean getData() {
        return data;
    }

    public void setData(Databean data) {
        this.data = data;
    }

    public static class Databean {
        public List<Databean.DataHK> data;
        public Integer total;
        public String brand;

        public List<DataHK> getData() {
            return data;
        }

        public void setData(List<DataHK> data) {
            this.data = data;
        }

        public static class DataHK {
            public Long goods_id;
            public String goods_name;
            public String goods_short_name;
            public String materiaurl;
            public String goods_desc;
            public Double price;
            public Integer price_pg;
            public String price_after;
            public Integer discount;
            public String bindtype;
            public Integer quota;
            public String picurl;
            public String picurls;
            public String couponurl;
            public Integer sales;
            public Integer start_time;
            public Integer end_time;
            public Integer pf_cid1;
            public Integer pf_cid2;
            public Integer pf_cid3;
            public String pf_cname1;
            public String pf_cname2;
            public String pf_cname3;
            public String jd_c_info;
            public Integer ispg;
            public Integer ishot;
            public String owner;
            public String brandcode;
            public String brandname;
            public Integer comments;
            public Integer goodcommentsshare;
            public String commission;
            public Double commissionshare;
            public Integer shopid;
            public String shopname;
            public Long spuid;
            public Double ordercommission;
            public Integer coupon_remain_quantity;
            public Integer coupon_total_quantity;
            public Integer coupon_take_quantity;
            public Double plusCommissionShare;
            public Integer uid;
            public String nickname;

            public Long getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(Long goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_short_name() {
                return goods_short_name;
            }

            public void setGoods_short_name(String goods_short_name) {
                this.goods_short_name = goods_short_name;
            }

            public String getMateriaurl() {
                return materiaurl;
            }

            public void setMateriaurl(String materiaurl) {
                this.materiaurl = materiaurl;
            }

            public String getGoods_desc() {
                return goods_desc;
            }

            public void setGoods_desc(String goods_desc) {
                this.goods_desc = goods_desc;
            }

            public Double getPrice() {
                return price;
            }

            public void setPrice(Double price) {
                this.price = price;
            }

            public Integer getPrice_pg() {
                return price_pg;
            }

            public void setPrice_pg(Integer price_pg) {
                this.price_pg = price_pg;
            }

            public String getPrice_after() {
                return price_after;
            }

            public void setPrice_after(String price_after) {
                this.price_after = price_after;
            }

            public Integer getDiscount() {
                return discount;
            }

            public void setDiscount(Integer discount) {
                this.discount = discount;
            }

            public String getBindtype() {
                return bindtype;
            }

            public void setBindtype(String bindtype) {
                this.bindtype = bindtype;
            }

            public Integer getQuota() {
                return quota;
            }

            public void setQuota(Integer quota) {
                this.quota = quota;
            }

            public String getPicurl() {
                return picurl;
            }

            public void setPicurl(String picurl) {
                this.picurl = picurl;
            }

            public String getPicurls() {
                return picurls;
            }

            public void setPicurls(String picurls) {
                this.picurls = picurls;
            }

            public String getCouponurl() {
                return couponurl;
            }

            public void setCouponurl(String couponurl) {
                this.couponurl = couponurl;
            }

            public Integer getSales() {
                return sales;
            }

            public void setSales(Integer sales) {
                this.sales = sales;
            }

            public Integer getStart_time() {
                return start_time;
            }

            public void setStart_time(Integer start_time) {
                this.start_time = start_time;
            }

            public Integer getEnd_time() {
                return end_time;
            }

            public void setEnd_time(Integer end_time) {
                this.end_time = end_time;
            }

            public Integer getPf_cid1() {
                return pf_cid1;
            }

            public void setPf_cid1(Integer pf_cid1) {
                this.pf_cid1 = pf_cid1;
            }

            public Integer getPf_cid2() {
                return pf_cid2;
            }

            public void setPf_cid2(Integer pf_cid2) {
                this.pf_cid2 = pf_cid2;
            }

            public Integer getPf_cid3() {
                return pf_cid3;
            }

            public void setPf_cid3(Integer pf_cid3) {
                this.pf_cid3 = pf_cid3;
            }

            public String getPf_cname1() {
                return pf_cname1;
            }

            public void setPf_cname1(String pf_cname1) {
                this.pf_cname1 = pf_cname1;
            }

            public String getPf_cname2() {
                return pf_cname2;
            }

            public void setPf_cname2(String pf_cname2) {
                this.pf_cname2 = pf_cname2;
            }

            public String getPf_cname3() {
                return pf_cname3;
            }

            public void setPf_cname3(String pf_cname3) {
                this.pf_cname3 = pf_cname3;
            }

            public String getJd_c_info() {
                return jd_c_info;
            }

            public void setJd_c_info(String jd_c_info) {
                this.jd_c_info = jd_c_info;
            }

            public Integer getIspg() {
                return ispg;
            }

            public void setIspg(Integer ispg) {
                this.ispg = ispg;
            }

            public Integer getIshot() {
                return ishot;
            }

            public void setIshot(Integer ishot) {
                this.ishot = ishot;
            }

            public String getOwner() {
                return owner;
            }

            public void setOwner(String owner) {
                this.owner = owner;
            }

            public String getBrandcode() {
                return brandcode;
            }

            public void setBrandcode(String brandcode) {
                this.brandcode = brandcode;
            }

            public String getBrandname() {
                return brandname;
            }

            public void setBrandname(String brandname) {
                this.brandname = brandname;
            }

            public Integer getComments() {
                return comments;
            }

            public void setComments(Integer comments) {
                this.comments = comments;
            }

            public Integer getGoodcommentsshare() {
                return goodcommentsshare;
            }

            public void setGoodcommentsshare(Integer goodcommentsshare) {
                this.goodcommentsshare = goodcommentsshare;
            }

            public String getCommission() {
                return commission;
            }

            public void setCommission(String commission) {
                this.commission = commission;
            }

            public Double getCommissionshare() {
                return commissionshare;
            }

            public void setCommissionshare(Double commissionshare) {
                this.commissionshare = commissionshare;
            }

            public Integer getShopid() {
                return shopid;
            }

            public void setShopid(Integer shopid) {
                this.shopid = shopid;
            }

            public String getShopname() {
                return shopname;
            }

            public void setShopname(String shopname) {
                this.shopname = shopname;
            }

            public Long getSpuid() {
                return spuid;
            }

            public void setSpuid(Long spuid) {
                this.spuid = spuid;
            }

            public Double getOrdercommission() {
                return ordercommission;
            }

            public void setOrdercommission(Double ordercommission) {
                this.ordercommission = ordercommission;
            }

            public Integer getCoupon_remain_quantity() {
                return coupon_remain_quantity;
            }

            public void setCoupon_remain_quantity(Integer coupon_remain_quantity) {
                this.coupon_remain_quantity = coupon_remain_quantity;
            }

            public Integer getCoupon_total_quantity() {
                return coupon_total_quantity;
            }

            public void setCoupon_total_quantity(Integer coupon_total_quantity) {
                this.coupon_total_quantity = coupon_total_quantity;
            }

            public Integer getCoupon_take_quantity() {
                return coupon_take_quantity;
            }

            public void setCoupon_take_quantity(Integer coupon_take_quantity) {
                this.coupon_take_quantity = coupon_take_quantity;
            }

            public Double getPlusCommissionShare() {
                return plusCommissionShare;
            }

            public void setPlusCommissionShare(Double plusCommissionShare) {
                this.plusCommissionShare = plusCommissionShare;
            }

            public Integer getUid() {
                return uid;
            }

            public void setUid(Integer uid) {
                this.uid = uid;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }
        }
    }
}
