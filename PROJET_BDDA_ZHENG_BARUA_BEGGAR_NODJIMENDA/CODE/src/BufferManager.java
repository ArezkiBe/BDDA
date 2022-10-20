import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class BufferManager {
	private static BufferManager INSTANCE;
	private ArrayList<Frame> bufferp;


	private BufferManager() {
		bufferp = new ArrayList<Frame>();
		for (int i = 0; i < DBParams.frameCount; i++) {
			bufferp.add(new Frame());
		}
	}


	public static synchronized BufferManager getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new BufferManager();
			return INSTANCE;
		} else
			return INSTANCE;
	}


	public ByteBuffer getPage(PageId pageId) throws IOException {

		for (int i = 0; i < bufferp.size(); i++) {
			Frame fr = bufferp.get(i);
			if (fr.getPage() == null)
				continue;
			if (fr.getPage().equals(pageId)) {
				fr.incrementerPin();
				return fr.getBuffer();
			}
		}

		for (int i = 0; i < bufferp.size(); i++) {
			Frame fr = bufferp.get(i);
			if (fr.getPage() == (null)) {
				DiskManager.DiskMan.ReadPage(pageId, fr.getBuffer());
				fr.setPage(pageId);
				fr.incrementerPin();
				return fr.getBuffer();
			}
		}

		for (int i = 0; i < bufferp.size(); i++) {
			Frame fr = bufferp.get(i);
			if (fr.getPin_count() == 0) {
				if (fr.isDirty() == 1) {
					DiskManager.DiskMan.WritePage(pageId, null);
				}

				fr.setDirty(0);
				DiskManager.DiskMan.ReadPage(pageId, fr.getBuffer());
				fr.setPage(pageId);
				fr.incrementerPin();
				return fr.getBuffer();
			}
		}
		
		return null;
	}


	public void freePage(PageId pageId, int valdirty) {
		for (int i = 0; i < bufferp.size(); i++) {
			Frame fr = bufferp.get(i);
			if (fr.getPage() == null)
				continue;
			if (fr.getPage().equals(pageId)) {
				fr.decrementerPin();
				fr.setDirty(valdirty);
				return;
			}
		}
	}


	public void flushAll() throws IOException {
		for (int i = 0; i < bufferp.size(); i++) {
			Frame fr = bufferp.get(i);
			if (fr.isDirty() == 1) {
				DiskManager.DiskMan.WritePage(null, null);
			}
			bufferp.set(i, new Frame());
			fr = new Frame();
		}
	}


	public void reset() throws IOException {
		flushAll();
	}
}