package ro.mycode.shoesSelectapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoesDTO {
    private String model="";
    private String material="";
    private String culoare="";
    private int pret=0;
}
