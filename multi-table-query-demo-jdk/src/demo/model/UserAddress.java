package demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class UserAddress extends BaseModel {
    private String userId;
    private String province;
    private String street;
    private String streetCode;
    private Address addressUserAddress;
}
