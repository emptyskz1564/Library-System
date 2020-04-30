package com.liu.library.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class user {
    private Integer userId;
    private String userName;
    private String passWord;
    private String userPic;
}
