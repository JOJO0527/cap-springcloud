package cn.kilog.cap.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
	private long id;
	private String title;
	private Integer num;
	private long price;
	private String image;
	private String userId;
}
