package org.ck.codechallengelib.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Solution
{
	int id();
	String name();
	String description() default "";
	String url();
	
	String category();
	String subCategory() default "";
	
	boolean solved() default true;
}
