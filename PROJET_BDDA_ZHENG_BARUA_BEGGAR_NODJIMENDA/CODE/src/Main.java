//import java.io.File;
//import java.io.RandomAccessFile;


public class Main {

	public static void main(String[] args) { 
		DBParams.DBPath = "C:/Users/DELL/Desktop/PROJET_BDDA_ZHENG_BARUA_BEGGAR_NODJIMENDA/DB";
		DBParams.pageSize = 4096; 
		DBParams.maxPagesPerFile = 4;
		DBParams.frameCount = 2;

		PageId page= new PageId();
		
		System.out.println(DiskManager.DiskMan.getCurrentCountAllocPages());
		System.out.println(DiskManager.DiskMan.getCurrentPagesDispo());
		
		page =DiskManager.DiskMan.allocPage();		
		System.out.println(DiskManager.DiskMan.getCurrentCountAllocPages());
		System.out.println(DiskManager.DiskMan.getCurrentPagesDispo());

		DiskManager.DiskMan.allocPage();
		System.out.println(DiskManager.DiskMan.getCurrentCountAllocPages());
		System.out.println(DiskManager.DiskMan.getCurrentPagesDispo());

		DiskManager.DiskMan.allocPage();
		System.out.println(DiskManager.DiskMan.getCurrentCountAllocPages());
		System.out.println(DiskManager.DiskMan.getCurrentPagesDispo());

		DiskManager.DiskMan.DeallocPage(page);
		System.out.println(DiskManager.DiskMan.getCurrentCountAllocPages());
		System.out.println(DiskManager.DiskMan.getCurrentPagesDispo());







	}

}
 
