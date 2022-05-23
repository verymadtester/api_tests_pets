package apiModels.pets;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pet {

    @SerializedName("id")
    private int id;
    @SerializedName("category.id")
    private int categoryId;
    @SerializedName("category.name")
    private String categoryName;
    @SerializedName("name")
    private String name;
    @SerializedName("photoUrls")
    private List<String> photoUrls;
    @SerializedName("tags")
    private Object tags;
    @SerializedName("status")
    private String status;
}
