package uz.uzumintegrationexample.domain.uzum.utils;

import uz.uzumintegrationexample.domain.uzum.exception.UzumException;

import java.util.Base64;
import java.util.Objects;

public class UzumUtil {
    public static final String SERVICE_ID = "serviceId";
    private static final String login = "login";
    private static final String password = "password";

    public static void authorize(String token) {
        if (token == null || !token.startsWith("Basis ")) {
            throw new UzumException("Token is required");
        }

        String decoded = new String(Base64.getDecoder().decode(login + ":" + password));

        if (!Objects.equals(decoded, token.substring(7))) {
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
