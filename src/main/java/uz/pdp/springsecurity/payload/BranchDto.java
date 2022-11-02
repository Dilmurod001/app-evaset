package uz.pdp.springsecurity.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchDto {
    @NotNull(message = "required line")
    private String name;
    @NotNull(message = "required line")
    private Integer addressId;
    @NotNull(message = "required line")
    private Integer businessId;
}
