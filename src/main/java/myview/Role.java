package myview;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

@Data
public class Role {
    @JsonView(View.Public.class)
    private Long id;

    @JsonView(View.Internal.class)
    private String name;

    @JsonView(View.Admin.class)
    private String desc;
}
