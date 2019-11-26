package myview;

import com.fasterxml.jackson.annotation.JsonView;
import io.micronaut.core.annotation.Introspected;
import lombok.Data;
import javax.persistence.Entity;

// uncomment either @Entity or @Introspected will break @JsonView

// @Entity
// @Introspected
@Data
public class Role {
    @JsonView(View.Public.class)
    private Long id;

    @JsonView(View.Internal.class)
    private String name;

    @JsonView(View.Admin.class)
    private String desc;

    private String address = "Address";

    public static Role create(){
        Role r = new Role();
        r.setId(1L);
        r.setName("Role");
        r.setDesc("Role Desc");
        return r;
    }
}
