public static void setFieldValue(Object instance, String fieldName, Object value) {    try {        Field f = instance.getClass().getDeclaredField(fieldName);        Field unsafeField = Unsafe.class.getDeclaredField(&quot;theUnsafe&quot;);        unsafeField.setAccessible(true);        Unsafe unsafe = (Unsafe) unsafeField.get(null);        Field theInternalUnsafeField = Unsafe.class.getDeclaredField(&quot;theInternalUnsafe&quot;);        theInternalUnsafeField.setAccessible(true);        Object theInternalUnsafe = theInternalUnsafeField.get(null);        Method offset = Class.forName(&quot;jdk.internal.misc.Unsafe&quot;).getMethod(&quot;objectFieldOffset&quot;, Field.class);        unsafe.putBoolean(offset, 12, true);        unsafe.putObject(instance, (long) offset.invoke(theInternalUnsafe, f), value);    } catch (IllegalAccessException | NoSuchFieldException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {        e.printStackTrace();    }}