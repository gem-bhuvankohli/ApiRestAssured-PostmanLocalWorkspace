import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestUtils {

    public static Response getAPI(String endpoint){
        return given(SpecificationBuilder.getSpecification())
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response postAPI(String endpoint,Object payload){
        return given(SpecificationBuilder.getSpecification())
                .body(payload)
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    public static Response putAPI(String endpoint,String id,Object payload){
        return given(SpecificationBuilder.getSpecification())
                .pathParam("id",id)
                .body(payload)
                .put(endpoint+"/{id}")
                .then()
                .extract()
                .response();
    }

    public static Response deleteAPI(String endpoint,String id){
        return given(SpecificationBuilder.getSpecification())
                .pathParam("id",id)
                .delete(endpoint+"/{id}")
                .then()
                .extract()
                .response();
    }

}

