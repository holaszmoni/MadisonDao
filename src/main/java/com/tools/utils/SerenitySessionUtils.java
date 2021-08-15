package com.tools.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import net.serenitybdd.core.Serenity;

import org.apache.commons.beanutils.PropertyUtils;

public class SerenitySessionUtils {

    @SuppressWarnings("unchecked")
    public static <T> T getFromSession(String key) {
        return (T)Serenity.getCurrentSession().get(key);
    }

    public static void putOnSession(String key, Object object) {
        Serenity.getCurrentSession().put(key, object);
    }

    public static void removeFromSession(String key) {
        Serenity.getCurrentSession().remove(key);
    }

    @SuppressWarnings("unchecked")
    public static void saveObjectInTheListInSerenitySession(String key, Object obj) {
        if (!Serenity.getCurrentSession().containsKey(key)) {
            Serenity.getCurrentSession().put(key, new ArrayList<>());
        }
        ((List<Object>)Serenity.getCurrentSession().get(key)).add(obj);
    }

    public static Object getObjectByMatchingElement(List<Object> list, String matchElement, String matchValue)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        for (Object obj : list) {
            Object value = PropertyUtils.getProperty(obj, matchElement);
            if (((String)value).contentEquals(matchValue)) {
                return obj;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static void saveObjectInSerenitySessionList(String key, Object obj) {
        if (!Serenity.getCurrentSession().containsKey(key)) {
            Serenity.getCurrentSession().put(key, new ArrayList<>());
        }
        ((List<Object>)Serenity.getCurrentSession().get(key)).add(obj);
    }

    public static void replaceObjectInSerenitySessionList(String key, Object updatedObject, String matchElement, String matchValue)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        @SuppressWarnings("unchecked")
        List<Object> listOfObjects = (List<Object>)Serenity.getCurrentSession().get(key);
        Object oldObject = getObjectByMatchingElement(listOfObjects, matchElement, matchValue);
        listOfObjects.set(listOfObjects.indexOf(oldObject), updatedObject);
    }

    @SuppressWarnings("unchecked")
    public static void removeObjectFromSerenitySessionList(String key, Object obj) {
        ((List<Object>)Serenity.getCurrentSession().get(key)).remove(obj);
    }
}
