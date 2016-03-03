import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

public class test2 {
	public static void main(String args[]) throws IllegalAccessException, InvocationTargetException{
	classA a = new classA(10);
	classB b = new classB(20);
	BeanUtils.copyProperties(b,a);
	System.out.println(a.x);
	}
}
