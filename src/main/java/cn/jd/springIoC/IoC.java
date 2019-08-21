package cn.jd.springIoC;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IoC {

    /**
     * Bean对象容器
     */
    public static final Map beanContainer = new HashMap<String, Object>();


    /**
     * 初始化指定包下的所有@Service注解标记的类
     *
     * @param packageName 初始化包路径
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    /*public static void init(String packageName) throws InstantiationException, IllegalAccessException {
        Reflections f = new Reflections(packageName);
        Set<Class<?>> set = f.getTypesAnnotatedWith(Service.class);
        for (Class<?> c : set) {
            Object bean = c.newInstance();
            Service annotation = c.getAnnotation(Service.class);
            if (c.isAnnotationPresent(Service.class)){
                beanContainer.put(annotation.value(), bean);
            }
        }
    }*/


    /**
     * 初始化指定包下的所有@Service注解标记的类
     *
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static void init() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        //获取基础路径
        String contextPath = IoC.class.getResource("/").getPath();
        //获取当前包绝对路径
        String thisPackageAbsPath = IoC.class.getResource("").getPath();

        File thisPackageFile = new File(thisPackageAbsPath);

        //获取当前包所有file对象

        List<File> files = IoC.getFiles(thisPackageFile);
        for (File file : files) {
            //获取当前文件相对于基础目录的路径
            String referencePath = file.getAbsolutePath().substring(contextPath.length() - 1);
            //获取当前文件相对于基础目录的类路径
            String classPath = referencePath.replace("/", ".").replace("\\", ".");
            if (classPath.endsWith(".class")) {
                String className = classPath.substring(0, classPath.length() - 6);
                Class<?> aClass = Class.forName(className);
                String beanId = "";
                Object newInstance = new Object();

                //如果有service注解
                boolean serviceAnnotationPresent = aClass.isAnnotationPresent(MyService.class);
                if (serviceAnnotationPresent) {
                    MyService service = aClass.getAnnotation(MyService.class);
                    beanId = service.value();
                    if (beanId == null || "".equals(beanId)) {
                        String simpleName = aClass.getSimpleName();
                        String lowerCase = simpleName.substring(0, 1).toLowerCase();
                        String excludFirst = simpleName.substring(1);
                        beanId = lowerCase + excludFirst;
                    }
                    newInstance = aClass.newInstance();
                }

                //如果有Autowired注解
                /*Field[] declaredFields = aClass.getDeclaredFields();
                for (Field declaredField : declaredFields) {
                    boolean autowiredAnnotationPresent = declaredField.isAnnotationPresent(Autowired.class);
                    if (autowiredAnnotationPresent) {
                        String name = declaredField.getName();
                        Class<?> type = declaredField.getType();
                        StudyService value =(StudyService) beanContainer.get(name);

                        declaredField.set(newInstance, value);
                    }
                }*/

                beanContainer.put(beanId, newInstance);
            }
        }
    }

    public static List<File> getFiles(File fileObj) {
        List<File> fileList = new ArrayList<>();
        //获取当前包所有file对象
        File[] files = fileObj.listFiles();
        for (File file : files) {
            //如果当前file是文件
            if (file.isFile()) {
                fileList.add(file);
            } else {
                List<File> list = getFiles(file);
                fileList.addAll(list);
            }
        }
        return fileList;
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        init();
        Object o = beanContainer.get("studyService");
        System.out.println(o);
    }

}
