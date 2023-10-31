package WineService.domain.item;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Alcohol {
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;
    public Alcohol(){

    }

    public Alcohol(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
