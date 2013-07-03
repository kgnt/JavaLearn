package com.taobao.ashu.compile;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassReader;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;

public class CompilerTest {
	public static void main(String[] args) throws Exception {
		String source = "public class Main { public static void main(String[] args) {System.out.println(\"Hello World!\");} }";
		compileJava(source);
		
//		calculate("10 * 102");
	}

	private static boolean compileJava(String source) throws URISyntaxException {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(
				null, null, null);
		StringSourceJavaObject sourceObject = new CompilerTest.StringSourceJavaObject(
				"Main", source);
		Iterable<? extends JavaFileObject> fileObjects = Arrays
				.asList(sourceObject);
		CompilationTask task = compiler.getTask(null, fileManager, null, null,
				null, fileObjects);
		boolean result = task.call();
		if (result) {
			System.out.println(" 编译成功！");
			return true;
		}
		return false;
	}

	static class StringSourceJavaObject extends SimpleJavaFileObject {
		private String content = null;

		public StringSourceJavaObject(String name, String content)
				throws URISyntaxException {
			super(URI.create("string:///" + name.replace('.', '/')
					+ Kind.SOURCE.extension), Kind.SOURCE);
			this.content = content;
		}

		public CharSequence getCharContent(boolean ignoreEncodingErrors)
				throws IOException {
			return content;
		}
	}

	private static double calculate(String expr) throws CalculationException, URISyntaxException {
		String className = "CalculatorMain";
		String methodName = "calculate";
		String source = "class " + className
				+ " { public static double " + methodName + "() { return "
				+ expr + "; } }";
		if (compileJava(source)) {
//			ClassLoader loader = Calculator.class.getClassLoader();
			ClassLoader loader = ClassLoader.getSystemClassLoader();
			try {
				Class<?> clazz = loader.loadClass(className);
				Method method = clazz.getMethod(methodName, new Class<?>[] {});
				Object value = method.invoke(null, new Object[] {});
				return (Double) value;
			} catch (Exception e) {
				throw new CalculationException("内部错误。");
			}
		} else {
			throw new CalculationException("错误的表达式。");
		}
	}
	
//	private static void enhance(byte[] is) {
//		ClassReader cr = new ClassReader(is);
//		ClassNode cn = new ClassNode();
//		cr.accept(cn, 0);
//		for (Object object : cn.methods) {    
//		   MethodNode mn = (MethodNode) object;   
//		   if ("<init>".equals(mn.name) || "<clinit>".equals(mn.name)) {        
//		      continue;    
//		   }    
//		   InsnList insns = mn.instructions;    
//		   InsnList il = new InsnList();   
//		   il.add(new FieldInsnNode(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"));    
//		   il.add(new LdcInsnNode("Enter method -> " + mn.name));   
//		   il.add(new MethodInsnNode(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V"));    
//		   insns.insert(il);  mn.maxStack += 3;
//		}
//		ClassWriter cw = new ClassWriter(0);
//		cn.accept(cw);
//		byte[] b = cw.toByteArray();
//	}
}