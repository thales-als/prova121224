package prova121224.buffer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

import org.junit.jupiter.api.Test;

class ByteBufferTests {
	
	// allocate()
	@Test
	void deveCriarBufferComCapacidadeEspecificada() {
		ByteBuffer buffer = ByteBuffer.allocate(10);
		assertEquals(10, buffer.capacity());
	}
	
	// allocateDirect()
	@Test
	void deveCriarBufferDiretoComCapacidadeEspecificada() {
		ByteBuffer buffer = ByteBuffer.allocateDirect(10);
		assertEquals(10, buffer.capacity());
	}
	
	// array()
	@Test
	void deveRetornarArrayComOMesmoTamanhoDoBuffer() {
		ByteBuffer buffer = ByteBuffer.allocate(10);
		byte[] array = buffer.array();
		assertEquals(10, array.length);
	}
	
	// arrayOffset()
	@Test
	void deveRetornarZeroQuandoBufferForEnvolvidoComArrayDeBytes() {
		ByteBuffer buffer = ByteBuffer.wrap(new byte[10]);
		assertEquals(0, buffer.arrayOffset());
	}
	
	// asCharBuffer()
	@Test
	void deveConverterByteBufferParaCharBufferCorretamente() {
		ByteBuffer buffer = ByteBuffer.allocate(4).putChar('A').flip();
		assertEquals('A', buffer.asCharBuffer().get(0));
	}
	
	// asDoubleBuffer()
	@Test
	void deveConverterByteBufferParaDoubleBufferCorretamente() {
		ByteBuffer buffer = ByteBuffer.allocate(16).putDouble(1.23).flip();
		assertEquals(1.23, buffer.asDoubleBuffer().get(0), 0.01);
	}
	
	// asFloatBuffer()
	@Test
    void deveConverterByteBufferParaFloatBufferCorretamente() {
        ByteBuffer buffer = ByteBuffer.allocate(8).putFloat(1.23f).flip();
        assertEquals(1.23f, buffer.asFloatBuffer().get(0), 0.01f);
    }
	
	// asIntBuffer()
    @Test
    void deveConverterByteBufferParaIntBufferCorretamente() {
        ByteBuffer buffer = ByteBuffer.allocate(8).putInt(123).flip();
        assertEquals(123, buffer.asIntBuffer().get(0));
    }
    
    // asLongBuffer()
    @Test
    void deveConverterByteBufferParaLongBufferCorretamente() {
        ByteBuffer buffer = ByteBuffer.allocate(8).putLong(123L).flip();
        assertEquals(123L, buffer.asLongBuffer().get(0));
    }

    // asReadOnlyBuffer()
    @Test
    void deveConverterByteBufferParaBufferSomenteLeitura() {
        ByteBuffer buffer = ByteBuffer.allocate(8).putInt(123).flip();
        assertTrue(buffer.asReadOnlyBuffer() instanceof ByteBuffer);
    }
    
    // asShortBuffer()
    @Test
    void deveConverterByteBufferParaShortBufferCorretamente() {
        ByteBuffer buffer = ByteBuffer.allocate(8).putShort((short) 123).flip();
        assertTrue(buffer.asShortBuffer() instanceof ShortBuffer);
    }

    // compact()
    @Test
    void deveCompactarBufferCorretamenteApósLeitura() {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        buffer.put((byte) 1)
              .put((byte) 2)
              .put((byte) 3)
              .flip()
              .get();

        buffer.compact();

        assertEquals(2, buffer.get(0));
        assertEquals(3, buffer.get(1));
    }

    // compareTo()
    @Test
    void deveCompararDoisByteBuffersCorretamente() {
        ByteBuffer buffer1 = ByteBuffer.allocate(8).putInt(123).flip();
        ByteBuffer buffer2 = ByteBuffer.allocate(8).putInt(123).flip();
        assertEquals(0, buffer1.compareTo(buffer2));
    }
    
    // duplicate()
    @Test
    void deveDuplicarBufferCorretamente() {
    	ByteBuffer buffer1 = ByteBuffer.allocate(10);
    	ByteBuffer buffer2 = buffer1.duplicate();
    	assertEquals(buffer1, buffer2);
    }
    
    // equals()
    @Test
    void deveCompararDoisByteBuffersIgualdadeCorretamente() {
    	ByteBuffer buffer1 = ByteBuffer.allocate(10);
    	ByteBuffer buffer2 = ByteBuffer.allocate(10);
    	boolean compare = buffer1.equals(buffer2);
    	assertTrue(compare);
    }
    
    // get()
    @Test
    void deveLerPrimeiroByteCorretamente() {
    	ByteBuffer buffer = ByteBuffer.allocate(10);
    	buffer.put((byte) 1);
    	buffer.flip();
    	assertEquals(1, buffer.get());
    }
    
