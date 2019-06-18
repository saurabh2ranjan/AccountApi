package com.anz.wholesale.account.IT;

import com.anz.wholesale.account.AccountApplication;
import io.restassured.http.ContentType;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class AccountControllerIntegrationTest {

    @LocalServerPort
    private Integer port;

    @Test
    public void findAccount_shouldReturnEmptyArray_forNotFoundAccountForUser() {

        given()
                .port(port)
                .when()
                .get("/account/user0")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .log().all();
    }

    @Test
    public void findAccount_shouldReturnAccountList_forAccountsForUser() {

        String responseBody = given()
                .port(port)
                .when()
                .get("/account/user1")
                .then().assertThat()
                .statusCode(HttpStatus.OK.value())
                .contentType(ContentType.JSON)
                .extract().body().asString();

    }

    @Test
    public void findTransaction_shouldReturnEmptyList_forNotFoundTransactionForAccount() {

        given()
                .port(port)
                .when()
                .get("/account/11111/transactions")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .log().all();
    }

    @Test
    public void findTransaction_shouldReturnAccountList_forTransactionsForAccount() {

        String responseBody = given()
                .port(port)
                .when()
                .get("/account/100001/transactions")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .contentType(ContentType.JSON)
                .extract().body().asString();

    }
}
