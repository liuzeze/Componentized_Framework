package gctraveltools.jsj.com.cn.coremodellib.newmvp.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * -----------作者----------日期----------变更内容-----
 * -          刘泽      2018-06-11       创建class
 */
@Qualifier
@Documented
@Retention(RUNTIME)

public @interface InterceptorsScope {
    String value() default "";
}
