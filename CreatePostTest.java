package hu.teszteles.posts;

import org.junit.jupiter.api.Test;
import static
io.restassured.RestAssured.given;
import static
org.hamcrest.Matchers.notNullValue;
import static
org.hamcrest.Matchers.equalTo;

class CreatePostTest {
	private static final String BASE_URL= "https://jsonplaceholder.typicode.com";
	
	/**
	 * TC3.1
	 * feltétel: a jsonplaceholder API elérheto
	 * Lépések: post/posts kérés kuldese JSON-adatokkal.
	 */
	@Test
	void shouldCreatePost() {
		String requestBody = "{\"title\":\"projektfeladat\","
		        + "\"body\":\"api hazivizsga\","
		        + "\"userId\":1}";
        given()
            .baseUri(BASE_URL)
            .contentType("application/json")
            .body(requestBody)
            .log().all()
        .when()
            .post("/posts")
        .then()
            .log().ifValidationFails()
            .statusCode(201)
            .body("id", notNullValue())
            .body("title", equalTo("projektfeladat"))
            .body("body", equalTo("api hazivizsga"))
            .body("userId", equalTo(1));
				
	}
}