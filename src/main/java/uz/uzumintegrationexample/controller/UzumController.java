package uz.uzumintegrationexample.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.uzumintegrationexample.domain.uzum.dto.request.BaseRequest;
import uz.uzumintegrationexample.domain.uzum.dto.request.CheckRequest;
import uz.uzumintegrationexample.domain.uzum.dto.request.CreateRequest;
import uz.uzumintegrationexample.domain.uzum.dto.response.*;
import uz.uzumintegrationexample.domain.uzum.enums.UzumStatus;
import uz.uzumintegrationexample.domain.uzum.exception.UzumException;
import uz.uzumintegrationexample.domain.uzum.model.ErrorResponse;
import uz.uzumintegrationexample.domain.uzum.utils.UzumUtil;
import uz.uzumintegrationexample.service.UzumService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/uzum")
public class UzumController {
    private final UzumService uzumService;

    @PostMapping("/check")
    public CheckResponse check(@RequestBody CheckRequest request, HttpServletRequest servletRequest){
        UzumUtil.authorize(servletRequest.getHeader("Authorization"));

        return uzumService.check(request);
    }

    @PostMapping("/create")
    public CreateResponse create(@RequestBody CreateRequest request, HttpServletRequest servletRequest){
        UzumUtil.authorize(servletRequest.getHeader("Authorization"));

        return uzumService.create(request);
    }

    @PostMapping("/reverse")
    public ReverseResponse reverse(@RequestBody BaseRequest request, HttpServletRequest servletRequest){
        UzumUtil.authorize(servletRequest.getHeader("Authorization"));

        return uzumService.reverse(request);
    }

    @PostMapping("/confirm")
    public ConfirmResponse confirm(@RequestBody BaseRequest request, HttpServletRequest servletRequest){
        UzumUtil.authorize(servletRequest.getHeader("Authorization"));

        return uzumService.confirm(request);
    }

    @PostMapping("/status")
    public StatusResponse status(@RequestBody BaseRequest request, HttpServletRequest servletRequest){
        UzumUtil.authorize(servletRequest.getHeader("Authorization"));

        return uzumService.status(request);
    }

    @ExceptionHandler(UzumException.class)
    public ResponseEntity<ErrorResponse> handleUzumException(UzumException e){
        return ResponseEntity.badRequest().body(new ErrorResponse(UzumUtil.SERVICE_ID, System.currentTimeMillis() + "", UzumStatus.FAILED, e.getErrorCode()));
    }
}
