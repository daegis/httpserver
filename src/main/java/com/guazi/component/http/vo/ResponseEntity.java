package com.guazi.component.http.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Using IntelliJ IDEA.
 *
 * @author XIANYINGDA at 2018-12-29 13:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEntity<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public static <T> ResponseEntity<T> success(T data) {
        return new ResponseEntity<T>(200, "", data);
    }

    public static <T> ResponseEntity<T> fail(Integer code, String msg) {
        return new ResponseEntity<>(code, msg, null);
    }
}
