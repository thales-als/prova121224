package prova121224.buffer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

import org.junit.jupiter.api.Test;

class ByteBufferTests implements ByteBufferData {
    
    // allocate(int capacity)
    @Test
    void testMethodAllocate() {
        assertNotNull(BUFFER_2);
    }
    
    // allocateDirect(int capacity)
    @Test
    void testMethodAllocateDirect() {
        assertNotNull(BUFFER_DIRECT);
    }
    
    // array()
    @Test
    void testMethodArray() {
        assertNotNull(buffer2Array);
    }
    
    // arrayOffset()
    @Test
    void testMethodArrayOffset() {
        assertEquals(0, BUFFER_WRAP.arrayOffset());
    }
    
    // asCharBuffer()
    @Test
    void testMethodAsCharBuffer() {
        BUFFER_4
            .clear()
            .putChar(CHARS_VALUE)
            .flip();
        
        assertTrue(BUFFER_4.asCharBuffer() instanceof CharBuffer);
    }
    
    // asDoubleBuffer()
    @Test
    void testMethodAsDoubleBuffer() {
        BUFFER_16
            .clear()
            .putDouble(DOUBLE_VALUE)
            .flip();
        
        assertTrue(BUFFER_16.asDoubleBuffer() instanceof DoubleBuffer);
    }
    
    // asFloatBuffer()
    @Test
    void testMethodAsFloatBuffer() {
        BUFFER_8
            .clear()
            .putFloat(FLOAT_VALUE)
            .flip();
        
        assertTrue(BUFFER_8.asFloatBuffer() instanceof FloatBuffer);
    }
    
    // asIntBuffer()
    @Test
    void testMethodAsIntBuffer() {
        BUFFER_8
            .clear()
            .putInt(INT_VALUE)
            .flip();
        
        assertTrue(BUFFER_8.asIntBuffer() instanceof IntBuffer);
    }
    
    // asLongBuffer()
    @Test
    void testMethodAsLongBuffer() {
        BUFFER_8
            .clear()
            .putLong(LONG_VALUE)
            .flip();
        
        assertTrue(BUFFER_8.asLongBuffer() instanceof LongBuffer);
    }
    
    // asReadOnlyBuffer()
    @Test
    void testMethodAsReadOnlyBuffer() {
        BUFFER_8
            .clear()
            .putInt(INT_VALUE)
            .flip();
        
        assertTrue(BUFFER_8.asReadOnlyBuffer() instanceof ByteBuffer);
    }
    
    // asShortBuffer()
    @Test
    void testMethodAsShortBuffer() {
        BUFFER_8
            .clear()
            .putShort((short) SHORT_VALUE)
            .flip();
        
        assertTrue(BUFFER_8.asShortBuffer() instanceof ShortBuffer);
    }
    
    // compact()
    @Test
    void testMethodCompact() {
        BUFFER_10
            .clear()
            .put((byte) 1)
            .put((byte) 2)
            .put((byte) 3)
            .flip()
            .get();
        
        BUFFER_10.compact();
        
        assertEquals(2, BUFFER_10.position());
        assertEquals(BUFFER_10.capacity(), BUFFER_10.limit());
    }
    
    // compareTo()
    @Test
    void testMethodCompareTo() {
        BUFFER_8
            .clear()
            .putInt(INT_VALUE)
            .flip();
        
        BUFFER_COMPARE
            .clear()
            .putInt(INT_VALUE)
            .flip();
        
        assertEquals(0, BUFFER_8.compareTo(BUFFER_COMPARE));
    }
    
    // duplicate() and equals()
    @Test
    void testMethodsDuplicateAndEquals() {
        ByteBuffer duplicateBuffer = BUFFER_8.duplicate();
        boolean compare = duplicateBuffer.equals(BUFFER_8);
        assertNotNull(duplicateBuffer);
        assertTrue(compare);
    }
    
    // get()
    @Test
    void testMethodGet() {
        BUFFER_2
            .clear()
            .put((byte) 1)
            .flip();
        
        assertNotNull(BUFFER_2.get());
    }
    
    // get(byte[] dst)
    @Test
    void testMethodGetWithArrayIndexation() {
    	BUFFER_2
    		.clear()
    		.put((byte) 1)
    		.put((byte) 2)
    		.flip();
    	
    	byte[] dst = new byte[2];
    	BUFFER_2.get(dst);
    	assertArrayEquals(new byte[] {1, 2}, dst);
    }
    
    // get(byte[] dst, int offset, int length)
    @Test
    void testMethodGetWithOffsetAndLength() {
    	BUFFER_3
    		.clear()
    		.put((byte) 1)
    		.put((byte) 2)
    		.put((byte) 3)
    		.flip();
    	
    	byte[] dst = new byte[5];
    	BUFFER_3.get(dst, 1, 2);
    	
    	assertArrayEquals(new byte[] {0, 1, 2, 0, 0}, dst);
    }
    
