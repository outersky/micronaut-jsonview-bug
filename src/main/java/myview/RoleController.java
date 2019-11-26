package myview;

import com.fasterxml.jackson.annotation.JsonView;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/roles")
public class RoleController {

    @JsonView(View.Public.class)
    @Get()
    Role findAll(){
        return Role.create();
    }

    @JsonView(View.Internal.class)
    @Get("/internal")
    Role findInternal(){
        return Role.create();
    }

    @JsonView(View.Admin.class)
    @Get("/admin")
    Role findAdmin(){
        return Role.create();
    }



}
