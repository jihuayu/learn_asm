package io.jihuayu.javap.asm;

class AsmLoader extends ClassLoader {
    static Class<?> run(String name,byte[] code){
        AsmLoader loader = new AsmLoader();
        return loader.defineClass(name, code, 0, code.length);

    }
}
