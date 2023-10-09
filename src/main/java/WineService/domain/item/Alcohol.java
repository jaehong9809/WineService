package WineService.domain.item;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Alcohol {
    private Long id;
    private String alcoholName;
    private Integer price;
    private Integer quantity;
    public Alcohol(){

    }

    public Alcohol(String alcoholName, Integer price, Integer quantity) {
        this.alcoholName = alcoholName;
        this.price = price;
        this.quantity = quantity;
    }
}
