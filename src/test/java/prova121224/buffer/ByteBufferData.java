package prova121224.buffer;

import java.nio.ByteBuffer;

interface ByteBufferData {
    public static final char CHARS_VALUE = 'A';
    public static final float FLOAT_VALUE = 1.23F;
    public static final double DOUBLE_VALUE = 1.23;
    public static final int INT_VALUE = 123;
    public static final long LONG_VALUE = 123L;
    public static final short SHORT_VALUE = 123;
    
    public static final byte[] BUFFER_CAPACITY = {2, 3, 4, 5, 8, 10, 16};
    public static byte[] BYTE_ARRAY_SIZE = new byte[3];
    public static byte[] byteArray = {10, 20, 30, 40, 50, 60};
    
    public static final ByteBuffer BUFFER_2 = ByteBuffer.allocate(BUFFER_CAPACITY[0]);
    public static final ByteBuffer BUFFER_3 = ByteBuffer.allocate(BUFFER_CAPACITY[1]);
    public static final ByteBuffer BUFFER_4 = ByteBuffer.allocate(BUFFER_CAPACITY[2]);
    public static final ByteBuffer BUFFER_5 = ByteBuffer.allocate(BUFFER_CAPACITY[3]);
    public static final ByteBuffer BUFFER_8 = ByteBuffer.allocate(BUFFER_CAPACITY[4]);
    public static final ByteBuffer BUFFER_8_ORDER = ByteBuffer.allocate(BUFFER_CAPACITY[4]);
    public static final ByteBuffer BUFFER_10 = ByteBuffer.allocate(BUFFER_CAPACITY[5]);
    public static final ByteBuffer BUFFER_16 = ByteBuffer.allocate(BUFFER_CAPACITY[6]);
    public static final ByteBuffer BUFFER_COMPARE = ByteBuffer.allocate(BUFFER_CAPACITY[3]);
    public static final ByteBuffer BUFFER_DIRECT = ByteBuffer.allocateDirect(BUFFER_CAPACITY[0]);
    public static final ByteBuffer BUFFER_WRAP = ByteBuffer.wrap(byteArray);

    public static final byte[] buffer2Array = BUFFER_2.array();
}
