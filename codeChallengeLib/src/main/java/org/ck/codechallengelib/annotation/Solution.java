package org.ck.codechallengelib.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@Repeatable(value = Solutions.class)
public @interface Solution {
  int id();

  String name();

  String description() default "";

  String url();

  String category();

  String subCategory() default "";

  boolean solved() default true;
}
