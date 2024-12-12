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
        buffer.put((byte) 1).put((byte) 2);
        buffer.flip();
        byte[] dst = new byte[2];
        buffer.get(dst);
        assertArrayEquals(new byte[] {1, 2}, dst);
    }
    
    // get(byte[] dst, int offset, int length)
    @Test
    void deveLerBytesComOffsetEComprimentoCorretos() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put((byte) 1).put((byte) 2).put((byte) 3);
        buffer.flip();
        
        byte[] dst = new byte[5];
        buffer.get(dst, 1, 2);
        
        assertArrayEquals(new byte[] {0, 1, 2, 0, 0}, dst);
    }
    
    // get(int index)
    @Test
    void deveLerByteCorretamenteNoIndiceEspecificado() {
    	ByteBuffer buffer = ByteBuffer.allocate(10);
    	buffer.put((byte) 1).put((byte) 2).put((byte) 3);
    	buffer.flip();
    	assertEquals(2, buffer.get(1));
    }
    
    // getChar()
    @Test
    void deveLerCharCorretamente() {
    	ByteBuffer buffer = ByteBuffer.allocate(10);
    	buffer.putChar('A');
    	buffer.flip();
    	assertEquals('A', buffer.getChar());
    }
}