    // get(byte[] dst)
    @Test
    void deveArmazenarBytesCorretamenteNoArray() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer
        	.put((byte) 1)
        	.put((byte) 2);
        buffer.flip();
        byte[] dst = new byte[2];
        buffer.get(dst);
        assertArrayEquals(new byte[] {1, 2}, dst);
    }
    
    // get(byte[] dst, int offset, int length)
    @Test
    void deveLerBytesComOffsetEComprimentoCorretos() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer
        	.put((byte) 1)
        	.put((byte) 2)
        	.put((byte) 3);
        buffer.flip();
        
        byte[] dst = new byte[5];
        buffer.get(dst, 1, 2);
        
        assertArrayEquals(new byte[] {0, 1, 2, 0, 0}, dst);
    }
    
    // get(int index)
    @Test
    void deveLerByteCorretamenteNoIndiceEspecificado() {
    	ByteBuffer buffer = ByteBuffer.allocate(3);
    	buffer
    		.put((byte) 1)
    		.put((byte) 2)
    		.put((byte) 3);
    	
    	buffer.flip();
    	assertEquals(1, buffer.get(0));
    	assertEquals(2, buffer.get(1));
    	assertEquals(3, buffer.get(2));
    }
    
    // getChar()
    @Test
    void deveLerCharCorretamente() {
    	ByteBuffer buffer = ByteBuffer.allocate(2);
    	buffer.putChar('A');
    	buffer.flip();
    	assertEquals('A', buffer.getChar());
    }
    
    // getChar(int index)
    @Test
    void deveLerCharCorretamenteNoIndiceEspecificado() {
    	ByteBuffer buffer = ByteBuffer.allocate(4);
    	buffer
    		.putChar('A')
    		.putChar('B');
    	buffer.flip();
    	assertEquals('A', buffer.getChar(0));
    	assertEquals('B', buffer.getChar(2));
    }
    
    // getDouble()
    @Test
    void deveLerDoubleCorretamente() {
    	ByteBuffer buffer = ByteBuffer.allocate(8);
    	buffer.putDouble(1.0);
    	buffer.flip();
    	assertEquals(1.0, buffer.getDouble());
    }
    
    // getDouble(int index)
    @Test
    void deveLerDoubleCorretamenteNoIndiceEspecificado() {
    	ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer
        	.putDouble(1.5)
        	.putDouble(2.5);
        buffer.flip();
        assertEquals(1.5, buffer.getDouble(0));
        assertEquals(2.5, buffer.getDouble(8));
    }
    
    // getFloat()
    @Test
    void deveLerFloatCorretamente() {
    	ByteBuffer buffer = ByteBuffer.allocate(4);
    	buffer.putFloat(1.5F);
    	buffer.flip();
    	assertEquals(1.5F, buffer.getFloat(0));
    }
    
    // getFloat(int index)
    @Test
    void deveLerFloatCorretamenteNoIndiceEspecificado() {
    	ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer
        	.putFloat(1.5F)
        	.putFloat(2.5F);
        buffer.flip();
        assertEquals(1.5F, buffer.getFloat(0));
        assertEquals(2.5F, buffer.getFloat(4));
    }
    
    // getInt()
    @Test
    void deveLerIntCorretamente() {
    	ByteBuffer buffer = ByteBuffer.allocate(4);
    	buffer.putInt(1);
    	buffer.flip();
    	assertEquals(1, buffer.getInt());
    }
    
    // getInt(int index)
    @Test
    void deveLerIntCorretamenteNoIndiceEspecificado() {
    	ByteBuffer buffer = ByteBuffer.allocate(8);
    	buffer
    		.putInt(1)
    		.putInt(2);
    	buffer.flip();
    	assertEquals(1, buffer.getInt(0));
    	assertEquals(2, buffer.getInt(4));
    }
    
    // getLong()
    @Test
    void deveLerLongCorretamente() {
    	ByteBuffer buffer = ByteBuffer.allocate(8);
    	buffer.putLong(1L);
    	buffer.flip();
    	assertEquals(1L, buffer.getLong());
    }
    
    // getLong(int index)
    @Test
    void deveLerLongCorretamenteNoIndiceEspecificado() {
    	ByteBuffer buffer = ByteBuffer.allocate(16);
    	buffer
    		.putLong(1L)
    		.putLong(2L);
    	buffer.flip();
    	assertEquals(1L, buffer.getLong(0));
    	assertEquals(2L, buffer.getLong(8));
    }
    
    // getShort()
    @Test
    void deveLerShortCorretamente() {
    	ByteBuffer buffer = ByteBuffer.allocate(2);
    	buffer.putShort((short) 1);
    	buffer.flip();
    	assertEquals(1, buffer.getShort());
    }
    
    // getShort(int index)
    @Test
    void deveLerShortCorretamenteNoIndiceEspecificado() {
    	ByteBuffer buffer = ByteBuffer.allocate(4);
    	buffer
    		.putShort((short) 1)
    		.putShort((short) 2);
    	buffer.flip();
    	assertEquals(1, buffer.getShort(0));
    	assertEquals(2, buffer.getShort(2));
    }
}
