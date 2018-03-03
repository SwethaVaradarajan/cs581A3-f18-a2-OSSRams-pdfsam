package org.pdfsam.util;

import static org.junit.Assert.*;

import javax.validation.Constraint;
import org.junit.Test;
import org.pdfsam.model.validators.IntersectionsValidator;
import org.pdfsam.util.Util;
import org.sejda.model.input.PdfMergeInput;
import org.sejda.model.validation.validator.NoIntersectionsValidator;

public class UtilTest {

	@Test
	public void setIntersectionValidatorForPdfMergeInputTest1() {
		Util.setIntersectionsValidatorPdfMergeInput(NoIntersectionsValidator.class);
		assertTrue(PdfMergeInput.class.getAnnotations()[0].annotationType().getAnnotation(Constraint.class).validatedBy()[0]
				== NoIntersectionsValidator.class);
		
	}
	
	@Test
	public void setIntersectionValidatorForPdfMergeInputTest2() {
		Util.setIntersectionsValidatorPdfMergeInput(IntersectionsValidator.class);
		assertTrue(PdfMergeInput.class.getAnnotations()[0].annotationType().getAnnotation(Constraint.class).validatedBy()[0]
				== IntersectionsValidator.class);
	}

}
