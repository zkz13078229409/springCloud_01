package zkz.example;
/**
 * create by: zkz
 * description: 
 * create time: 对生产厂家要求的接口 2019/9/18
 * param :  
 */
public interface Iproduct {
    /*销售*/
    public void saleProduct(float money);
    
    /*售后*/
    public void affetService(float money);
}
