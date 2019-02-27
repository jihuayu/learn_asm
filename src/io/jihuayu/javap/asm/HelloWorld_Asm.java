package io.jihuayu.javap.asm;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class HelloWorld_Asm implements Opcodes {
    public static  String name = "HelloWorld_Asm";
    public static void main(String[]arg) throws Exception{
        ClassWriter cw = new ClassWriter(0);
        MethodVisitor mv;
        cw.visit(V1_8, ACC_PUBLIC + ACC_SUPER, name, null, "java/lang/Object", null);
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("Hello World");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "([Ljava/lang/String;)V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(100, 1);
            mv.visitEnd();
        }
        cw.visitEnd();
        utils.saveBytecodeToClassFile(name, cw.toByteArray());
    }

}
