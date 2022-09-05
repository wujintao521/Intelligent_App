package com.intelligent.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class PersonRequest {

    /**
     * 姓名
     * */
    private String name;
}
