package com.coderpwh.cargo.common.ddd;

import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/4/28 10:36
 */
public interface ValueObject<T> extends Serializable {

    boolean sameValueAs(T var1);

}
