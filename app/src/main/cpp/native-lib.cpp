#include <jni.h>
#include <string>

/**
 * https://blog.csdn.net/weiwangchao_/article/details/48163163
 */

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_testandroidjni_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jint JNICALL
Java_com_example_testandroidjni_MainActivity_addTwoNumbers(
        JNIEnv* env,
        jobject /* this */,
        jint num1,
        jint num2) {
    return num1+num2;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_example_testandroidjni_MainActivity_testLength(
        JNIEnv* env,
        jobject /* this */,
        jstring text) {
    char* str = (char*) env->GetStringUTFChars(text,JNI_FALSE);
    if (str != nullptr) {
        size_t len = std::strlen(str);
        env->ReleaseStringUTFChars(text, str);
        return len;
    }
    return 0;
}