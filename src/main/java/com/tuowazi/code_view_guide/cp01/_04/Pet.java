package com.tuowazi.code_view_guide.cp01._04;

import lombok.Getter;

/**
 * @author zhangweixiao - 19-3-18
 */
@Getter
public class Pet {

    private String type;

    public Pet(String type) {
        this.type = type;
    }
}
