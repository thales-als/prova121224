package prova121224.buffer;

import java.nio.ByteBuffer;

interface ByteBufferData {
    char CHARS_VALUE = 'A';
    float FLOAT_VALUE = 1.23F;
    double DOUBLE_VALUE = 1.23;
    int INT_VALUE = 123;
    long LONG_VALUE = 123L;
    short SHORT_VALUE = 123;
    
    byte[] BUFFER_CAPACITY = {2, 3, 4, 5, 8, 10, 16};
    byte[] BYTE_ARRAY_SIZE = new byte[3];
    byte[] byteArray = {10, 20, 30, 40, 50, 60};
    
    ByteBuffer BUFFER_2 = ByteBuffer.allocate(BUFFER_CAPACITY[0]);
    ByteBuffer BUFFER_3 = ByteBuffer.allocate(BUFFER_CAPACITY[1]);
    ByteBuffer BUFFER_4 = ByteBuffer.allocate(BUFFER_CAPACITY[2]);
    ByteBuffer BUFFER_5 = ByteBuffer.allocate(BUFFER_CAPACITY[3]);
    ByteBuffer BUFFER_8 = ByteBuffer.allocate(BUFFER_CAPACITY[4]);
    ByteBuffer BUFFER_8_ORDER = ByteBuffer.allocate(BUFFER_CAPACITY[4]);
    ByteBuffer BUFFER_10 = ByteBuffer.allocate(BUFFER_CAPACITY[5]);
    ByteBuffer BUFFER_16 = ByteBuffer.allocate(BUFFER_CAPACITY[6]);
    ByteBuffer BUFFER_COMPARE = ByteBuffer.allocate(BUFFER_CAPACITY[3]);
    ByteBuffer BUFFER_DIRECT = ByteBuffer.allocateDirect(BUFFER_CAPACITY[0]);
    ByteBuffer BUFFER_WRAP = ByteBuffer.wrap(byteArray);

    byte[] buffer2Array = BUFFER_2.array();
}