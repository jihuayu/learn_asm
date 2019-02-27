package io.jihuayu.javap.asm;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class utils {
     static void saveBytecodeToClassFile(String fileName, byte[] byteCode) throws IOException {
        final String classFile = "asm/"+fileName+".class";
        OutputStream os = new FileOutputStream(classFile);
        os.write(byteCode);
        os.close();
    }
}
