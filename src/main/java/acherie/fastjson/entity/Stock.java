package acherie.fastjson.entity;

import com.alibaba.fastjson.JSON;

/**
 * <p>User: wangjie
 * <p>Date: 1/12/2017
 */
public class Stock extends Response {

    private String goods_id;

    private String goods_name;

    private String weight_avb;

    private String weight_unit;

    public Stock(String goods_id, String goods_name, String weight_avb, String weight_unit) {
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.weight_avb = weight_avb;
        this.weight_unit = weight_unit;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public String getWeight_avb() {
        return weight_avb;
    }

    public String getWeight_unit() {
        return weight_unit;
    }

    public static void main(String[] args) {
        Stock stock = new StockBuilder().setGoods_id("22").setGoods_name("jife").createStock();
        System.out.println(stock);
        System.out.println(JSON.toJSONString(stock));
    }

    @Override
    public String toString() {
        return "Stock{" +
                "goods_id='" + goods_id + '\'' +
                ", goods_name='" + goods_name + '\'' +
                ", weight_avb='" + weight_avb + '\'' +
                ", weight_unit='" + weight_unit + '\'' +
                '}';
    }

    public static class StockBuilder extends MapBuilder {

        private String goods_id;
        private String goods_name;
        private String weight_avb;
        private String weight_unit = "ถึ";

        public StockBuilder setGoods_id(String goods_id) {
            this.goods_id = goods_id;
            return this;
        }

        public StockBuilder setGoods_name(String goods_name) {
            this.goods_name = goods_name;
            return this;
        }

        public StockBuilder setWeight_avb(String weight_avb) {
            this.weight_avb = weight_avb;
            return this;
        }

        public StockBuilder setWeight_unit(String weight_unit) {
            this.weight_unit = weight_unit;
            return this;
        }

        public Stock createStock() {
            return new Stock(goods_id, goods_name, weight_avb, weight_unit);
        }
    }
}