    // get(int index)
    @Test
    void testMethodGetWithIndex() {
    	BUFFER_3
	    	.clear()
			.put((byte) 1)
			.put((byte) 2)
			.put((byte) 3)
			.flip();
    	
    	assertEquals(1, BUFFER_3.get(0));
    	assertEquals(2, BUFFER_3.get(1));
    	assertEquals(3, BUFFER_3.get(2));
    }
    
    // getChar() and getChar(int index)
    @Test
    void testMethodGetChar() {
        BUFFER_4
            .clear()
            .putChar(CHARS_VALUE)
            .flip();
        
        assertNotNull(BUFFER_4.getChar());
        assertEquals('A', BUFFER_4.getChar(0));
    }

    // getDouble() and getDouble(int index)
    @Test
    void testMethodGetDouble() {
        BUFFER_16
            .clear()
            .putDouble(DOUBLE_VALUE)
            .flip();
        
        assertNotNull(BUFFER_16.getDouble());
        assertEquals(1.23, BUFFER_16.getDouble(0));
    }

    // getFloat() and getFloat(int index)
    @Test
    void testMethodGetFloat() {
        BUFFER_8
            .clear()
            .putFloat(FLOAT_VALUE)
            .flip();
        
        assertNotNull(BUFFER_8.getFloat());
        assertEquals(1.23F, BUFFER_8.getFloat(0));
    }

    // getInt() and getInt(int index)
    @Test
    void testMethodGetInt() {
        BUFFER_8
            .clear()
            .putInt(INT_VALUE)
            .flip();
        
        assertNotNull(BUFFER_8.getInt());
        assertEquals(123, BUFFER_8.getInt(0));
    }

    // getLong() and getLong(int index)
    @Test
    void testMethodGetLong() {
        BUFFER_8
            .clear()
            .putLong(LONG_VALUE)
            .flip();
        
        assertNotNull(BUFFER_8.getLong());
        assertEquals(123L, BUFFER_8.getLong(0));
    }

    // getShort() and getShort(int index)
    @Test
    void testMethodGetShort() {
        BUFFER_8
            .clear()
            .putShort((short) SHORT_VALUE)
            .flip();
        
        assertNotNull(BUFFER_8.getShort());
        assertEquals(123, BUFFER_8.getShort(0));
    }

    // hasArray()
    @Test
    void testMethodHasArray() {
        assertTrue(BUFFER_WRAP.hasArray());
    }
    
    // hashCode()
    @Test
    void testMethodHasCode() {
    	BUFFER_2.clear();
    	ByteBuffer bufferHashCode = BUFFER_2.duplicate();
    	assertEquals(BUFFER_2.hashCode(), bufferHashCode.hashCode());
    }
    
    // isDirect()
    @Test
    void testMethodIsDirect() {
        assertTrue(BUFFER_DIRECT.isDirect());
    }
    
    // order() and order(ByteOrder bo)
    @Test
    void testMethodOrder() {
    	BUFFER_8_ORDER
    		.clear()
    		.order(ByteOrder.LITTLE_ENDIAN);
    	
    	assertEquals(ByteOrder.LITTLE_ENDIAN, BUFFER_8_ORDER.order());
    	
    	BUFFER_8_ORDER
			.clear()
			.order(ByteOrder.BIG_ENDIAN);
    	
    	assertEquals(ByteOrder.BIG_ENDIAN, BUFFER_8_ORDER.order());
    }

    // put(byte b)
    @Test
    void testMethodPutByte() {
        BUFFER_2
        	.clear()
        	.put((byte) 5);
        
        assertNotNull(BUFFER_2);
    }
    
    // put(byte[] src)
    @Test
    void testMethodPut() {
        BYTE_ARRAY_SIZE[0] = 10;
        BYTE_ARRAY_SIZE[1] = 20;
        BYTE_ARRAY_SIZE[2] = 30;
        
        BUFFER_10
        	.clear()
        	.put(BYTE_ARRAY_SIZE)
        	.flip();
        
        assertNotNull(BUFFER_10);
        assertEquals(10, BUFFER_10.get());
        assertEquals(20, BUFFER_10.get());
        assertEquals(30, BUFFER_10.get());
    }

    // put(byte[] src, int offset, int length)
    @Test
    void testMethodPutWithOffsetAndLength() {
        BUFFER_5
        	.clear()
        	.put(byteArray, 2, 3)
        	.flip();
        
        assertNotNull(BUFFER_5);
        assertEquals(30, BUFFER_5.get());
        assertEquals(40, BUFFER_5.get());
        assertEquals(50, BUFFER_5.get());
    }

