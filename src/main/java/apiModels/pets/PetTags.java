package apiModels.pets;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetTags {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

}
