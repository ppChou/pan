package com.lhx.util;

import com.lhx.model.UserAnno;

import java.lang.reflect.Method;


/**
 * UserFactory.java
 *
 */
public class UserFactory
{
    public static UserAnno create()
    {
        UserAnno user = new UserAnno();

        // 获取User类中所有的方法（getDeclaredMethods也行）
        Method[] methods = UserAnno.class.getMethods();

        try
        {
            for (Method method : methods)
            {
                // 如果此方法有注解，就把注解里面的数据赋值到user对象
                if (method.isAnnotationPresent(Init.class))
                {
                    Init init = method.getAnnotation(Init.class);
                    method.invoke(user, init.value());
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

        return user;
    }
}