package prova121224.buffer;

import java.nio.ByteBuffer;

interface ByteBufferData {
    public char CHARS_VALUE = 'A';
    public float FLOAT_VALUE = 1.23F;
    public double DOUBLE_VALUE = 1.23;
    public int INT_VALUE = 123;
    public long LONG_VALUE = 123L;
    public short SHORT_VALUE = 123;
    
    public byte[] BUFFER_CAPACITY = {2, 3, 4, 5, 8, 10, 16};
    public byte[] BYTE_ARRAY_SIZE = new byte[3];
    public byte[] byteArray = {10, 20, 30, 40, 50, 60};
    
    public ByteBuffer BUFFER_2 = ByteBuffer.allocate(BUFFER_CAPACITY[0]);
    public ByteBuffer BUFFER_3 = ByteBuffer.allocate(BUFFER_CAPACITY[1]);
    public ByteBuffer BUFFER_4 = ByteBuffer.allocate(BUFFER_CAPACITY[2]);
    public ByteBuffer BUFFER_5 = ByteBuffer.allocate(BUFFER_CAPACITY[3]);
    public ByteBuffer BUFFER_8 = ByteBuffer.allocate(BUFFER_CAPACITY[4]);
    public ByteBuffer BUFFER_8_ORDER = ByteBuffer.allocate(BUFFER_CAPACITY[4]);
    public ByteBuffer BUFFER_10 = ByteBuffer.allocate(BUFFER_CAPACITY[5]);
    public ByteBuffer BUFFER_16 = ByteBuffer.allocate(BUFFER_CAPACITY[6]);
    public ByteBuffer BUFFER_COMPARE = ByteBuffer.allocate(BUFFER_CAPACITY[3]);
    public ByteBuffer BUFFER_DIRECT = ByteBuffer.allocateDirect(BUFFER_CAPACITY[0]);
    public ByteBuffer BUFFER_WRAP = ByteBuffer.wrap(byteArray);

    public byte[] buffer2Array = BUFFER_2.array();
}
