package com.liu.library.pojo;


import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class books {
    private Integer bookId;
    private String bookName;
    private String bookType;
    private Float bookPrice;
    private Integer bookCount;
}
