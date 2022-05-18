package acherie.fastjson.entity;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * <p>User: wangjie
 * <p>Date: 1/11/2017
 */
public class Response implements Serializable {

    private static final long serialVersionUID = 1L;

    public static class MapBuilder {

        public <T extends MapBuilder> T buildByMap(Map data) {
            Class<? extends MapBuilder> builderClass = this.getClass();
            Field[] fields = builderClass.getDeclaredFields();

            for (Field field : fields) {
                assignField(field, data);
            }

            return (T) this;
        }

        private void assignField(Field field, Map data) {
            Class<? extends MapBuilder> builderCls = this.getClass();
            Class<?> fieldDeclaringClass = field.getType();
            String fieldName = field.getName();
            String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

            try {
                Method setMethod = builderCls.getDeclaredMethod(methodName, fieldDeclaringClass);
                setMethod.invoke(this, parse(data.get(fieldName), fieldDeclaringClass));
            } catch (NoSuchMethodException e) {
                System.out.println("设置 MapBuilder 的值失败，没有该方法");
            } catch (IllegalAccessException e) {
                System.out.println("设置 MapBuilder 的值失败，权限访问失败");
            } catch (InvocationTargetException e) {
                System.out.println("设置 MapBuilder 的值失败，目标调用失败");
            }
        }

        private Object parse(Object value, Class<?> cls) {
            return null == value || cls == String.class ? null : String.valueOf(value);
        }

    }
}