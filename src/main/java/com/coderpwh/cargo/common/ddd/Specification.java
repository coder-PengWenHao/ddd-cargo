package com.coderpwh.cargo.common.ddd;

/**
 * @author coderpwh
 * @date 2023/4/28 10:31
 */
public interface Specification<T> {

    boolean isSatisfiedBy(T var1);

    Specification<T> and(Specification<T> var1);

    Specification<T> or(Specification<T> var1);

    Specification<T> not(Specification<T> var1);
}
