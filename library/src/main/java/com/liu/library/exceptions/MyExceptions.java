package com.liu.library.exceptions;


import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MyExceptions extends Exception{
    private int code;
    private String message;
}
