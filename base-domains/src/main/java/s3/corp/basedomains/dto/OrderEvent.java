package s3.corp.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEvent {
    private String message;
    private String status;
    private OrderDto order;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("  \"message\": \"" + message + "\",\n");
        sb.append("  \"status\": \"" + status + "\",\n");
        sb.append("  \"order\": {\n");
        sb.append("    \"id\": \"" + order.getId() + "\",\n");
        sb.append("    \"name\": \"" + order.getName() + "\",\n");
        sb.append("    \"qty\": " + order.getQty() + ",\n");
        sb.append("    \"price\": " + order.getPrice() + ",\n");
        sb.append("    \"userId\": " + order.getUserId() + "\n");
        sb.append("  }\n");
        sb.append("}");

        return sb.toString();
    }
}
