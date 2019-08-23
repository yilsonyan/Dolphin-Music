#include <stdio.h>
/* 导入 生成的头文件 */
#include "HelloWorld.h"

/* 此处的方法命名要和头文件方法名相同（规则：Java语言，根包下的 HelloWorld文件中 cMethod方法） */
JNIEXPORT void JNICALL Java_HelloWorld_cMethod(JNIEnv *env, jobject c1) {
    printf("Hello World Native!!\n");
}