package uz.pdp.springsecurity.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TradeDTO {

    private Integer customerId;
    /**
     * savdogar id
     */
    private Integer userId;

    /**
     * product idlari
     */
    private List<ProductTradeDto> productTraderDto;

    private Date payDate;

    private Integer branchId;


    private Integer payMethodId;
    /**
     * umumiy summa
     */
    /**
     * to'langan summa
     */
    private Double amountPaid;
    /**
     * qarz
     */
    private Integer currencyId;
    private Integer addressId;

}
