import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class SpecificationBuilder {

    public static RequestSpecification getSpecification(){
        return new RequestSpecBuilder()
                .setBaseUri("https://api.getpostman.com")
                .addHeader("x-api-key","PMAK-64ba1d423764c47e22768c80-2641793fe15804fc046438735fd4a0fb28")
                .log(LogDetail.ALL).build();

    }
}
