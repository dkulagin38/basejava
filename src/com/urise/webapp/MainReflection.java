package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        System.out.println(r);

        // TODO: invoke r.toString via reflection
        // source: https://javadevblog.com/polnoe-rukovodstvo-po-java-reflection-api-refleksiya-na-primerah.html
        String sample = r.toString();
        Class clazz = r.getClass();
        Method methods[] = r.getClass().getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            if (method.getName() == "toString") {
                // An error is here: I don't know which correct parameters I have to use
                Object invoke = method.invoke(null);
                break;
            }
        }

//        Class cls = r.getClass();
//        // How can I know about parametersTypes?
//        Method meth = cls.getMethod("toString", null);
//        System.out.println("++");
//        Object retobj = meth.invoke();
//
//        Class clazz = r.getClass();
//        Method method = clazz.getDeclaredMethod("toString", String.class);
//        System.out.println("++" + method.getName());
    }
}
