package apiModels.pets;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PetTags {

    @Expose
    private int id;
    @SerializedName("name")
    private String name;

}
