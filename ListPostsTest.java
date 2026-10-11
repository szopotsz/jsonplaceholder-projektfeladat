package hu.teszteles.posts;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class ListPostsTest {

    private static final String BASE_URL =
            "https://jsonplaceholder.typicode.com";

    /**
     * TC1.1
     * Feltétel: a JSONPlaceholder API elérhető.
     * Lépések: GET /posts kérés küldése.
     * Elvárt eredmény: HTTP 200, nem üres lista,
     * minden bejegyzés tartalmazza az id, title és body mezőket.
     */
    @Test
    void shouldReturnListOfPosts() {
        given()
            .baseUri(BASE_URL)
            .log().all()
        .when()
            .get("/posts")
        .then()
            .log().ifValidationFails()
            .statusCode(200)
            .body("$", not(empty()))
            .body("size()", greaterThan(0))
            .body("id", everyItem(notNullValue()))
            .body("title", everyItem(notNullValue()))
            .body("body", everyItem(notNullValue()));
    }
}
