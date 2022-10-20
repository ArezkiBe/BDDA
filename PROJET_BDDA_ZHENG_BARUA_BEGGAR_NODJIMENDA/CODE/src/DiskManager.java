import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
//import java.util.StringTokenizer;


public class DiskManager {

	public static DiskManager DiskMan = new DiskManager();
	
	//nous utileserons une table pour les cases libres et une table pour les cases remplies
	public ArrayList<PageId> pageDispo = new ArrayList<PageId>();
	public ArrayList<PageId> pageAlloue = new ArrayList<PageId>();


	private DiskManager() {};

	public PageId allocPage(){
		PageId page = new PageId();
		int numero_fichier = 0;

		if (pageDispo.size()==0){
			
			//RandomAccessFile r = new RandomAccessFile(fichier,"rw");
			//r.close();
			

			for (;;) {
				String chemin = DBParams.DBPath + "/f" +numero_fichier + ".bdda";
				File fichier = new File(chemin);

				if (fichier.exists()){
					numero_fichier +=1;
				}

				else{
					try {
						fichier.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//RandomAccessFile r = new RandomAccessFile("C:\Users\DELL\Desktop\Notes\3"+".txt","rw");
					for (int i=0; i<DBParams.maxPagesPerFile;i++){
						PageId pages= new PageId(numero_fichier,i);
						this.pageDispo.add(pages);
					}
					this.pageAlloue.add(this.pageDispo.get(0));
					
					page = this.pageDispo.remove(0);
					
					//r.close();

					return page;
				}
			}
		}

		else {
			page = pageDispo.get(0);
			pageAlloue.add(page);
			pageDispo.remove(0);
			return page;

		}
		
	}



	public void ReadPage (PageId pageId, ByteBuffer buffer) throws IOException{
		
		File file = new File (DBParams.DBPath+"/f"+ pageId.getId()+".bdda","rw");
		
		RandomAccessFile lecture = new RandomAccessFile (file,"r");


		lecture.seek(pageId.getIndice()*DBParams.pageSize);
		for (int i=0; i<DBParams.pageSize;i++){
			buffer.put(i,lecture.readByte());
		}

		lecture.close();    
	}




	public void WritePage (PageId pageId, ByteBuffer buffer) throws IOException {

		RandomAccessFile ecriture = new RandomAccessFile (DBParams.DBPath+"/f"+ pageId.getId()+".bdda","rw");

		ecriture.seek(pageId.getIndice()*DBParams.pageSize);
		ecriture.write(buffer.array());
		ecriture.close();
    
	}

	public void DeallocPage(PageId pageId) {

		int indice=0;
		for (int i=0; i<pageAlloue.size();i++){
			if (pageAlloue.get(i).getId()==pageId.getId() && pageAlloue.get(i).getIndice()==pageId.getIndice()){
				indice =i;
			}
		}
		pageAlloue.remove(indice);
		pageDispo.add(pageId);

	}

	public int getCurrentCountAllocPages() {

		return pageAlloue.size();

	}
	
	public int getCurrentPagesDispo() {
		return pageDispo.size();
	}


}