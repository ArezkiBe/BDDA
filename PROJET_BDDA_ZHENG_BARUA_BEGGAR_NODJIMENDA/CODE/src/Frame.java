import java.nio.ByteBuffer;

public class Frame {
	
	private ByteBuffer buffer;
		private PageId page;
	private int pin_count;
	private boolean dirty;
	
	private int der_util;
	
	public Frame (ByteBuffer buffer, PageId page, int pin_count,boolean dirty) {
		
		this.buffer=buffer;
		this.page=page;
		this.pin_count= pin_count;
		this.dirty=dirty;
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

	public boolean isDirty() {
		return dirty;
	}

	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}

	public int getDer_util() {
		return der_util;
	}

	public void setDer_util(int der_util) {
		this.der_util = der_util;
	}
	

}
