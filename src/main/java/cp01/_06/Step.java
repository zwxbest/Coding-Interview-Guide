package cp01._06;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangweixiao - 19-3-19
 */
@Getter
@Setter
@AllArgsConstructor
public class Step {

    /**
     * 要移动的塔的序号
     */
    private int num;
    private String from;
    private String to;

}
