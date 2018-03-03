package org.pdfsam.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;

import org.pdfsam.model.validators.IntersectionsValidator;
import org.sejda.model.input.PdfMergeInput;
import org.sejda.model.validation.constraint.NoIntersections;

public class Util {
 
	public static void setIntersectionsValidatorPdfMergeInput(Class intersectionValidationClass){
		final Constraint oldAnnotation = (Constraint)  PdfMergeInput.class.getAnnotations()[0].annotationType().getAnnotation(Constraint.class);

		Annotation newAnnotation = new Constraint() {

			@Override
			public Class<? extends ConstraintValidator<?, ?>>[] validatedBy() {
				Class<? extends ConstraintValidator<?, ?>>[] validators = new Class[1];
				validators[0] = intersectionValidationClass; 
				return validators;
			}

			@Override
			public Class<? extends Annotation> annotationType() {
				return oldAnnotation.annotationType();
			}
		};

		Field field = null;
		try {

			final Method method = Class.class.getDeclaredMethod("getDeclaredAnnotationMap", null);
			method.setAccessible(true);
			final Map<Class<? extends Annotation>, Annotation> annotations = (Map<Class<? extends Annotation>, Annotation>) method.invoke(NoIntersections.class, null);   
			annotations.put(javax.validation.Constraint.class, newAnnotation);

		} catch ( SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Constraint mAnnotation = (Constraint)  PdfMergeInput.class.getAnnotations()[0].annotationType().getAnnotation(Constraint.class);
	}
}
