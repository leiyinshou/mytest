package cn.kgc.demo.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Sale {
    private Integer id;

    private Double price;

    private Integer quantity;

    private Double totalprice;

    private Date saledate;

    private Integer userid;

    private Integer productid;

    private Product product;

    private Users users;


}