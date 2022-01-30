package cn.element.proxy.generator;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 用来生成源码的工具类
 * 手写动态代理实战
 */
public class IProxy {

    public static final String ln = "\r\n";

    private static final Map<Class<?>, Class<?>> map = new HashMap<>();

    static {
        map.put(int.class, Integer.class);
    }

    public static Object newProxyInstance(IClassLoader classLoader, Class<?>[] interfaces, MyInvocationHandler h) {
        try {
            // 1、动态生成源代码.java文件
            String src = generateSource(interfaces);
            // 2、Java文件输出磁盘
            String filePath = IProxy.class.getResource("").getPath();

            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();

            // 3、把生成的.java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manage = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> iterable = manage.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manage, null, null, null, iterable);
            task.call();
            manage.close();

            //4、编译生成的.class文件加载到JVM中来
            Class<?> proxyClass = classLoader.findClass("$Proxy0");
            Constructor<?> c = proxyClass.getConstructor(MyInvocationHandler.class);
            f.delete();

            //5、返回字节码重组以后的新的代理对象
            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String generateSource(Class<?>[] interfaces) {
        StringBuilder sb = new StringBuilder();

        sb.append(IProxy.class.getPackage())
          .append(";")
          .append(ln)
          .append("import ")
          .append(interfaces[0].getName())
          .append(";")
          .append(ln)
          .append("import java.lang.reflect.*;" + ln)
          .append("public class $Proxy0 implements ")
          .append(interfaces[0].getName())
          .append("{")
          .append(ln)
          .append("MyInvocationHandler h;" + ln)
          .append("public $Proxy0(MyInvocationHandler h) { " + ln)
          .append("this.h = h;")
          .append("}" + ln);

        for (Method method : interfaces[0].getMethods()) {
            Class<?>[] classes = method.getParameterTypes();

            StringBuilder paramNames = new StringBuilder();
            StringBuilder paramValues = new StringBuilder();
            StringBuilder paramClasses = new StringBuilder();

            for (int i = 0; i < classes.length; i++) {
                Class<?> clazz = classes[i];

                String type = clazz.getName();
                String paramName = toLowerFirstCase(clazz.getSimpleName());

                paramNames.append(type)
                          .append(" ")
                          .append(paramName);
                paramValues.append(paramName);
                paramClasses.append(clazz.getName())
                            .append(".class");

                if (i > 0 && i < classes.length - 1) {
                    paramNames.append(",");
                    paramClasses.append(",");
                    paramValues.append(",");
                }
            }

            sb.append("public ")
              .append(method.getReturnType().getName())
              .append(" ")
              .append(method.getName())
              .append("(")
              .append(paramNames.toString())
              .append(") {")
              .append(ln)
              .append("try {" + ln)
              .append("Method m = ")
              .append(interfaces[0].getName())
              .append(".class.getMethod(\"")
              .append(method.getName())
              .append("\",new Class[]{")
              .append(paramClasses.toString())
              .append("});")
              .append(ln)
              .append(hasReturnedValue(method.getReturnType()) ? "return " : "")
              .append(getCaseCode("this.h.invoke(this,m,new Object[]{" + paramValues + "})", method.getReturnType()))
              .append(";")
              .append(ln)
              .append("} catch (Error _ex) { }")
              .append("catch (Throwable e) {" + ln)
              .append("throw new UndeclaredThrowableException(e);" + ln)
              .append("}")
              .append(getReturnEmptyCode(method.getReturnType()))
              .append("}");
        }

        sb.append("}" + ln);
        return sb.toString();
    }

    private static String getReturnEmptyCode(Class<?> returnClass) {
        if (map.containsKey(returnClass)) {
            return "return 0;";
        } else if (returnClass == void.class) {
            return "";
        } else {
            return "return null;";
        }
    }

    private static String getCaseCode(String code, Class<?> returnClass) {
        if (map.containsKey(returnClass)) {
            return "((" + map.get(returnClass).getName() + ")" + code + ")." + returnClass.getSimpleName() + "Value()";
        }
        return code;
    }

    private static boolean hasReturnedValue(Class<?> clazz) {
        return clazz != void.class;
    }

    private static String toLowerFirstCase(String src) {
        char[] chars = src.toCharArray();
        chars[0] += 32;

        return String.valueOf(chars);
    }


}
