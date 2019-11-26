package myview;

import com.fasterxml.jackson.annotation.JsonView;
import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Data
// 加了会导致 Controller 里面的 @JsonView失效
// @Introspected
public class Role {
    @JsonView(View.Public.class)
    private Long id;

    @JsonView(View.Internal.class)
    private String name;

    @JsonView(View.Admin.class)
    private String desc;
}
