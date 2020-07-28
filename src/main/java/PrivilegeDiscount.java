import java.math.BigDecimal;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class PrivilegeDiscount implements Discount {
    private static NavigableMap<Integer,Double> privilegeDiscountRange=new TreeMap<>();

    static {
        privilegeDiscountRange.put(0,0.10);
        privilegeDiscountRange.put(4001,0.15);
        privilegeDiscountRange.put(8001,0.20);
        privilegeDiscountRange.put(12001,0.30);
    }



    public double applyDiscount(double billingAmountWithoutDiscount) {
        Map.Entry<Integer, Double> rangeFound=privilegeDiscountRange.floorEntry((int)billingAmountWithoutDiscount);
        if (rangeFound.getKey()==0)
            return billingAmountWithoutDiscount* rangeFound.getValue();
        else if (rangeFound.getKey() == 4001)
            return (4000 * 0.10)+ (billingAmountWithoutDiscount-4000)*( rangeFound.getValue());
        else if(rangeFound.getKey() == 8001)
            return (4000 * 0.10)+ (4000 * 0.15)+(billingAmountWithoutDiscount-8000)*( rangeFound.getValue());
        else
            return (4000 * 0.10)+ (4000 * 0.15)+(4000 * 0.20)+(billingAmountWithoutDiscount-12000)*( rangeFound.getValue());

    }
}
