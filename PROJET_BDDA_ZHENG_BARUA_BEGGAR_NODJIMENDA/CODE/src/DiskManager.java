import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class DiskManager {

  public static DiskManager LeDisqueManager = new DiskManager();
  //private static byte[] buffer ;
  //nous utileserons une table pour les case libre et une table pour les cases remplie
  public ArrayList<PageId> pageDispo = new ArrayList<PageId>();
  public ArrayList<PageId> pageNonDispo = new ArrayList<PageId>();


  public DiskManager getDisque(){
    return LeDisqueManager;
  }




  public PageId allocPage(){
    PageId page = new PageId();
    int numero_fichier = 0;
    int numero_page = 0;

    if (pageDispo.size()==0){
      File fichier = new File(DBParams.DBPath + "/f" +numero_fichier + ".bdda");

      if (fichier.exists()){
        numero_fichier +=1;
      }

      else{
        fichier.createNewFile();
        for (int i=0; i<DBParams.maxPagesPerFile;i++){
          PageId pages= new PageId(numero_fichier,i);
          pageDispo.add(pages);
        }
        pageNonDispo.add(pageDispo(0));
        pageDispo.remove(0);
        page =pageNonDispo.size()

        return page;
      }
    }

    else {
      page = PageDispo.size();
      PageDispo.remove(0);
      return page;

    }
  }



  public void ReadPage (PageId pageId, ByteBuffer buffer){

    RandomAccessFile lecture = new RandomAccessFile (DBParams.DBPath+"/f"+ pageId.getId+".bdda","r");

    lecture.seek(pageId.getIndice*DBParams.pageSize);
    for (int i=0; i<DBParams.pageSize;i++){
      buffer.put(i,lecture.readByte());
    }

    lecture.close;    
  }




  public void WritePage (PageId pageId, ByteBuffer buffer) {

    RandomAccessFile lecture = new RandomAccessFile (DBParams.DBPath+"/f"+ pageId.getId+".bdda","rw");

		lecture.seek(pageId.getIndice*DBParams.pageSize);
		lecture.write(buffer);
		lecture.close();
    
  }

  public void DeallocPage(PageId pageId) {

    int indice;
    for (int i=0; i<pageNonDispo.size();i++){
      if (pageNonDispo(i).getId==pageId.getId && pageNonDispo(i).getIndice==pageId.getIndice){
        indice =i;
      }
    }
    pageNonDispo.remove(indice);
    pageDispo.add(pageId);

  }

  public int GetCurrentCountAllocPages() {

    return pageNonDispo.size();

  }


}