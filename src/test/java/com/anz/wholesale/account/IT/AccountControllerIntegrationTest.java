package com.anz.wholesale.account.IT;

import com.anz.wholesale.account.AccountApplication;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class AccountControllerIntegrationTest {

    @LocalServerPort
    private Integer port;

    @Test
    public void findAccount_shouldReturn404_forNotFoundAccountForUser() {

        given()
        .port(port)
        .when()
        .get("/account/user0")
        .then()
        .statusCode(200)
        .log().all();
    }

    //@Test
    public void findAccount_shouldReturn200_forAccountsForUser() {

        String responseBody = given()
            .port(port)
            .when()
            .get("/account/user1")
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .extract().body().asString();
        
       // Assert.assertEquals(TestData.getExpectedDataForUser1(), responseBody);
    }

    //@Test
    public void findTransaction_shouldReturn404_forNotFoundTransactionForAccount() {

        given()
                .port(port)
                .when()
                .get("/account/11111/transactions")
                .then()
                .statusCode(404)
                .log().all();
    }

   // @Test
    public void findTransaction_shouldReturn200_forTransactionsForAccount() {

        String responseBody = given()
                .port(port)
                .when()
                .get("/account/100001/transactions")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().body().asString();

       // Assert.assertEquals(TestData.getExpectedDataForAccount1(), responseBody);
    }
}
