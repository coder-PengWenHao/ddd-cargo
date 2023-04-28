package com.coderpwh.cargo.common.ddd;

import java.io.Serializable;

/**
 * @author coderpwh
 * @date 2023/4/28 10:38
 */
public interface Aggregate<T> extends Serializable {

    boolean sameIdentityAs(T var1);

}
