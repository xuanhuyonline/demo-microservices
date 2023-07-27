package s3.corp.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private String id;
    private String name;
    private int qty;
    private double price;
    private Long userId;
}
