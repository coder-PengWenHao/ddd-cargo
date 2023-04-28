package com.coderpwh.cargo.common.ddd;

/**
 * @author coderpwh
 * @date 2023/4/28 10:35
 */
public class NotSpecification<T> extends AbstractSpecification<T> {
    private Specification<T> spec1;

    public NotSpecification(Specification<T> spec1) {
        this.spec1 = spec1;
    }


    @Override
    public boolean isSatisfiedBy(T t) {
        return !this.spec1.isSatisfiedBy(t);
    }
}
