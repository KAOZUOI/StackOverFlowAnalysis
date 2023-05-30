@Retention(RetentionPolicy.RUNTIME)@Constraint(validatedBy = CountryValidator.class)public @interface ValidCountry {    String message() default &quot;Invalid country&quot;;    String language() default &quot;&quot;;    Class<?>[] groups() default {};    Class<? extends Payload>[] payload() default {};}public class CountryValidator implements ConstraintValidator<ValidCountry, String> {      @Override    public void initialize(ValidCountry constraintAnnotation) {        ConstraintValidator.super.initialize(constraintAnnotation);    }    @Override    public boolean isValid(String inputCountry, ConstraintValidatorContext constraintValidatorContext) {        //validation logic    }}