package by.teachmeskills.lesson_other.decorator_list;

import sun.misc.Unsafe;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ReflectionUtil {
    public static Consumer<AccessibleObject> doUnsafeMagic() throws Throwable {
        // first we just need to get instance of unsafe, you can get shared static instance or just create own one:
        Constructor<Unsafe> unsafeConstructor = Unsafe.class.getDeclaredConstructor();
        unsafeConstructor.setAccessible(true);
        Unsafe unsafe = unsafeConstructor.newInstance();

        // now we need to get our method that we want to edit:
        Method setAccessible = AccessibleObject.class.getDeclaredMethod("setAccessible0", boolean.class);

        // now we need to get field where modifiers of method are stored, and use unsafe to find offset from object header to this field:
        Field methodModifiers = Method.class.getDeclaredField("modifiers");
        long methodModifiersOffset = unsafe.objectFieldOffset(methodModifiers);

        // and now we set this modifiers field for our method to new value - just simple public modifier.
        unsafe.getAndSetInt(setAccessible, methodModifiersOffset, Modifier.PUBLIC);

        // and now we can prepare our function as simple reflections invoke call:
        return obj -> {
            try {
                setAccessible.invoke(obj, true);
            } catch (Exception e) {
                throw new RuntimeException(e); // you definitely should do this in a different way :D
            }
        };
    }

    public static void main(String[] args) throws Throwable {
        Consumer<AccessibleObject> setAccessible = doUnsafeMagic();
        Field elementDataField = ArrayList.class.getDeclaredField("elementData");
        setAccessible.accept(elementDataField);

        List<Integer> list = new ArrayList<>();
        Object[] elementData = (Object[]) elementDataField.get(list);
        System.out.println(Arrays.toString(elementData));

        list.add(1);
        elementData = (Object[]) elementDataField.get(list);
        System.out.println(Arrays.toString(elementData));
        System.out.println(elementData.length);

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        elementData = (Object[]) elementDataField.get(list);
        System.out.println(Arrays.toString(elementData));
        System.out.println(elementData.length);
    }
}
