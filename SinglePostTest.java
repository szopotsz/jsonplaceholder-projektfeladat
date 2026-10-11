package hu.teszteles.posts;

import org.junit.jupiter.api.Test;
import static
io.restassured.RestAssured.given;
import static
org.hamcrest.Matchers.equalTo;
import static
org.hamcrest.Matchers.anyOf;

class SinlgePostTest {
	private static final String BASE_URL=
			"https://jsonplaceholder.typicode.com";
	/**
     * TC2.1
     * Feltétel: az 1-es azonosítójú bejegyzés létezik.
     * Lépések: GET /posts/1 kérés küldése.
     * Elvárt eredmény: HTTP 200 és id = 1.
     */
    @Test
    void shouldReturnPostWithIdOne() {
        given()
            .baseUri(BASE_URL)
            .log().all()
        .when()
            .get("/posts/1")
        .then()
            .log().ifValidationFails()
            .statusCode(200)
            .body("id", equalTo(1));
    }

    /**
     * TC2.2
     * Feltétel: a 9999-es azonosítójú bejegyzés nem létezik.
     * Lépések: GET /posts/9999 kérés küldése.
     * Elvárt eredmény: HTTP 404 és üres válasz.
     */
    @Test
    void shouldReturn404ForNonexistentPost() {
        given()
            .baseUri(BASE_URL)
            .log().all()
        .when()
            .get("/posts/9999")
        .then()
            .log().ifValidationFails()
            .statusCode(404)
            .body(org.hamcrest.Matchers.anyOf(
            	    org.hamcrest.Matchers.equalTo(""),
            	    org.hamcrest.Matchers.equalTo("{}")
            	));
    }
}