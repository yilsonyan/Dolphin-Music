package cn.jd.javadoc;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.RootDoc;

/**
 * JavaDoc的使用方法
 */
public class JavaDoc {

    //RootDoc 对象引用自jdk1.8.0_192\lib\tools.jar
    private static RootDoc rootDoc;

    public static class Doclet {
        public static boolean start(RootDoc rootDoc) {
            JavaDoc.rootDoc = rootDoc;
            return true;
        }
    }



    /**
     * 显示DocRoot中的基本信息
     */
    public static void show() {
        ClassDoc[] classes = rootDoc.classes();
        for (ClassDoc classDoc : classes) {
            System.out.println(classDoc.name() +
                    "类的注释:" + classDoc.commentText());

            MethodDoc[] methodDocs = classDoc.methods();
            for (MethodDoc methodDoc : methodDocs) {
                // 打印出方法上的注释
                System.out.println(
                        "类"
                        + classDoc.name() + ","
                        + methodDoc.name() +
                        "方法注释:"
                        + methodDoc.commentText());
            }
        }
    }



    public static void main(String[] args) {
        com.sun.tools.javadoc.Main.execute(
                new String[]{"-doclet",
                Doclet.class.getName(),
                "-encoding", "utf-8", "-classpath",
                "C:\\Users\\Administrator\\Desktop\\Resume_Point\\target\\classes",
                "C:\\Users\\Administrator\\Desktop\\Resume_Point\\src\\main\\java\\cn.jd.javadoc\\GetClassNoteUtil.java"});
        show();


    }



}