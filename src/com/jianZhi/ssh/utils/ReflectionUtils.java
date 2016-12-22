package com.jianZhi.ssh.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectionUtils {

	@SuppressWarnings({"rawtypes" })
	public static Class getSuperClassGenricType(Class clazz, int index){
		Type genType = clazz.getGenericSuperclass();
		
		if(!(genType instanceof ParameterizedType)){
			return Object.class;
		}
		
		Type [] params = ((ParameterizedType)genType).getActualTypeArguments();
		
		if(index >= params.length || index < 0){
			return Object.class;
		}
		
		if(!(params[index] instanceof Class)){
			return Object.class;
		}
		
		return (Class) params[index];
	}
	
	@SuppressWarnings("unchecked")
	public static<T> Class<T> getSuperGenericType(@SuppressWarnings("rawtypes") Class clazz){
		return getSuperClassGenricType(clazz, 0);
	}
	
	public static Method getDeclaredMethod(Object object, String methodName, Class<?>[] parameterTypes){
		
		for(Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()){
			try {
				//superClass.getMethod(methodName, parameterTypes);
				return superClass.getDeclaredMethod(methodName, parameterTypes);
			} catch (NoSuchMethodException e) {
				//Method ���ڵ�ǰ�ඨ��, ��������ת��
			}
			//..
		}
		
		return null;
	}
	
	public static void makeAccessible(Field field){
		if(!Modifier.isPublic(field.getModifiers())){
			field.setAccessible(true);
		}
	}
	
	public static Field getDeclaredField(Object object, String filedName){
		
		for(Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()){
			try {
				return superClass.getDeclaredField(filedName);
			} catch (NoSuchFieldException e) {
				//Field ���ڵ�ǰ�ඨ��, ��������ת��
			}
		}
		return null;
	}
	
	public static Object invokeMethod(Object object, String methodName, Class<?> [] parameterTypes,
			Object [] parameters) throws InvocationTargetException{
		
		Method method = getDeclaredMethod(object, methodName, parameterTypes);
		
		if(method == null){
			throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + object + "]");
		}
		
		method.setAccessible(true);
		
		try {
			return method.invoke(object, parameters);
		} catch(IllegalAccessException e) {
			System.out.println("�������׳����쳣");
		} 
		
		return null;
	}
	
	public static void setFieldValue(Object object, String fieldName, Object value){
		Field field = getDeclaredField(object, fieldName);
		
		if (field == null)
			throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");
		
		makeAccessible(field);
		
		try {
			field.set(object, value);
		} catch (IllegalAccessException e) {
			System.out.println("�������׳����쳣");
		}
	}
	
	public static Object getFieldValue(Object object, String fieldName){
		Field field = getDeclaredField(object, fieldName);
		
		if (field == null)
			throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + object + "]");
		
		makeAccessible(field);
		
		Object result = null;
		
		try {
			result = field.get(object);
		} catch (IllegalAccessException e) {
			System.out.println("�������׳����쳣");
		}
		
		return result;
	}
}