    // put(ByteBuffer src)
    @Test
    void testMethodPutFromByteBuffer() {
        BUFFER_8
        	.clear()
        	.put(new byte[] {1, 2, 3, 4, 5})
        	.flip();
        
        BUFFER_16
        	.clear()
        	.put(BUFFER_8)
        	.flip();
        
        assertNotNull(BUFFER_8);
        assertNotNull(BUFFER_16);
    }

    // put(int index, byte b)
    @Test
    void testMethodPutAtIndex() {
        BUFFER_8
        	.clear()
        	.put(0, (byte) 10)
            .put(1, (byte) 20)
            .put(2, (byte) 30);
        
        assertNotNull(BUFFER_8);
        assertEquals(10, BUFFER_8.get(0));
        assertEquals(20, BUFFER_8.get(1));
        assertEquals(30, BUFFER_8.get(2));
    }

    // putChar(char value)
    @Test
    void testMethodPutChar() {
        BUFFER_4
        	.clear()
        	.putChar(CHARS_VALUE);
        
        assertNotNull(BUFFER_4);
    }

    // putDouble(double value)
    @Test
    void testMethodPutDouble() {
        BUFFER_16
        	.clear()
        	.putDouble(DOUBLE_VALUE);
        
        assertNotNull(BUFFER_16);
    }

    // putFloat(float value)
    @Test
    void testMethodPutFloat() {
        BUFFER_8
        	.clear()
        	.putFloat(FLOAT_VALUE);
        
        assertNotNull(BUFFER_8);
    }

    // putInt(int value)
    @Test
    void testMethodPutInt() {
        BUFFER_8
        	.clear()
        	.putInt(INT_VALUE);
        
        assertNotNull(BUFFER_8);
    }

    // putLong(long value)
    @Test
    void testMethodPutLong() {
        BUFFER_8
        	.clear()
        	.putLong(LONG_VALUE);
        
        assertNotNull(BUFFER_8);
    }

    // putShort(short value)
    @Test
    void testMethodPutShort() {
        BUFFER_8
        	.clear()
        	.putShort((short) SHORT_VALUE);
        
        assertNotNull(BUFFER_8);
    }
    
    // putChar(int index, char value)
    @Test
    void testMethodPutCharWithIndex() {
        BUFFER_4
            .clear()
            .putChar(0, CHARS_VALUE);
        
        assertEquals(CHARS_VALUE, BUFFER_4.getChar(0));
    }

    // putDouble(int index, double value)
    @Test
    void testMethodPutDoubleWithIndex() {
        BUFFER_16
            .clear()
            .putDouble(0, DOUBLE_VALUE);
        
        assertEquals(DOUBLE_VALUE, BUFFER_16.getDouble(0));
    }

    // putFloat(int index, float value)
    @Test
    void testMethodPutFloatWithIndex() {
        BUFFER_8
            .clear()
            .putFloat(0, FLOAT_VALUE);
        
        assertEquals(FLOAT_VALUE, BUFFER_8.getFloat(0));
    }

    // putInt(int index, int value)
    @Test
    void testMethodPutIntWithIndex() {
        BUFFER_8
            .clear()
            .putInt(0, INT_VALUE);
        
        assertEquals(INT_VALUE, BUFFER_8.getInt(0));
    }

    // putLong(int index, long value)
    @Test
    void testMethodPutLongWithIndex() {
        BUFFER_8
            .clear()
            .putLong(0, LONG_VALUE);
        
        assertEquals(LONG_VALUE, BUFFER_8.getLong(0));
    }

    // putShort(int index, short value)
    @Test
    void testMethodPutShortWithIndex() {
        BUFFER_8
            .clear()
            .putShort(0, (short) SHORT_VALUE);
        
        assertEquals((short) SHORT_VALUE, BUFFER_8.getShort(0));
    }


    // slice()
    @Test
    void testMethodSlice() {
        BUFFER_10
        	.clear()
        	.put((byte) 1)
        	.put((byte) 2)
        	.flip();
        
        ByteBuffer slicedBuffer = BUFFER_10.slice();
        assertNotNull(slicedBuffer);
        assertEquals(2, slicedBuffer.remaining());
    }

    // wrap(byte[] array)
    @Test
    void testMethodWrap() {
        BUFFER_WRAP.clear();
        assertNotNull(BUFFER_WRAP);
    }

    // wrap(byte[] array, int offset, int length)
    @Test
    void testMethodWrapWithOffset() {
        ByteBuffer buffer = ByteBuffer.wrap(byteArray, 2, 3);
        assertNotNull(buffer);
    }
}