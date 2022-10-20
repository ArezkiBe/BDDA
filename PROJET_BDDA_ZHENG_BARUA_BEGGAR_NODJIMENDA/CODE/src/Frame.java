import java.nio.ByteBuffer;

public class Frame {
	
	private ByteBuffer buffer;
	private PageId page;
	private int pin_count;
	private int dirty;
	
	private long der_util;
	
	public Frame() {
		this.buffer=ByteBuffer.allocate(DBParams.pageSize);
		this.page = null;
		this.pin_count=0;
		this.dirty=0;
		this.der_util=-1;
	}
	
	public ByteBuffer getBuffer() {
		return buffer;
	}

	public void setBuffer(ByteBuffer buffer) {
		this.buffer = buffer;
	}

	public PageId getPage() {
		return page;
	}

	public void setPage(PageId page) {
		this.page = page;
	}

	public int getPin_count() {
		return pin_count;
	}

	public void setPin_count(int pin_count) {
		this.pin_count = pin_count;
	}

	public int isDirty() {
		return dirty;
	}

	public void setDirty(int dirty) {
		this.dirty = dirty;
	}

	public long getDer_util() {
		return der_util;
	}

	public void setDer_util(int der_util) {
		this.der_util = der_util;
	}
	
	public void incrementerPin() {
		this.pin_count++;
	}
	
	public void decrementerPin() {
		if (this.pin_count>0) this.pin_count--;
		if (this.pin_count==0) this.der_util=System.currentTimeMillis();
	}
	

}
