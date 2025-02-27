package uz.uzumintegrationexample.domain.uzum.utils;

import uz.uzumintegrationexample.domain.uzum.exception.UzumException;

import java.util.Base64;
import java.util.Objects;

public class UzumUtil {
    public static final String SERVICE_ID = "serviceId";
    private static final String login = "login";
    private static final String password = "password";

    public static void authorize(String token) {
        if (token == null || !token.startsWith("Basic ")) {
            throw new UzumException("Token is required");
        }

        String expectedToken = Base64.getEncoder().encodeToString((login + ":" + password).getBytes());

        String providedToken = token.substring(6);

        if (!Objects.equals(expectedToken, providedToken)) {
            throw new UzumException("Invalid token");
        }
    }

    public static String generatePaymentUrl(Long orderId, Long amount) {
        return String.format(
                "https://www.apelsin.uz/open-service?serviceId=%s&order_id=%s&amount=%s",
                SERVICE_ID,
                orderId,
                amount
        );
    }
}
