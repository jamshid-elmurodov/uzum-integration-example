package uz.uzumintegrationexample.domain.uzum.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UzumException extends RuntimeException {
    private final String errorCode;
}
