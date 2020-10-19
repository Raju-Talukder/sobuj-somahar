//package com.sobuj.validators;
//
//import javax.validation.ConstraintValidatorContext;
//
//public class RepeatPasswordValidator {
//    @Override
//    public void initialize(ValidRepeatPassword constraintAnnotation) {
//    }
//
//    @Override
//    public boolean isValid(Object value, ConstraintValidatorContext context) {
//        if(value instanceof AccountCreateDto) {
//            AccountCreateDto dto = (AccountCreateDto) value;
//            if (dto.getPassword().isEmpty()) {
//                context.buildConstraintViolationWithTemplate( "Password not be empty" )
//                        .addPropertyNode( "repeatPassword" )
//                        .addConstraintViolation();
//                return false;
//            }
//            if (!dto.getPassword().equals(dto.getRepeatPassword())) {
//                context.buildConstraintViolationWithTemplate( "Passwords don't match" )
//                        .addPropertyNode( "repeatPassword" )
//                        .addConstraintViolation();
//                return false;
//            }
//        }
//        return true;
//    }
//}
