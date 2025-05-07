package com.intelligent.rest;

import com.intelligent.basic.constant.ResultCodeConstant;
import com.intelligent.basic.exception.ServiceException;
import com.intelligent.basic.result.ResponseMessage;
import com.intelligent.basic.result.Result;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//@RestControllerAdvice
public class ExceptionHandle {

    private static final Logger log = LoggerFactory.getLogger(ExceptionHandle.class);

    public ExceptionHandle() {
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseMessage<Object> methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        String join = "\r\n" + StringUtils.join(new Object[]{bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage), "\r\n"});
        return Result.fail(1307);
    }

    @ExceptionHandler({BindException.class})
    public ResponseMessage<Object> handleBindException(HttpServletRequest request, BindException exception) {
        List<FieldError> allErrors = exception.getFieldErrors();
        String join = "\r\n" + StringUtils.join(new Object[]{allErrors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage), "\r\n"});
        return Result.fail(1307);
    }

    @ExceptionHandler({ServiceException.class})
    public ResponseMessage<Object> serviceException(ServiceException exception) {
        log.error(exception.getCode() + ": " + exception.getMessage(), exception);
        return 500 == exception.getCode() ? Result.fail(exception.getCode(), exception.getMessage()) : Result.fail(exception.getCode());
    }

    @ExceptionHandler({Exception.class})
    public ResponseMessage<Object> exception(Exception exception) {
        log.error(exception.getMessage(), exception);
        StringBuilder sb = new StringBuilder();
        sb.append(exception.getClass().getName()).append(" : ");
        sb.append(exception.getMessage());
        return Result.fail(ResultCodeConstant.FAIL);
    }
}
