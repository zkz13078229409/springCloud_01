package zkz.example.cglib;

import zkz.example.Iproduct;

/**
 * create by: zkz
 * description: 一个生产者
 * create time: 8:43 2019/9/18
 * param :
 */
public class product  {
        /*销售*/
    public void saleProduct(float money){
        System.out.println("拿到钱销售产品"+money);
    }
    /*售后*/
    public void affetService(float money){
        System.out.println("提供售后服务.."+money);
    }

}
