package prova121224.buffer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.ByteBuffer;

import org.junit.jupiter.api.Test;

class ByteBufferTests {
	
	// allocate()
	@Test
	void deveCriarBufferComTamanhoEspecificado() {
		ByteBuffer buffer = ByteBuffer.allocate(10);
		assertEquals(10, buffer.capacity());
	}
	
	// allocateDirect()
	@Test
	void deveCriarBufferDiretoComTamanhoEspecificado() {
		ByteBuffer buffer = ByteBuffer.allocateDirect(10);
		assertEquals(10, buffer.capacity());
	}
	
	// array()
	@Test
	void deveRetornarArrayComTamanhoDoBuffer() {
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
	void deveConverterByteBufferParaCharBuffer() {
		ByteBuffer buffer = ByteBuffer.allocate(4).putChar('A').flip();
		assertEquals('A', buffer.asCharBuffer().get(0));
	}
	
	// asDoubleBuffer()
	@Test
	void deveConverterByteBufferParaDoubleBuffer() {
		ByteBuffer buffer = ByteBuffer.allocate(16).putDouble(1.23).flip();
		assertEquals(1.23, buffer.asDoubleBuffer().get(0), 0.01);
	}
	
	// asFloatBuffer()
	@Test
    void deveConverterByteBufferParaFloatBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(8).putFloat(1.23f).flip();
        assertEquals(1.23f, buffer.asFloatBuffer().get(0), 0.01f);
    }
	
	// asIntBuffer()
    @Test
    void deveConverterByteBufferParaIntBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(8).putInt(123).flip();
        assertEquals(123, buffer.asIntBuffer().get(0));
    }
    
    // asLongBuffer()
    @Test
    void deveConverterByteBufferParaLongBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(8).putLong(123L).flip();
        assertEquals(123L, buffer.asLongBuffer().get(0));
    }

    // asReadOnlyBuffer()
    @Test
    void deveConverterByteBufferParaReadOnlyBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(8).putInt(123).flip();
        assertTrue(buffer.asReadOnlyBuffer() instanceof ByteBuffer);
    }
}
