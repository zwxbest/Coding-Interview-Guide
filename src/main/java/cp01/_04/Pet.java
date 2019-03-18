package cp01._04;

import lombok.Getter;
import lombok.Setter;

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
