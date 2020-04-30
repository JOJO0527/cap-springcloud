package cn.kilog.cap.es.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Document(indexName = "item", type = "_doc", shards = 1, replicas = 0)
public class Item {

    @Id
    private String id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;

    @Field(type = FieldType.Keyword)
    private String sell_point;

    @Field(type = FieldType.Long)
    private long price;

    @Field(type = FieldType.Keyword)
    private String image;

    @Field(type = FieldType.Keyword)
    private String category_name;

    @Field(type = FieldType.Keyword)
    private String item_des;

    public Item(String id, String title, String sell_point, long price, String image, String category_name, String item_des) {
        this.id = id;
        this.title = title;
        this.sell_point = sell_point;
        this.price = price;
        this.image = image;
        this.category_name = category_name;
        this.item_des = item_des;
    }

    @JsonIgnore
    public String[] getImages() {
        if (image != null) {
            String[] images = image.split(",");
            return images;
        }
        return null;
    }


}
