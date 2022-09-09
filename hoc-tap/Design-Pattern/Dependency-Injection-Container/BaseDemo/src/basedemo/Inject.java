/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author hoang
 *
 * 
 */

//dùng để nhận biết đâu là trường tham chiếu, đâu là trường dữ liệu nguyên thủy.
//Với trường hợp trường dữ liệu nguyên thủy ta sẽ bỏ qua tìm kiếm giá trị để gán.
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
    
}
