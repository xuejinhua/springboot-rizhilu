package com.demo.result;

import lombok.Getter;
import lombok.Setter;

/**
 * 统一错误码异常
 *
 * Created by bysocket on 14/03/2017.
 */
@Getter @Setter
public class GlobalErrorInfoException extends Exception {

    private ErrorInfoInterface errorInfo;

    public GlobalErrorInfoException (ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }
}
