package org.pdfsam.model.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.sejda.model.pdf.page.PageRangeSelection;
import org.sejda.model.validation.constraint.NoIntersections;

/**
 * Validator for a {@link Intersections} constraint to ensure page ranges in an input {@link PageRangeSelection} do not intersect.
 * 
 * @author Andrea Vacondio
 * 
 */
public class IntersectionsValidator implements ConstraintValidator<NoIntersections, PageRangeSelection> {

    @Override
    public void initialize(NoIntersections constraintAnnotation) {
        // on purpose
    }

    @Override
    public boolean isValid(PageRangeSelection value, ConstraintValidatorContext context) {

        return true;
    }

}