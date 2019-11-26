package myview;

import com.fasterxml.jackson.annotation.JsonView;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/roles")
public class RoleController {

    @JsonView(View.Public.class)
    @Get()
    Role findAll(){
        return assetRole();
    }

    @JsonView(View.Internal.class)
    @Get("/internal")
    Role findInternal(){
        return assetRole();
    }

    @JsonView(View.Admin.class)
    @Get("/admin")
    Role findAdmin(){
        return assetRole();
    }

    private Role assetRole(){
        Role r = new Role();
        r.setId(1L);
        r.setName("Role");
        r.setDesc("Role Desc");
        return r;
    }

}
