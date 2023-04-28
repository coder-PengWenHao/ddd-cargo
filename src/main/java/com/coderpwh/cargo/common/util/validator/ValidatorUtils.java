package com.coderpwh.cargo.common.util.validator;

import com.coderpwh.cargo.common.util.exception.BusinessException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;

/**
 * @author coderpwh
 * @date 2023/4/28 11:17
 */
public class ValidatorUtils {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public ValidatorUtils() {
    }

    public static void validateEntity(Object object, Class<?>... groups) throws BusinessException {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            StringBuilder msg = new StringBuilder();
            Iterator var4 = constraintViolations.iterator();

            while (var4.hasNext()) {
                ConstraintViolation<Object> constraint = (ConstraintViolation) var4.next();
                msg.append(constraint.getMessage()).append("");
            }

            throw new BusinessException(100, msg.toString());
        }
    }

}
