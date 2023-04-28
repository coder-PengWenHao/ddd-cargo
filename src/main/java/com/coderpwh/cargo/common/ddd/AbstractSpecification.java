package com.coderpwh.cargo.common.ddd;

/**
 * @author coderpwh
 * @date 2023/4/28 10:30
 */
public abstract class AbstractSpecification<T> implements Specification<T> {

    public AbstractSpecification() {
    }

    @Override
    public abstract boolean isSatisfiedBy(T var1);

    @Override
    public Specification<T> and(Specification<T> specification) {
        return new AndSpecification(this, specification);
    }

    @Override
    public Specification<T> or(Specification<T> specification) {
        return new OrSpecification(this, specification);
    }

    @Override
    public Specification<T> not(Specification<T> specification) {
        return new NotSpecification(specification);
    }
}
