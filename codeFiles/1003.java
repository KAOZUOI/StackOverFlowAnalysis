   private void setObjFieldValues(Object obj, Object[] vals, boolean dryRun) {        if (obj == null) {            throw new NullPointerException();        }        for (int i = numPrimFields; i < fields.length; i++) {            long key = writeKeys[i];            if (key == Unsafe.INVALID_FIELD_OFFSET) {                continue;           // discard value            }            switch (typeCodes[i]) {                case 'L', '[' -> {                    Object val = vals[offsets[i]];                    if (val != null &&                        !types[i - numPrimFields].isInstance(val))                    {                        Field f = fields[i].getField();                        throw new ClassCastException(                            &quot;cannot assign instance of &quot; +                            val.getClass().getName() + &quot; to field &quot; +                            f.getDeclaringClass().getName() + &quot;.&quot; +                            f.getName() + &quot; of type &quot; +                            f.getType().getName() + &quot; in instance of &quot; +                            obj.getClass().getName());                    }                    if (!dryRun)                        unsafe.putReference(obj, key, val);                }                default -> throw new InternalError();            }        }    }