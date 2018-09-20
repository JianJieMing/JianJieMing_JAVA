package Test01.exception;

/**
 * 异常
 * @author 铭
 */
public class GoodsCartFullException extends RuntimeException{
    public GoodsCartFullException(String cartName){
        super(cartName + "满了");
    }
}
